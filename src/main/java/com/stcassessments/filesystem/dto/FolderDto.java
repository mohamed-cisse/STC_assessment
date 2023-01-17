package com.stcassessments.filesystem.dto;

import com.stcassessments.filesystem.entity.Item;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;



@NoArgsConstructor
@Data
public class FolderDto implements Serializable {

    private Item item;
    private String email;

}
