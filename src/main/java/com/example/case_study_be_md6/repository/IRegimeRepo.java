package com.example.case_study_be_md6.repository;

import com.example.case_study_be_md6.model.Regime;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegimeRepo extends CrudRepository<Regime, Integer> {

}
