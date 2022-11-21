package com.itender.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.itender.exception.FileException;
import com.itender.service.FileManager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FileManagerImpl implements FileManager {

    private final GoogleDriveManager googleDriveManager;

    @Autowired
    public FileManagerImpl(GoogleDriveManager googleDriveManager) {
        this.googleDriveManager = googleDriveManager;
    }

    @Override
    public String uploadFile(MultipartFile file) throws FileException {
        if (file == null || StringUtils.isEmpty(file.getOriginalFilename())) {
            throw new FileException("No file was provided to upload.", HttpStatus.BAD_REQUEST);
        }
        try {
            log.info("Uploading file {}", file.getOriginalFilename());
            File fileMetadata = new File();
            fileMetadata.setParents(Collections.singletonList(getFolderId("images")));
            fileMetadata.setName(file.getOriginalFilename());
            File uploadFile = googleDriveManager.getInstance()
                    .files()
                    .create(fileMetadata, new InputStreamContent(
                            file.getContentType(),
                            new ByteArrayInputStream(file.getBytes()))
                    )
                    .setFields("id").execute();
            log.info("File successfully uploaded with id {}", uploadFile.getId());
            return uploadFile.getId();
        } catch (Exception e) {
            log.error("Error: ", e);
            throw new FileException("Failed uploading file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public String getUrl(String id) throws GeneralSecurityException, IOException, FileException {
        log.info("Retrieving file URL with id {}", id);
        if (id != null) {
            return String.format("https://drive.google.com/uc?export=view&id=%s", id);
        }

        log.error("File with id {} not found in Drive.", id);
        throw new FileException("File not found.");
    }

    private String getFolderId(String path) throws Exception {
        String parentId = null;
        String[] folderNames = path.split("/");

        Drive driveInstance = googleDriveManager.getInstance();
        for (String name : folderNames) {
            parentId = findOrCreateFolder(parentId, name, driveInstance);
        }
        return parentId;
    }

    private String findOrCreateFolder(String parentId, String folderName, Drive driveInstance) throws Exception {
        String folderId = searchFolderId(parentId, folderName, driveInstance);
        // Folder already exists, so return id
        if (folderId != null) {
            return folderId;
        }
        //Folder don't exist, create it and return folderId
        File fileMetadata = new File();
        fileMetadata.setMimeType("application/vnd.google-apps.folder");
        fileMetadata.setName(folderName);

        if (parentId != null) {
            fileMetadata.setParents(Collections.singletonList(parentId));
        }
        return driveInstance.files().create(fileMetadata)
                .setFields("id")
                .execute()
                .getId();
    }

    private String searchFolderId(String parentId, String folderName, Drive service) throws Exception {
        String folderId = null;
        String pageToken = null;
        FileList result = null;

        File fileMetadata = new File();
        fileMetadata.setMimeType("application/vnd.google-apps.folder");
        fileMetadata.setName(folderName);

        do {
            String query = " mimeType = 'application/vnd.google-apps.folder' ";
            if (parentId == null) {
                query = query + " and 'root' in parents";
            } else {
                query = query + " and '" + parentId + "' in parents";
            }
            result = service.files().list().setQ(query)
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .setPageToken(pageToken)
                    .execute();

            for (File file : result.getFiles()) {
                if (file.getName().equalsIgnoreCase(folderName)) {
                    folderId = file.getId();
                }
            }
            pageToken = result.getNextPageToken();
        } while (pageToken != null && folderId == null);

        return folderId;
    }

}
