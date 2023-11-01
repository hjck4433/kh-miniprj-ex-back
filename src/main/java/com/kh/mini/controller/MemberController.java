package com.kh.mini.controller;

import com.kh.mini.dao.MemberDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/users")
public class MemberController {
    // POST 로그인
    @PostMapping("/login")
    public ResponseEntity<Boolean> memberLogin(@RequestBody Map<String, String> loginData) {
        String id = loginData.get("id");
        String pwd = loginData.get("pwd");
        System.out.println("ID : " + id);
        System.out.println("PWD : " + pwd);
        MemberDAO dao = new MemberDAO();
        boolean rst = dao.loginCheck(id,pwd);
        return new ResponseEntity<>(rst, HttpStatus.OK);
    }
}
