package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DollController {
    @Autowired
    private DollRepository dollRepository;

    @ResponseBody
    @GetMapping("/dolls")
    public List<Doll> dolls() {
        return dollRepository.findAll();
    }
}
