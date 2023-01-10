package com.example.case_study_be_md6.controller.before;

import com.example.case_study_be_md6.model.before.CvUser;
import com.example.case_study_be_md6.model.before.PostEnterprise;
import com.example.case_study_be_md6.model.before.UserApply;
import com.example.case_study_be_md6.service.before.InterfaceService.All.ICvUserService;
import com.example.case_study_be_md6.service.before.InterfaceService.All.INotificationEnterpriseService;
import com.example.case_study_be_md6.service.before.InterfaceService.All.IUserApplyService;
import com.example.case_study_be_md6.service.before.impl.PostEnterpriseService;
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

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<PostEnterprise>> findAll() {
        return new ResponseEntity<>(postEnterpriseService.findAll(), HttpStatus.OK);
    }
    @RequestMapping("/getAll/{page}")
    public ResponseEntity<List<PostEnterprise>> findAll(@PathVariable int page) {
        return new ResponseEntity<>(postEnterpriseService.getAll(PageRequest.of(page, 3)), HttpStatus.OK);
    }
    @GetMapping("/listPostByOderPriority/{id}/{page}")
    public ResponseEntity<List<PostEnterprise>> listPostByOderPriority(@PathVariable int id,@PathVariable int page) {
        return new ResponseEntity<>(postEnterpriseService.listPostByOderPriority(id,PageRequest.of(page-1, 3)), HttpStatus.OK);
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
    @GetMapping("/findSalary/{salary}")
    public ResponseEntity<List<PostEnterprise>> findBySalary(@PathVariable double salary) {
        return new ResponseEntity<>(postEnterpriseService.findSalary(salary), HttpStatus.OK);
    }


}
