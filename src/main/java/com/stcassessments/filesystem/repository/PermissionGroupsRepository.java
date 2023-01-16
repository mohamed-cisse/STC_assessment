package com.stcassessments.filesystem.repository;

import com.stcassessments.filesystem.entity.PermissionGroups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionGroupsRepository extends JpaRepository<PermissionGroups, Long> {

     Optional<PermissionGroups> getPermissionGroupsByGroupName(String name);

    Optional<PermissionGroups> getPermissionGroupsById(long groupId);
}
