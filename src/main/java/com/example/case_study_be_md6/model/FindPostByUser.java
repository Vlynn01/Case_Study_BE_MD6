package com.example.case_study_be_md6.model;

import lombok.Data;

@Data
public class FindPostByUser {
    private String nameEnterprise;
    private String city;
    private Long idField;

    private String address;

    private Long idFormJob;

    public FindPostByUser() {
    }


}
