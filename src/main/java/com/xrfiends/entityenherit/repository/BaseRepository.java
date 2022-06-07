package com.xrfiends.entityenherit.repository;

import com.xrfiends.entityenherit.domain.Base;
import com.xrfiends.entityenherit.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository extends JpaRepository<Base, String>, JpaSpecificationExecutor<Base> {
}
