package com.stcassessments.filesystem.repository;

import com.stcassessments.filesystem.entity.Files;
import com.stcassessments.filesystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilesRepository extends JpaRepository<Files, Long> {
}
