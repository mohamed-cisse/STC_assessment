package com.stcassessments.filesystem.service;

import com.stcassessments.filesystem.entity.Item;
import com.stcassessments.filesystem.entity.Permissions;
import com.stcassessments.filesystem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;
    @Autowired
    PermissionsService permissionsService;
    @Autowired
    PermissionGroupsService permissionGroupsService;


    public void save(Item item) { itemRepository.save(item);}

    public Optional<Item> getItemByNameAndParentItemId(String name, long ParentItemId)
    {
        return itemRepository.getItemByNameAndParentItemId(name, ParentItemId);
    }

    public  boolean  checkPermission(String email)
    {
        Optional<Permissions> permission =permissionsService.getPermissionByEmail(email);
        if(!permission.isPresent())
        {

            return false;
        }

        if(permission.get().getPermissionLevel().equals( "VIEW"))
        {
            return false;
        }

        if(permissionGroupsService.isAdmin(
                permission.get().getGroupId() ))
        {
            return true;
        }
        return false;
    }

    public  String getParentType(long itemId) {
        Optional<Item> item= itemRepository.getItemById(itemId);


        return item.isPresent() ? item.get().getType():"";

    }

    public Item getItemById(long itemId) {
        Optional<Item> item= itemRepository.getItemById(itemId);

        return item.isPresent() ?  item.get():null ;

    }
}
