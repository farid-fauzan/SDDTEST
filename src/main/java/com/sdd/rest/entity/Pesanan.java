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
@Table(name = "pesanan", schema = "db_sdd")
public class Pesanan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pesanan", nullable = false)
    private Long idPesanan;

    @Column(name = "id_user", nullable = false )
    private Long idUser;

    @Column(name = "id_layanan", nullable = false )
    private Long idLayanan;

    @Column(name = "sisa_pertemuan", nullable = true )
    private Integer sisaPertemuan;

    @Column(name = "status_langganan", nullable = true )
    private boolean statusLangganan;

    @Column(name = "is_valid", nullable = false )
    private boolean isValid;

}
