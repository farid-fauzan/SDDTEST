package com.sdd.rest.entity;


import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "latihan", schema = "db_sdd")
public class Latihan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_latihan", nullable = false)
    private Long idMenu;

    @Column(name = "id_layanan", nullable = true )
    private Long idLayanan;

    @Column(name = "nama_latihan", nullable = true )
    private String namaLatihan;

    @Column(name = "durasi_latihan", nullable = true )
    private Long durasiLatihan;

    @Column(name = "keterangan", nullable = true )
    private String keterangan;

}
