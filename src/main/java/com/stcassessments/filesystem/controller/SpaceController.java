package com.stcassessments.filesystem.controller;

import com.stcassessments.filesystem.dto.ItemDto;
import com.stcassessments.filesystem.entity.Item;
import com.stcassessments.filesystem.service.ItemService;
import com.stcassessments.filesystem.service.PermissionGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpaceController {
    @Autowired
    ItemService itemService;
    @Autowired
    PermissionGroupsService permissionGroupsService;



    @PostMapping (path = "create/space")
    public String createSpace(@RequestBody ItemDto itemDto)
    {
        Item item=itemDto.itemDtoToItem(itemDto);

        if (itemService.getItemByNameAndParentItemId(item.getName(),item.getParentItemId()).isPresent()) {

            return "Space already exist";
        }

        if(!permissionGroupsService.isExist(item.getPermissionGroupId()))
        {
            return "Permission group does not exist";

        }
        itemService.save(item);
        return "Space created successfully";
    }
}
