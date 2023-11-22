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
@Table(name = "layanan", schema = "db_sdd")
public class Layanan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_layanan", nullable = false)
    private Long idLayanan;

    @Column(name = "nama_layanan", nullable = true )
    private String namaLayanan;

    @Column(name = "harga_pertemuan", nullable = true )
    private Double hargaPertemuan;

    @Column(name = "jadwal", nullable = true )
    private String jadwal;

    @Column(name = "jumlah_pertemuan", nullable = true )
    private Long jumlahPertemuan;

}
