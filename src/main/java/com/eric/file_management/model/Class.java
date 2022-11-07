package com.eric.file_management.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String className;

    private String semester;

    @OneToMany(mappedBy = "classes", cascade = CascadeType.ALL)
    private Set<Student> students;
}
