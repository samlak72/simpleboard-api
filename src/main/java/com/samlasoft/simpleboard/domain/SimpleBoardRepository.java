package com.samlasoft.simpleboard.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleBoardRepository extends JpaRepository<SimpleBoard,Long>  {
}
