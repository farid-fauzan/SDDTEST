package com.sdd.rest.respository;

import com.sdd.rest.entity.CardInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository <CardInfo, Long> {

}
