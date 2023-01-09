package com.example.case_study_be_md6.service.before.InterfaceService.All;

import com.example.case_study_be_md6.model.before.Enterprise;

import java.util.List;

public interface IEnterpriseService {

    void save(Enterprise enterprise);
<<<<<<< HEAD
    List<Enterprise> findAll();
=======

>>>>>>> c82450cf0f0683e0e3e19006961cf4095d8690a7
    List<Enterprise> getAllEnterprise();

    List<Enterprise> getAllEnterpriseNotConfirmOrderByTime();


    Enterprise findEnterpriseById(int id);

    Enterprise findByGmailEnterprise(String name);


    void confirmRegisterEnterprise(String password ,int status, int id);

    void delete(int id);



//    List<Enterprise> listEnterpriseOderByRates();

//    the

//    tuan

    //    song
    void setStatusEnterpriseTo1(int id);
    void setStatusEnterpriseTo0(int id);

<<<<<<< HEAD
//    void changPassword(String email, String password);
=======
    void changPassword(String email, String password);
>>>>>>> c82450cf0f0683e0e3e19006961cf4095d8690a7

//    hai

//    duc

}
