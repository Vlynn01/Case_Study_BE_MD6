package com.example.case_study_be_md6.service.InterfaceService;

import com.example.case_study_be_md6.model.Enterprise;

import java.util.List;

public interface IEnterpriseService {

    void save(Enterprise enterprise);


    List<Enterprise> findAll();

   void editProfile (Enterprise enterprise);


    List<Enterprise> getAllEnterprise();

    List<Enterprise> getAllEnterpriseNotConfirmOrderByTime();
    List<Enterprise> getAllEnterpriseConfirmOrderByTime();


    Enterprise findEnterpriseById(int id);

    Enterprise findByGmailEnterprise(String name);


    void confirmRegisterEnterprise(String password ,int status, int id);

    void delete(int id);



//    List<Enterprise> listEnterpriseOderByRates();



    void setStatusEnterpriseTo1(int id);
    void setStatusEnterpriseTo0(int id);





    void changPassword(String email, String password);





}
