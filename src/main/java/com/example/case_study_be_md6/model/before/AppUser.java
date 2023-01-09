package com.example.case_study_be_md6.model.before;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private  String email;
    private String password;
//    @ManyToMany(fetch = FetchType.EAGER)
    @OneToOne
    private Roles roles;
}
