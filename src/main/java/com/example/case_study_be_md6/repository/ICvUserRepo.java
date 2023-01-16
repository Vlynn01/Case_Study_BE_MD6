package com.example.case_study_be_md6.repository;

import com.example.case_study_be_md6.model.CvUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ICvUserRepo  extends CrudRepository<CvUser,Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM Case_Study_MD6.cv_user where app_user_id=:id")
    CvUser findCvByAppUser(@Param("id") int id);
}


