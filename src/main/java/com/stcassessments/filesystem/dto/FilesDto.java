package com.stcassessments.filesystem.dto;

import com.stcassessments.filesystem.entity.Item;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.io.Serializable;


@NoArgsConstructor
@Data
public class FilesDto implements Serializable {

    @Lob
    private MultipartFile binary;
//    private Item item;
    private String email;


}
