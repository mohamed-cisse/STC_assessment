package com.stcassessments.filesystem.repository;

import com.stcassessments.filesystem.entity.Permissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionsRepository extends JpaRepository<Permissions, Long> {
  public Optional<Permissions> getPermissionsByUserEmail(String email);
}
