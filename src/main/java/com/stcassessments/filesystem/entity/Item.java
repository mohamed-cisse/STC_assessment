package com.stcassessments.filesystem.entity;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;


import javax.persistence.*;
import java.util.Set;
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "parent_item_Id", nullable = false)
    private long parentItemId;

    @Column(name = "permission_group_id", nullable = false)
    private long permissionGroupId;

    public Item(String name, String type, long parentItemId, long permissionGroupId) {
        this.name=name;
        this.type=type;
        this.parentItemId=parentItemId;
        this.permissionGroupId=permissionGroupId;
    }
}




