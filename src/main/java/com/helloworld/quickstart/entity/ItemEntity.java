package com.helloworld.quickstart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ITEM")
public class ItemEntity {

    @Id
    private String Id;
    private String Name;

    public String getId() {
        return Id;
    }

    public String getName() {
        return Name;
    }

    public void setId(String id) {
        Id = id;
    }
    public void setName(String name) {
        Name = name;
    }
}
