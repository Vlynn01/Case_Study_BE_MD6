package com.example.case_study_be_md6.controller;

import com.example.case_study_be_md6.model.AppUser;
import com.example.case_study_be_md6.model.ChangePassWord;
import com.example.case_study_be_md6.dto.UserToken;
import com.example.case_study_be_md6.service.JwtService;
import com.example.case_study_be_md6.service.InterfaceService.IEnterpriseService;
import com.example.case_study_be_md6.service.impl.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LoginAPI {
    @Autowired
    JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    AppUserService appUserService;

    @Autowired
    IEnterpriseService enterpriseService;

    @PostMapping("/login")
    public ResponseEntity<UserToken> login(@RequestBody AppUser appUser) {

        // Tạo ra 1 đối tượng Authentication.
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(appUser.getUsername(), appUser.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtService.createToken(authentication);
        AppUser appUser1 = appUserService.findByUserName(appUser.getUsername());
        UserToken userToken = new UserToken
                (appUser1.getId(), appUser1.getUsername(), token, appUser1.getRoles());
        return new ResponseEntity<>(userToken, HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<AppUser> findByUserName(@PathVariable String name) {
        return new ResponseEntity<>(appUserService.findByUserName(name), HttpStatus.OK);
    }

    //đổi mật khẩu
    @PostMapping("/changePassword")
    public ResponseEntity<AppUser> changePassword(@RequestBody ChangePassWord changePassWord) {
        enterpriseService.changPassword(changePassWord.getGmail(), changePassWord.getPassword());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
