package com.example.case_study_be_md6.repository.before;

import com.example.case_study_be_md6.model.before.Field;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IFieldRepo extends CrudRepository<Field,Integer> {



    @Query(nativeQuery = true,value = "select * from case_study_md6.field where id_field=:id")
    Field findById(@Param("id") int id);
}
