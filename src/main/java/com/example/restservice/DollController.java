package com.example.restservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DollController {
    @Autowired
    DollRepository dollRepository;

    @ResponseBody
    @RequestMapping(value = "/dolls", method = RequestMethod.GET)
    public List<Doll> dolls() {
        List<Doll> dollList = dollRepository.findAll();
        return dollList;
    }
}
