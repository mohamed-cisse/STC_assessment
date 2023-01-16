package com.stcassessments.filesystem.service;

import com.stcassessments.filesystem.entity.PermissionGroups;
import com.stcassessments.filesystem.repository.PermissionGroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionGroupsService {
    @Autowired
    PermissionGroupsRepository permissionGroupsRepository;

    public void save(PermissionGroups permissionGroups)
    {
        permissionGroupsRepository.save(permissionGroups);
    }

    public Optional<PermissionGroups> getPermissionGroups(String name)
    {
        return permissionGroupsRepository.getPermissionGroupsByGroupName(name);
    }


    public boolean isAdmin(long groupId) {
        Optional<PermissionGroups> permissionGroups= permissionGroupsRepository.getPermissionGroupsById(groupId);
        if(permissionGroups.isPresent())
        {

            if (permissionGroups.get().getGroupName().equals("ROLE_ADMIN"))
                return true;
        }
        return false;

    }

    public boolean isExist(long permissionGroupId) {

        if (permissionGroupsRepository.getPermissionGroupsById(permissionGroupId).isPresent()) {
            return true;
        }
        return false;
    }
}
