package com.example.restservice;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.future.uroborosql.SqlAgent;
import jp.co.future.uroborosql.UroboroSQL;
import jp.co.future.uroborosql.config.SqlConfig;

@Controller
public class DollController {
    @Autowired
    DollRepository dollRepository;

    @Autowired
    protected DataSource dataSource;

    @ResponseBody
    @RequestMapping(value = "/uroborosql/dolls", method = RequestMethod.GET)
    public List<Doll> get() {
        // DataSource取得
        SqlConfig config = UroboroSQL.builder(dataSource).build();
        // SQLの場所はsrc/main/resources/sql/hoge/selectAll.sql
        // 「sql/hoge/selectAll.sql」で指定するとNot Foundになった。IntelliJからCtrl + クリックでファイル参照できないのが不便
        List<Doll> hoge;
        try (SqlAgent agent = config.agent()) {
            hoge = agent.query("doll/selectAll")
                    .collect(Doll.class);
        }
        return hoge;
    }

    @ResponseBody
    @RequestMapping(value = "/dolls", method = RequestMethod.GET)
    public List<Doll> dolls() {
        List<Doll> dollList = dollRepository.findAll();
        return dollList;
    }
}
