package com.itender.service.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.InputStreamContent;
import com.google.api.services.drive.model.File;
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
        try {
            if (file != null) {
                log.info("Uploading file {}", file.getOriginalFilename());
                File fileMetadata = new File();
                fileMetadata.setParents(Collections.singletonList(null));
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
            } else {
                return "Select file";
            }
        } catch (Exception e) {
            log.error("Error: ", e);
            throw new FileException("Failed uploading file " + file.getOriginalFilename(), e);
        }
    }

    @Override
    public String getUrl(String id) throws GeneralSecurityException, IOException, FileException {
        log.info("Retrieving file URL with id {}", id);
        if (id != null) {
            try {
                File file = googleDriveManager.getInstance().files().get(id)
                        .setFields("thumbnailLink")
                        .execute();

                return file.getThumbnailLink();
            } catch (GoogleJsonResponseException e) {
                if (HttpStatus.NOT_FOUND.value() == e.getStatusCode()) {
                    log.error("File with id {} not found in Drive.", id);
                    throw new FileException("File not found.");
                }
            }
        }

        log.error("File with id {} not found in Drive.", id);
        throw new FileException("File not found.");
    }

}
