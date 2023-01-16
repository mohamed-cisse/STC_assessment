package com.stcassessments.filesystem.repository;

import com.stcassessments.filesystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository  extends JpaRepository<Item, Long> {

    Optional<Item> getItemByNameAndParentItemId(String name,long ParentItemId);

    Optional<Item> getItemById(Long id);
}
