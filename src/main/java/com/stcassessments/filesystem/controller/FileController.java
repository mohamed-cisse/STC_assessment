package com.stcassessments.filesystem.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stcassessments.filesystem.dto.FilesDto;
import com.stcassessments.filesystem.dto.ItemDto;
import com.stcassessments.filesystem.entity.Files;
import com.stcassessments.filesystem.entity.Item;
import com.stcassessments.filesystem.service.FilesService;
import com.stcassessments.filesystem.service.ItemService;
import com.stcassessments.filesystem.service.PermissionGroupsService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

import static org.graalvm.compiler.debug.DebugOptions.PrintGraphTarget.File;
@RestController
public class FileController {
    @Autowired
    ItemService itemService;
    @Autowired
    FilesService filesService;
    @Autowired
    PermissionGroupsService permissionGroupsService;




    @PostMapping(path = "create/file",  consumes = {"multipart/form-data","application/json"} )
    public String uploadFile(@ModelAttribute FilesDto filesDto, @RequestPart("item") ItemDto itemDto) throws IOException {

        Item item=itemDto.itemDtoToItem(itemDto);

       if( !checkFile(item, filesDto.getEmail(), filesDto.getBinary()).equals("valid"))
       {
           return "problem";
       }
       // Item item=filesDto.getItem();
        itemService.save(item);
        filesService.store(filesDto.getBinary().getBytes(),item.getId());

        return "File created successfully";
    }

    public String checkFile( @NotNull Item item, String email, MultipartFile binary)
    {
        if(item == null)
        {
            return "please provide file Item details ";
        }

        if (binary.isEmpty())
        {
            return "Please upload file";
        }
        if( !itemService.checkPermission(email))
        {
            return "Unauthorised";
        }

        if(!permissionGroupsService.isExist(item.getPermissionGroupId()))
        {
            return "Permission group does not exist";

        }

        if(!(itemService.getParentType(item.getParentItemId()).equals("Folder")))
        {
            return "Parent does not exist";
        }

        Optional<Item> item1 = itemService.getItemByNameAndParentItemId(item.getName(),item.getParentItemId());

        if (item1.isPresent()) {

            return "File already exist";

        }

        return "valid";

    }
}
