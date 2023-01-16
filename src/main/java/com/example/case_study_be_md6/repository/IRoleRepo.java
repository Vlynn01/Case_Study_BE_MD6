package com.example.case_study_be_md6.repository;

import com.example.case_study_be_md6.model.Roles;
import org.springframework.data.repository.CrudRepository;

public interface IRoleRepo extends CrudRepository<Roles,Long> {
}
