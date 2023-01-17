package com.stcassessments.filesystem.service;

import com.stcassessments.filesystem.entity.Files;
import com.stcassessments.filesystem.repository.FilesRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FilesService {

     @Autowired
    FilesRepository filesRepository;
    public Files store(byte[] file, long Item_id) throws IOException {

        Files FileDB = new Files( file,Item_id);


        return filesRepository.save(FileDB);
    }
}
