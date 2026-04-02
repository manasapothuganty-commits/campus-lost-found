package com.example.project;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;
    private String location;
    private String status;
    private String contact;

    // ⭐ NEW FIELDS
    private String category;
    private LocalDateTime createdAt;

    public Item(){}

    public int getId(){ return id; }
    public void setId(int id){ this.id=id; }

    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public String getDescription(){ return description; }
    public void setDescription(String description){ this.description=description; }

    public String getLocation(){ return location; }
    public void setLocation(String location){ this.location=location; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status=status; }

    public String getContact(){ return contact; }
    public void setContact(String contact){ this.contact=contact; }

    // ⭐ NEW GETTERS/SETTERS
    public String getCategory(){ return category; }
    public void setCategory(String category){ this.category=category; }

    public LocalDateTime getCreatedAt(){ return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt){ this.createdAt=createdAt; }
}







// package com.example.project;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Item {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;

//     private String name;
//     private String description;
//     private String location;
//     private String status;
//     private String contact;

//     public Item(){}

//     public int getId(){ return id; }
//     public void setId(int id){ this.id=id; }

//     public String getName(){ return name; }
//     public void setName(String name){ this.name=name; }

//     public String getDescription(){ return description; }
//     public void setDescription(String description){ this.description=description; }

//     public String getLocation(){ return location; }
//     public void setLocation(String location){ this.location=location; }

//     public String getStatus(){ return status; }
//     public void setStatus(String status){ this.status=status; }

//     public String getContact(){ return contact; }
//     public void setContact(String contact){ this.contact=contact; }
// }
