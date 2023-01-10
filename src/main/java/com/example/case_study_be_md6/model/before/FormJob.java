package com.example.case_study_be_md6.model.before;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FormJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFormJob;

    private String nameFormJob;
}
