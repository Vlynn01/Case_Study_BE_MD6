package com.example.case_study_be_md6.service.InterfaceService.All;

import com.example.case_study_be_md6.model.Field;

import java.util.List;

public interface IFieldService {

    List<Field> findAll();

    Field findById(int id);
}
