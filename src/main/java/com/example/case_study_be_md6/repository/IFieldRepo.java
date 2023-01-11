package com.example.case_study_be_md6.repository;

import com.example.case_study_be_md6.model.Field;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IFieldRepo extends CrudRepository<Field, Integer> {
    //tìm id lĩnh vực
    @Query(nativeQuery = true, value = "select * from Case_Study_MD6.field where id_field=:id")
    Field findById(@Param("id") int id);
}
