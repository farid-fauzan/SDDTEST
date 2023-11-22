package com.sdd.rest.controller;

import com.sdd.rest.pojo.LatihanPojo;
import com.sdd.rest.pojo.LayananPojo;
import com.sdd.rest.services.MenuServices;
import com.sdd.rest.utility.MessageModel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/layanan")
public class MenuController {

    @Autowired
    private MenuServices menuServices;

    @RequestMapping(value = "/add-layanan", method = RequestMethod.POST)
    public ResponseEntity<MessageModel> saveLayanan(@Valid @RequestBody LayananPojo layanan){

        return menuServices.addLayanan(layanan);
    }

    @RequestMapping(value = "/add-latihan", method = RequestMethod.POST)
    public ResponseEntity<MessageModel> saveLatihan(@Valid @RequestBody LatihanPojo latihanPojo){

        return menuServices.addLatihan(latihanPojo);
    }


    @RequestMapping(value = "/list-layanan", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "Authorization token",
                    required = true,
                    dataType = "string",
                    paramType = "header") })
    public ResponseEntity<MessageModel> listLayanan(){

        return menuServices.listLayanan();
    }
}
