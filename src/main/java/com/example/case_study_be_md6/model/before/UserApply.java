package com.example.case_study_be_md6.model.before;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserApply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int idUserApply;

    private String nameCV;

    private String numberCV;

    private String mailCv;

    private String imgCV;

    private boolean statusConfirm=false;
    @ManyToOne
    private AppUser appUser;

    @ManyToOne
    private PostEnterprise postEnterprise;
}
