package com.example.case_study_be_md6.controller;

import com.example.case_study_be_md6.model.AppUser;
import com.example.case_study_be_md6.model.Enterprise;
import com.example.case_study_be_md6.model.Field;
import com.example.case_study_be_md6.model.Roles;
import com.example.case_study_be_md6.service.InterfaceService.All.IEnterpriseService;
import com.example.case_study_be_md6.service.InterfaceService.All.IFieldService;
import com.example.case_study_be_md6.service.impl.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    AppUserService appUserService;

    @Autowired
    IEnterpriseService enterpriseService;

    @Autowired
    IFieldService fieldService;

    @PostMapping("/user")
    public ResponseEntity<AppUser> register(@RequestBody AppUser appUser) {
        Roles role = new Roles();
        role.setId(3);
        appUser.setRoles(role);
        return new ResponseEntity<>(appUserService.save(appUser), HttpStatus.OK);
//
    }

    @GetMapping("/findAllField")
    public ResponseEntity<List<Field>> findAllField() {
        return new ResponseEntity<>(fieldService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Field> findById(@PathVariable int id) {
        return new ResponseEntity<>(fieldService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/enterprise")
    public ResponseEntity<Enterprise> registerEnterprise(@RequestBody Enterprise enterprise) {
        enterprise.setTimeRegisterEnterprise(Time.valueOf(java.time.LocalTime.now()));
        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);
        enterprise.setDateRegisterEnterprise(date);
        enterpriseService.save(enterprise);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //check trùng
    @GetMapping("/checkEnterprise")
    public ResponseEntity<List<Enterprise>> findAllEnterprise() {
        return new ResponseEntity<>(enterpriseService.getAllEnterprise(), HttpStatus.OK);
    }

    @GetMapping("/checkUser")
    public ResponseEntity<List<AppUser>> findAllUser() {
        return new ResponseEntity<>(appUserService.getAll(), HttpStatus.OK);
    }
}
