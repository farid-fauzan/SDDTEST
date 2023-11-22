package com.sdd.rest.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class CardPojo {

    @NotBlank(message = "User tidak boleh kosong")
    private Long idUser;

    @NotBlank(message = "Nomor Kartu tidak boleh kosong")
    private String nomorKartu;

    @NotBlank(message = "Nama tidak boleh kosong")
    private String namaLengkap;

    @NotBlank(message = "CVV tidak boleh kosong")
    private String cvv;

    @NotBlank(message = "Exp Month tidak boleh kosong")
    private String expMonth;

    @NotBlank(message = "Exp Year tidak boleh kosong")
    private String expYear;

}
