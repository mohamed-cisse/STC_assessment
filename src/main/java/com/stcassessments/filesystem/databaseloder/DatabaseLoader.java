package com.stcassessments.filesystem.databaseloder;


import com.stcassessments.filesystem.entity.PermissionGroups;
import com.stcassessments.filesystem.entity.Permissions;
import com.stcassessments.filesystem.service.PermissionGroupsService;
import com.stcassessments.filesystem.service.PermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Component
public class DatabaseLoader implements CommandLineRunner {



    private PermissionsService permissionsService;
    private PermissionGroupsService permissionGroupsService;
    @Autowired
    public DatabaseLoader(PermissionsService permissionsService, PermissionGroupsService permissionGroupsService) {
        this.permissionGroupsService = permissionGroupsService;
        this.permissionsService = permissionsService;
    }

    @Override
    public void run(String... args) {
        // add user and rolls
        addUsersAndRoles();
    }

    /**
     * add user roles
     */
    private void addUsersAndRoles() {

        PermissionGroups permissionGroupAdmin = new PermissionGroups("ROLE_ADMIN");
        permissionGroupsService.save(permissionGroupAdmin);

        // Admin with view access.
        permissionsService.save( new  Permissions("adminView@gmail.com","VIEW",permissionGroupAdmin.getId()));

        // Admin with edit access.
        permissionsService.save(new  Permissions("adminEdit@gmail.com","EDIT",permissionGroupAdmin.getId()));



    }
}


