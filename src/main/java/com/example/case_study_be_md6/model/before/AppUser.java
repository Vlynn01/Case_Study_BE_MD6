package com.example.case_study_be_md6.model.before;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
