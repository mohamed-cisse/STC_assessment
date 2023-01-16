package com.stcassessments.filesystem.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
@Table(name = "Files")
public class Files {
    @Id
    @GeneratedValue
    private long id;

    @Lob
    @Column(name = "binary", nullable = false)
    private byte[] binary;




    @Column(name = "item_id", nullable = false)
    private long itemId;


    public Files(byte[] bytes, long item_id) {

        this.binary=bytes;
        this.itemId=item_id;
    }
}
