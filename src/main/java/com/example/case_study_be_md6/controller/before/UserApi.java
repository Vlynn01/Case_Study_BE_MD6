package com.example.case_study_be_md6.controller.before;

import com.example.case_study_be_md6.model.before.CvUser;
import com.example.case_study_be_md6.model.before.FindPostByUser;
import com.example.case_study_be_md6.model.before.PostEnterprise;
import com.example.case_study_be_md6.service.before.InterfaceService.All.ICvUserService;
import com.example.case_study_be_md6.service.before.InterfaceService.All.INotificationEnterpriseService;
import com.example.case_study_be_md6.service.before.InterfaceService.All.IUserApplyService;
import com.example.case_study_be_md6.service.before.impl.PostEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/cv")
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

    @GetMapping("/findbyaddress/{address}")
    public ResponseEntity<List<PostEnterprise>> findByAddress(@PathVariable String address){
        return new ResponseEntity<>(postEnterpriseService1.findByAddress(address),HttpStatus.OK);
    }

    @PostMapping("/findByAddressAndField")
    public ResponseEntity<List<PostEnterprise>> findByAddressAndField(@RequestBody FindPostByUser findPostByUser) {
        return new ResponseEntity<>(postEnterpriseService1.findByAddressAndField(findPostByUser.getAddress(), findPostByUser.getIdField()), HttpStatus.OK);
    }

    @GetMapping("/findByEnterprise/{name}")
    public ResponseEntity<List<PostEnterprise>> findByEnterprise(@PathVariable String name){
        return new ResponseEntity<>(postEnterpriseService1.findByEnterprise(name),HttpStatus.OK);
    }

    @GetMapping("/findByFormjob/{id}")
    public ResponseEntity<List<PostEnterprise>> findByFormjob(@PathVariable long id){
        return new ResponseEntity<>(postEnterpriseService1.findByFormjob(id),HttpStatus.OK);
    }

    @GetMapping("/findByCity/{address}")
    public ResponseEntity<List<PostEnterprise>> findByCity(@PathVariable String address){
        return new ResponseEntity<>(postEnterpriseService1.findByCity(address),HttpStatus.OK);
    }

    @GetMapping("/findByNamepost/{name}")
    public ResponseEntity<List<PostEnterprise>> findByNamePost(@PathVariable String name){
        return new ResponseEntity<>(postEnterpriseService1.findByNamePost(name),HttpStatus.OK);
    }

}
