package com.stcassessments.filesystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "PermissionGroups")
public class PermissionGroups {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "group_name" , nullable= false)
    private String groupName;


    public PermissionGroups(String role) {
        this.groupName= role;
    }
}
