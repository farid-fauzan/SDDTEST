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
@Table(name = "langganan", schema = "db_sdd")
public class Langganan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_langganan", nullable = false)
    private Long idLangganan;

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

    @Column(name = "total_biaya", nullable = false )
    private Double totalBiaya;

}
