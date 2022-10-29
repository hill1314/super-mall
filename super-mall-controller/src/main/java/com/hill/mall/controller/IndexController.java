package com.hill.mall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 *
 * @date 2022-10-29 15:05
 * @author huleilei9
 **/
@RestController
public class IndexController {

    /**
     * index
     *
     * @return
     */
    @GetMapping("/")
    public String index() {
        return "hell world!";
    }

}
