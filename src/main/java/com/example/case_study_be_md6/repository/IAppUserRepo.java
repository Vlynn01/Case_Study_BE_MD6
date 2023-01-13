package com.example.case_study_be_md6.repository;

import com.example.case_study_be_md6.model.AppUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IAppUserRepo extends CrudRepository<AppUser, Long> {
    AppUser findByUsername(String username);

    // Đổi mật khẩu
    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update Case_Study_MD6.app_user set password=:password where email=:email")
    void changPassword(@Param("email") String gmail, @Param("password") String password);

}
