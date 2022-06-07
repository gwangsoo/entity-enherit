package com.xrfiends.entityenherit.repository;

import com.xrfiends.entityenherit.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, String> {
}
