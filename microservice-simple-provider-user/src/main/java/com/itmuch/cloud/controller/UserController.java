package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.entity.User;
import com.itmuch.cloud.repository.UserRepository;

@RestController//混合注解，相当于controller+responseBody
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/simple/{id}")//该注解是4.3后支持的，是组合注解：相当于requestMapping的get请求，postMapping同post请求
  public User findById(@PathVariable Long id) {
    return this.userRepository.findOne(id);
  }
}
