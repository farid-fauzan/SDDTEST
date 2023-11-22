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
@Table(name = "card_info", schema = "db_sdd")
public class CardInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_card", nullable = false)
    private Long idCard;

    @Column(name = "id_user", nullable = false )
    private Long idUser;

    @Column(name = "data", nullable = false )
    private String data;

}
