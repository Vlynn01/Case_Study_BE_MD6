package com.example.case_study_be_md6.controller.before;

import com.example.case_study_be_md6.model.before.CvUser;
import com.example.case_study_be_md6.service.before.InterfaceService.All.ICvUserService;
import com.example.case_study_be_md6.service.before.InterfaceService.All.INotificationEnterpriseService;
import com.example.case_study_be_md6.service.before.InterfaceService.All.IUserApplyService;
import com.example.case_study_be_md6.service.before.impl.PostEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
