package com.sdd.rest.respository;

import com.sdd.rest.entity.Langganan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanggananRepository extends JpaRepository <Langganan, Long> {
    @Query(value = "SELECT * FROM langganan WHERE id_user=:idUser and id_layanan=:idLayanan" , nativeQuery = true)
    List<Langganan> findByIdLayanan(@Param("idUser") Long idUser, @Param("idLayanan") Long idLayanan);

    @Query(value = "SELECT * FROM langganan WHERE id_langganan=:idLangganan and is_valid = true" , nativeQuery = true)
    Langganan findLangganan(@Param("idLangganan") Long idLangganan);
}
