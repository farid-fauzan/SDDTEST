package com.sdd.rest.services;


import com.sdd.rest.entity.*;
import com.sdd.rest.pojo.LanggananPojo;
import com.sdd.rest.respository.*;
import com.sdd.rest.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LanggananServices {

    @Autowired
    private LanggananRepository langgananRepository;

    @Autowired
    private LayananRepository layananRepository;

    public ResponseEntity addLangganan (LanggananPojo langgananPojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            List<Langganan> langgananList = langgananRepository.findByIdLayanan(langgananPojo.getIdUser(),
                    langgananPojo.getIdLayanan());

            if (langgananList.size()>=1){
                msg.setStatus(true);
                msg.setMessage("Sudah Berlangganan!");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                Langganan langganan = new Langganan();
                langganan.setIdLayanan(langgananPojo.getIdLayanan());
                langganan.setIdUser(langgananPojo.getIdUser());
                langganan.setSisaPertemuan(langgananPojo.getSisaPertemuan());
                langganan.setStatusLangganan(false);
                langganan.setValid(true);

                langgananRepository.save(langganan);

                msg.setStatus(true);
                msg.setMessage("Request Berhasil, bayar segera!");
                msg.setData(null);
                return ResponseEntity.status(HttpStatus.CREATED).body(msg);
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }


    public ResponseEntity batalkan (Long idLangganan) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            Langganan langganan = langgananRepository.findLangganan(idLangganan);

            if (langganan==null){
                msg.setStatus(true);
                msg.setMessage("Data tidak ada!");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                Langganan langgananset = new Langganan();
                langgananset.setIdLangganan(langganan.getIdLangganan());
                langgananset.setIdLayanan(langganan.getIdLayanan());
                langgananset.setIdUser(langganan.getIdUser());
                langgananset.setSisaPertemuan(langganan.getSisaPertemuan());
                langgananset.setStatusLangganan(false);
                langgananset.setValid(false);

                langgananRepository.save(langganan);

                msg.setStatus(true);
                msg.setMessage("Request Berhasil, bayar segera!");
                msg.setData(null);
                return ResponseEntity.status(HttpStatus.CREATED).body(msg);
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

    public ResponseEntity addDurasi (Long idLangganan, Integer durasi) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            Langganan langganan = langgananRepository.findLangganan(idLangganan);

            if (langganan==null){
                msg.setStatus(true);
                msg.setMessage("Data tidak ada!");
                msg.setData(null);
                return ResponseEntity.ok().body(msg);
            }else {
                Langganan langgananset = new Langganan();
                langgananset.setIdLangganan(langganan.getIdLangganan());
                langgananset.setIdLayanan(langganan.getIdLayanan());
                langgananset.setIdUser(langganan.getIdUser());
                langgananset.setSisaPertemuan(langganan.getSisaPertemuan()+durasi);
                langgananset.setStatusLangganan(false);
                langgananset.setValid(true);

                Layanan layanan = layananRepository.getById(langganan.getIdLayanan());

                langgananset.setTotalBiaya((langganan.getSisaPertemuan()+durasi)*layanan.getHargaPertemuan());

                langgananRepository.save(langganan);

                msg.setStatus(true);
                msg.setMessage("Request Berhasil, bayar segera!");
                msg.setData(null);
                return ResponseEntity.status(HttpStatus.CREATED).body(msg);
            }

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
        }
    }

}
