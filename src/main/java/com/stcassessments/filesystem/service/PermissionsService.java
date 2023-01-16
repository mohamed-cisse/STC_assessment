package com.stcassessments.filesystem.service;

import com.stcassessments.filesystem.entity.PermissionGroups;
import com.stcassessments.filesystem.entity.Permissions;
import com.stcassessments.filesystem.repository.PermissionGroupsRepository;
import com.stcassessments.filesystem.repository.PermissionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermissionsService {


    PermissionsRepository permissionsRepository;
    @Autowired
    PermissionsService( PermissionsRepository permissionsRepository)
    {
        this.permissionsRepository=permissionsRepository;
    }

    public void save(Permissions Permissions)
    {
        permissionsRepository.save(Permissions);
    }

    public Optional<Permissions> getPermissionByEmail(String email)
    {
        return permissionsRepository.getPermissionsByUserEmail(email);
    }
}
