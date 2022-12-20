package com.itender.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import org.springframework.web.multipart.MultipartFile;

import com.itender.exception.FileException;

public interface FileManager {

    String uploadFile(MultipartFile file) throws FileException;

    String getUrl(String id) throws GeneralSecurityException, IOException, FileException;

}
