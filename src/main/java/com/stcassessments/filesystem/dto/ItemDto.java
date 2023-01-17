package com.stcassessments.filesystem.dto;

import com.stcassessments.filesystem.entity.Item;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
@Data
@RequiredArgsConstructor

public class ItemDto {
    private String name;

    private String type;

    private long parentItemId;

    private long permissionGroupId;


    public Item itemDtoToItem(ItemDto itemDto)
    {
        Item item= new Item(name,type,parentItemId,permissionGroupId);
        return item;
    }
}