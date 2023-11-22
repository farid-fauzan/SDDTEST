package com.sdd.rest.respository;

import com.sdd.rest.entity.Layanan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LayananRepository extends JpaRepository <Layanan, Long> {

}
