package com.example.case_study_be_md6.model.before;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CvUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    AppUser appUser;

    private String name;

    private String mail;

    private String telephone;

    private String imgCV;

}
