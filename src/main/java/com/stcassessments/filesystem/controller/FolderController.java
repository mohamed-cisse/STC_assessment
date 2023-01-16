package com.stcassessments.filesystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stcassessments.filesystem.entity.Item;
import com.stcassessments.filesystem.service.ItemService;
import com.stcassessments.filesystem.service.PermissionGroupsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class FolderController {
    @Autowired
    ItemService itemService;
    @Autowired
    PermissionGroupsService permissionGroupsService;




    @PostMapping(path = "create/folder")
    public String createFolder(@RequestBody String request) throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(request);

        Item item = mapper.convertValue(node.get("item"), Item.class);
        String email=  mapper.convertValue(node.get("email"), String.class);
        System.out.println(email+"  email");
        if( !itemService.checkPermission(email))
        {
            return "Unauthorised";
        }
        if(!permissionGroupsService.isExist(item.getPermissionGroupId()))
        {
            return "Permission group does not exist";

        }

        if(!(itemService.getParentType(item.getParentItemId()).equals("Space")))
        {
            return "Parent does not exist";
        }

        Optional<Item> item1 = itemService.getItemByNameAndParentItemId(item.getName(),item.getParentItemId());

        if (item1.isPresent()) {

                return "Folder already exist";

        }

        itemService.save(item);
        return "Folder created successfully";
    }

}
