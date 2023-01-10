package com.example.case_study_be_md6.service.before.impl;

import com.example.case_study_be_md6.model.before.CvUser;
import com.example.case_study_be_md6.repository.before.ICvUserRepo;
import com.example.case_study_be_md6.service.before.InterfaceService.All.ICvUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CvUserService implements ICvUserService {

    @Autowired
    ICvUserRepo cvUserRepo;

    @Override
    public List<CvUser> finAllCvUser() {
        return (List<CvUser>) cvUserRepo.findAll();
    }

    @Override
    public void save(CvUser cvUser) {
        cvUserRepo.save(cvUser);
    }

    @Override
    public CvUser findByIdAppUser(int id) {
        return cvUserRepo.findCvByAppUser(id);
    }
}
