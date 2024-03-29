package com.example.case_study_be_md6.service.impl;

import com.example.case_study_be_md6.model.FormJob;
import com.example.case_study_be_md6.model.PostEnterprise;
import com.example.case_study_be_md6.model.Regime;
import com.example.case_study_be_md6.repository.IFormJobRepo;
import com.example.case_study_be_md6.repository.IPostEnterpriseRepo;
import com.example.case_study_be_md6.repository.IRegimeRepo;
import com.example.case_study_be_md6.service.InterfaceService.IPostEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostEnterpriseService implements IPostEnterpriseService {

    @Autowired
    IPostEnterpriseRepo postEnterpriseRepo;

    @Autowired
    IFormJobRepo formJobRepo;
    @Autowired
    IRegimeRepo regimeRepo;
//    @Autowired
//    IUserApplyRepo userApplyRepo;

    @Override
    public List<PostEnterprise> findAll() {
        return (List<PostEnterprise>) postEnterpriseRepo.findAll();
    }

    @Override
    public List<PostEnterprise> getAll(Pageable pageable) {
        return postEnterpriseRepo.getAll(pageable);
    }

    @Override
    public List<PostEnterprise> findAllById(int id) {
        return postEnterpriseRepo.findAllById(id);
    }

    @Override
    public PostEnterprise findById(int id) {
        return postEnterpriseRepo.findById(id).get();
    }

    @Override
    public void save(PostEnterprise postEnterprise) {
        postEnterpriseRepo.save(postEnterprise);
    }

    @Override
    public void delete(int id) {
        postEnterpriseRepo.deleteById(id);
    }

    @Override
    public void editPost(PostEnterprise postEnterprise) {
        postEnterpriseRepo.editPost(postEnterprise.getAddressMainEnterprise(), postEnterprise.getDescribePostEnterprise(), postEnterprise.getNamePostEnterprise(), postEnterprise.getSalaryBigPostEnterprise(), postEnterprise.getSalarySmallPostEnterprise(), postEnterprise.getVacanciesPostEnterprise(), postEnterprise.getField().getIdField(), postEnterprise.getFormJobPostEnterprise().getIdFormJob(), postEnterprise.getIdPostEnterprise());
    }

// List chế độ bài đăng và hình thức công việc

    public List<FormJob> findAllFormJob() {
        return (List<FormJob>) formJobRepo.findAll();
    }

    public List<Regime> findAllRegime() {
        return (List<Regime>) regimeRepo.findAll();
    }

    @Override
    public List<PostEnterprise> findAllByIdEnterprise(int id) {
        return postEnterpriseRepo.findAllByIdEnterprise(id);
    }

    @Override
    public List<PostEnterprise> listPostByOderPriority(int idUserLogin, Pageable pageable) {

        return postEnterpriseRepo.listPostByOderPriority(idUserLogin, pageable);
    }

    @Override
    public List<PostEnterprise> listPostVipByEnterprise(int id) {
        return postEnterpriseRepo.listPostVipByEnterprise(id);
    }

    @Override
    public List<PostEnterprise> listPostThuongByEnterprise(int id) {
        return postEnterpriseRepo.listPostThuongByEnterprise(id);
    }


//    public List<PostEnterprise> findByAddress(String address) {
//        return postEnterpriseRepo.findByAddress(address);
//    }
//
//    public List<PostEnterprise> findByNamePost(String name) {
//        return postEnterpriseRepo.findByNamePost(name);
//    }
//
//    public List<PostEnterprise> findByEnterprise(int id) {
//        return postEnterpriseRepo.findByEnterprise(id);
//    }
//
//    public List<PostEnterprise> findSalary(double salary) {
//        return postEnterpriseRepo.findSalary(salary);
//    }

    public void statusPost(int id) {
        postEnterpriseRepo.statusPost(id);
    }

    @Override
    public void openKeyPost(int id) {
        postEnterpriseRepo.openKeyPost(id);
    }

    @Override
    public int quantityApplyByIdPost(int id) {
        return postEnterpriseRepo.quantityApplyByIdPost(id);
    }

    @Override
    public void setQuantityApplyPost(int id, int quantity) {
        postEnterpriseRepo.setQuantityApplyPost(id, quantity);
    }

    @Override
    public int priorityByIdPost(int id) {
        return postEnterpriseRepo.priorityByIdPost(id);
    }

    @Override
    public void setPriorityIdPost(int number, int id) {
        postEnterpriseRepo.setPriorityIdPost(number, id);
    }


    // Tìm kiếm bài viết theo tên, địa chỉ, lĩnh vực
//    @Override
//    public List<PostEnterprise> findPostUser(String name, String address, int field) {
//        return postEnterpriseRepo.findPostUser(name, address, field);
//    }
//    public List<PostEnterprise> findPostUserField(String name, String address){
//        return postEnterpriseRepo.findPostUserfield(name,address);
//    }

    public List<PostEnterprise> findByAddress(String address) {
        return postEnterpriseRepo.findByAddress(address);
    }

    public List<PostEnterprise> findByNamePost(String name) {
        return postEnterpriseRepo.findByNamePost(name);
    }

    public List<PostEnterprise> findByEnterprise(String name) {
        return postEnterpriseRepo.findByEnterprise(name);
    }

    public List<PostEnterprise> findByFormjob(long id) {
        return postEnterpriseRepo.findByFormJob(id);
    }

    public List<PostEnterprise> findByCity(String address) {
        return postEnterpriseRepo.findByCity(address);
    }

//    public List<PostEnterprise> findSalary(double salary) {
//        return postEnterpriseRepo.findSalary(salary);
//    }

    public List<PostEnterprise> findByAddressAndField(String address, Long field) {
        return postEnterpriseRepo.findByAddressAndField(address, field);
    }

    public List<PostEnterprise> findByFieldAndFormJob(long idfield, long idformjob) {
        return postEnterpriseRepo.findByFieldAndFormJob(idfield, idformjob);
    }

    public List<PostEnterprise> findByAddressAndFormJob(String address, int formjob) {
        return postEnterpriseRepo.findByAddressAndFormJob(address, formjob);
    }

    public List<PostEnterprise> findPostUserField(String name, String address) {
        return postEnterpriseRepo.findPostUserfield(name, address);
    }

    public List<PostEnterprise> findPostEnterpriseByCondition(Long userId, String name, String address, Long idformjob, Long idfield, Integer page) {
        Pageable pageable = PageRequest.of(page - 1, 3);
        return postEnterpriseRepo.findPostEnterpriseByCondition(userId, name, address, idformjob, idfield, pageable).getContent();
    }


    @Override
    public void deletePostExpired() {
        long millis = System.currentTimeMillis();
        java.sql.Date dateNow = new java.sql.Date(millis);
        String dateNowStr = String.valueOf(dateNow);
        if (getPostExpired(dateNowStr) != null) {
            postEnterpriseRepo.deletePostExpired(dateNowStr);
        } else {
            System.out.println("Không có !");
        }
    }

    @Override
    public PostEnterprise getPostExpired(String date) {
        return postEnterpriseRepo.getPostExpired(date);
    }

    public List<PostEnterprise> findAllAddress() {
        return postEnterpriseRepo.findAllAddress();
    }


//    public List<PostEnterprise> findPostByUserApply(int id){
//        return postEnterpriseRepo.searchPostApplyByUser(id);
//    }

//    @Override
//    public List<PostEnterprise> findPostUser(String name, String address, int field) {
//        return null;
//    }
//
//    public List<PostEnterprise> findPostByUserApply(int id){
//        return postEnterpriseRepo.searchPostApplyByUser(id);
//    }
//

}
