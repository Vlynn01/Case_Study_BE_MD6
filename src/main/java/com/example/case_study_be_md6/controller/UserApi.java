package com.example.case_study_be_md6.controller;

import com.example.case_study_be_md6.model.*;
import com.example.case_study_be_md6.model.PostEnterprise;
import com.example.case_study_be_md6.service.InterfaceService.ICvUserService;
import com.example.case_study_be_md6.service.InterfaceService.INotificationEnterpriseService;
import com.example.case_study_be_md6.service.InterfaceService.IUserApplyService;
import com.example.case_study_be_md6.service.impl.AppUserService;
import com.example.case_study_be_md6.service.impl.EnterpriseService;
import com.example.case_study_be_md6.service.impl.PostEnterpriseService;
//import com.sun.tools.javac.main.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserApi {
    @Autowired
    PostEnterpriseService postEnterpriseService;
    @Autowired
    ICvUserService cvUserService;

    @Autowired
    IUserApplyService userApplyService;

    @Autowired
    INotificationEnterpriseService notificationEnterpriseService;
    @Autowired
    PostEnterpriseService postEnterpriseService1;

    @Autowired
    AppUserService appUserService;

    @Autowired
    EnterpriseService enterpriseService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PostEnterprise>> findAll() {
        return new ResponseEntity<>(postEnterpriseService.findAll(), HttpStatus.OK);
    }

    @RequestMapping("/getAll/{page}")
    public ResponseEntity<List<PostEnterprise>> findAll(@PathVariable int page) {
        return new ResponseEntity<>(postEnterpriseService.getAll(PageRequest.of(page, 3)), HttpStatus.OK);
    }

    @GetMapping("/listPostByOderPriority/{id}/{page}")
    public ResponseEntity<List<PostEnterprise>> listPostByOderPriority(@PathVariable int id, @PathVariable int page) {
        return new ResponseEntity<>(postEnterpriseService.listPostByOderPriority(id, PageRequest.of(page - 1, 3)), HttpStatus.OK);
    }

    //    Tạo Cv -Nguyen
    @PostMapping("/saveCvUser")
    public ResponseEntity<CvUser> saveCvUser(@RequestBody CvUser cvUser) {
        cvUserService.save(cvUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //    Lưu Cv - Nguyen
    @GetMapping("/findCvByIdUser/{id}")
    public ResponseEntity<CvUser> findCvByIdUser(@PathVariable int id) {
        return new ResponseEntity<>(cvUserService.findByIdAppUser(id), HttpStatus.OK);
    }

    @GetMapping("/postDetail/{id}")
    public ResponseEntity<PostEnterprise> findPostByID(@PathVariable int id) {
        return new ResponseEntity<>(postEnterpriseService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/saveApplyJob")
    public ResponseEntity<UserApply> saveApplyJob(@RequestBody UserApply userApply) {
        int idAppUser = userApply.getAppUser().getId();
        int idPost = userApply.getPostEnterprise().getIdPostEnterprise();
        String telephoneCV = cvUserService.findByIdAppUser(idAppUser).getTelephone().trim();
        String mail = cvUserService.findByIdAppUser(idAppUser).getMail().trim();
        String imgCv = cvUserService.findByIdAppUser(idAppUser).getImgCV().trim();
        UserApply userApply1 = userApplyService.findByIdAppUserAndIdPost(imgCv, mail, telephoneCV, idAppUser, idPost);
        if (userApply1 == null) {
            userApplyService.save(userApply);

            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
//    @GetMapping("/findSalary/{salary}")
//    public ResponseEntity<List<PostEnterprise>> findBySalary(@PathVariable double salary) {
//        return new ResponseEntity<>(postEnterpriseService.findSalary(salary), HttpStatus.OK);
//    }


    @GetMapping("/findbyaddress/{address}")
    public ResponseEntity<List<PostEnterprise>> findByAddress(@PathVariable String address) {
        return new ResponseEntity<>(postEnterpriseService1.findByAddress(address), HttpStatus.OK);
    }

    @PostMapping("/findByAddressAndField")
    public ResponseEntity<List<PostEnterprise>> findByAddressAndField(@RequestBody FindPostByUser findPostByUser) {
        return new ResponseEntity<>(postEnterpriseService1.findByAddressAndField(findPostByUser.getAddress(), findPostByUser.getIdField()), HttpStatus.OK);
    }

    @PostMapping("/findByAddressAndFormJob")
    public ResponseEntity<List<PostEnterprise>> findByAddressAndFormJob(@RequestBody FindPostByUser findPostByUser) {
        return new ResponseEntity<>(postEnterpriseService1.findByAddressAndField(findPostByUser.getAddress(), findPostByUser.getIdFormJob()), HttpStatus.OK);
    }

    @GetMapping("/findByEnterprise/{name}")
    public ResponseEntity<List<PostEnterprise>> findByEnterprise(@PathVariable String name) {
        return new ResponseEntity<>(postEnterpriseService1.findByEnterprise(name), HttpStatus.OK);
    }

    @GetMapping("/findByFormjob/{id}")
    public ResponseEntity<List<PostEnterprise>> findByFormjob(@PathVariable long id) {
        return new ResponseEntity<>(postEnterpriseService1.findByFormjob(id), HttpStatus.OK);
    }

    @GetMapping("/findByCity/{address}")
    public ResponseEntity<List<PostEnterprise>> findByCity(@PathVariable String address) {
        return new ResponseEntity<>(postEnterpriseService1.findByCity(address), HttpStatus.OK);
    }

    @GetMapping("/findByNamepost/{name}")
    public ResponseEntity<List<PostEnterprise>> findByNamePost(@PathVariable String name) {
        return new ResponseEntity<>(postEnterpriseService1.findByNamePost(name), HttpStatus.OK);
    }

    @GetMapping("/finduser/{name}")
    public ResponseEntity<AppUser> findByUserName(@PathVariable String name) {
        return new ResponseEntity<>(appUserService.findByUserName1(name), HttpStatus.OK);
    }

    @GetMapping("/findAllFormJob")
    public ResponseEntity<List<FormJob>> findAllFormJob() {
        return new ResponseEntity<>(postEnterpriseService1.findAllFormJob(), HttpStatus.OK);
    }

    @PostMapping("/findByFieldAndFormJob")
    public ResponseEntity<List<PostEnterprise>> findByFieldAndFormJob(FindPostByUser findPostByUser) {
        return new ResponseEntity<>(postEnterpriseService1.findByFieldAndFormJob(findPostByUser.getIdField(), findPostByUser.getIdFormJob()), HttpStatus.OK);
    }

    @GetMapping("/find-everything")
    public ResponseEntity<List<PostEnterprise>> findEverything(@RequestParam(required = false, defaultValue = "", value = "name-enterprise") String name, @RequestParam(required = false, defaultValue = "", value = "address") String address, @RequestParam(required = false, defaultValue = "-1", value = "id-form-job") Long idFormJob, @RequestParam(required = false, defaultValue = "-1", value = "id-field") Long idField, @RequestParam(required = false, defaultValue = "1") int page) {
        return new ResponseEntity<>(postEnterpriseService1.findErverything(name, address, idFormJob, idField), HttpStatus.OK);
    }

    @GetMapping("/find-all-address")
    public ResponseEntity<List<PostEnterprise>> findAllAddress() {
        return new ResponseEntity<>(postEnterpriseService1.findAllAddress(), HttpStatus.OK);
    }

    @GetMapping("/find-all-enterprise")
    public ResponseEntity<List<Enterprise>> findAllEnterprise(){
        return new ResponseEntity<>(enterpriseService.findAllEnterprise(),HttpStatus.OK);
    }
}
