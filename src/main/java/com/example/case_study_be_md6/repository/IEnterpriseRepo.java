package com.example.case_study_be_md6.repository;

import com.example.case_study_be_md6.model.Enterprise;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IEnterpriseRepo extends CrudRepository<Enterprise,Integer>{

    //xác nhận đăng ký Doanh nghiệp
    @Transactional
    @Modifying
    @Query(nativeQuery = true,value = "update enterprise set password_enterprise=:password,status_confirm=:status where id_enterprise=:id")
    void confirmRegisterEnterprise(@Param("password") String password,@Param("status") int status,@Param("id")int id);
    @Query(nativeQuery = true,value = "SELECT * FROM Case_Study_MD6.enterprise where status_confirm=0 ORDER BY time_register_enterprise DESC, date_register_enterprise DESC")
    List<Enterprise> getAllEnterpriseNotConfirmOrderByTime();
    @Query(nativeQuery = true,value = "SELECT * FROM Case_Study_MD6.enterprise where status_confirm=1 ORDER BY time_register_enterprise DESC, date_register_enterprise DESC")
    List<Enterprise> getAllEnterpriseConfirmOrderByTime();


    //tìm theo gmail
    @Query(nativeQuery = true,value = "SELECT * FROM Case_Study_MD6.enterprise where gmail_enterprise=:gmail")
    Enterprise findByGmailEnterprise(@Param("gmail") String name);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "UPDATE enterprise SET name_enterprise =:nameEnterprise, address_main_enterprise =:addressMainEnterprise, describe_enterprise =:describeEnterprise WHERE id_enterprise =:idEnterprise ")
    void editProfile( @Param("nameEnterprise") String name_enterprise,@Param("addressMainEnterprise") String address_main_enterprise,@Param("describeEnterprise") String describe_enterprise,@Param("idEnterprise") int id_enterprise);



    //Đặt trạng thái doanh nghiệp là 1
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update Case_Study_MD6.enterprise set status_enterprise=1 where id_enterprise=:id")
    void setStatusEnterpriseTo1(@Param("id") int id);


    //Đặt trạng thái doanh nghiệp là 0
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update Case_Study_MD6.enterprise set status_enterprise=0 where id_enterprise=:id")
    void setStatusEnterpriseTo0(@Param("id") int id);


    @Query(nativeQuery = true, value = "select * from enterprise where name_enterprise is not null ")
    List<Enterprise> findAllEnterprise();













}
