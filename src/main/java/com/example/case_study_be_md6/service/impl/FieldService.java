package com.example.case_study_be_md6.service.impl;

import com.example.case_study_be_md6.model.Field;
import com.example.case_study_be_md6.repository.IFieldRepo;
import com.example.case_study_be_md6.service.InterfaceService.All.IFieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class FieldService implements IFieldService {
    @Autowired
    IFieldRepo fieldRepo;

    @Override
    public List<Field> findAll() {
        return (List<Field>) fieldRepo.findAll();
    }

    @Override
    public Field findById(int id) {
        return fieldRepo.findById(id);
    }
}
