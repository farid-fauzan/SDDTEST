package com.sdd.rest.controller;

import com.sdd.rest.services.PesananServices;
import com.sdd.rest.utility.MessageModel;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembelian")
public class PesananController {

    @Autowired
    private PesananServices pesananServices;

    @RequestMapping(value = "/pesan", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "Authorization token",
                    required = true,
                    dataType = "string",
                    paramType = "header") })
    public ResponseEntity<MessageModel> sendVerif(Long idLangganan){

        return pesananServices.verif(idLangganan);
    }

    @RequestMapping(value = "/konfirmasi-pesanan", method = RequestMethod.POST)
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "Authorization",
                    value = "Authorization token",
                    required = true,
                    dataType = "string",
                    paramType = "header") })
    public ResponseEntity<MessageModel> konfirmasi(Long idLangganan, String otp){

        return pesananServices.konfirmasi(idLangganan, otp);
    }

}
