package com.example.case_study_be_md6.service.impl;

import com.example.case_study_be_md6.model.AppUser;
import com.example.case_study_be_md6.model.Roles;
import com.example.case_study_be_md6.repository.IAppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserService implements UserDetailsService {
    @Autowired
    private IAppUserRepo iAppUserRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = iAppUserRepo.findByUsername(username);
        List<Roles> roles = new ArrayList<>();
        roles.add(appUser.getRoles());
        return new User(appUser.getEmail(), appUser.getPassword(), roles);
    }

    public List<AppUser> getAll() {
        return (List<AppUser>) iAppUserRepo.findAll();
    }

    public AppUser findByUserName(String username) {
        return iAppUserRepo.findByUsername(username);
    }

    public AppUser save(AppUser appUser) {
        return iAppUserRepo.save(appUser);
    }


}
