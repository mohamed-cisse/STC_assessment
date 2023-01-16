package com.stcassessments.filesystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
@Table(name = "Permissions")
public class Permissions {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @Column(name = "permission_level", nullable = false)
    private String permissionLevel;

    @Column(name = "group_id", nullable = false)
    private long groupId;

    public Permissions(String userEmail, String permission_level, long group_id) {
        this.userEmail=userEmail;
        this.permissionLevel=permission_level;
        this.groupId=group_id;
    }
}
