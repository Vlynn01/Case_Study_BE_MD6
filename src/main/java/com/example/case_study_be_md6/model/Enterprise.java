package com.example.case_study_be_md6.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEnterprise;

    private String nameEnterprise;

    private String codeConfirmEnterprise;

    private String gmailEnterprise;

    private String imgEnterprise;

    private String addressMainEnterprise;

    @ManyToOne
    private Field fieldEnterprise;

    private String describeEnterprise;

    private Time timeRegisterEnterprise;

    private Date dateRegisterEnterprise;

    private String passwordEnterprise;

    // Tỷ suất phần trăm
//    private double ratesEnterprise =0;
    private boolean statusEnterprise = false;

    private boolean statusConfirm = false;
}
