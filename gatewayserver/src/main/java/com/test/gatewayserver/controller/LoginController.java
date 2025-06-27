package com.test.gatewayserver.controller;

import com.test.gatewayserver.auth.User;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/user")
public class LoginController {

    @GetMapping(path = "/hello")
    public String Hello(){
        return "Hello";
    }
    @PutMapping(path = "/hello")
    public ResponseEntity<?> hello(@Valid @RequestBody(required=false) User user, BindingResult result){
        if(result.hasErrors()){
            List<String> res = result.getFieldErrors().stream()
                    .map(error -> error.getField() +" : "+error.getDefaultMessage())
                    .toList();
            return ResponseEntity.badRequest().body(res);
        }
        return ResponseEntity.ok(user);
    }
}
