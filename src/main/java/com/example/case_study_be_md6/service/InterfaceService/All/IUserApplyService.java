package com.example.case_study_be_md6.service.InterfaceService.All;

import com.example.case_study_be_md6.model.UserApply;

import java.util.List;

public interface IUserApplyService {

    void save(UserApply userApply);

    UserApply findByIdAppUserAndIdPost(String imgcv, String mail, String numberTelephone, int idAppUser, int idPost);

    void updateStatusConfirmUserApply(int id);

    UserApply findById(int id);

    List<UserApply> listUserApplyByIdPost(int id);

    List<Integer> listIdPostByIdUserApply(int id);

    List<UserApply> listUserApplyByIdAppUser(int id);

    UserApply findImgCvApply(int idUser, int idPost);
}
