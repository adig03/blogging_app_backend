package com.example.Blogging.Application.entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer CategoryId;
    @Column(name = "title" , length = 100 , nullable = false)
    private String Category_title;
    @Column(name = "description" , nullable = false)
    private String category_desc;

}
