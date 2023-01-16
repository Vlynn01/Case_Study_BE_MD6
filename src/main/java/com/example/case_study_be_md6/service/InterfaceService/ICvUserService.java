package com.example.case_study_be_md6.service.InterfaceService;

import com.example.case_study_be_md6.model.CvUser;

import java.util.List;

public interface ICvUserService {
    List<CvUser> finAllCvUser();
    void save(CvUser cvUser);

    CvUser findByIdAppUser(int id);
}

