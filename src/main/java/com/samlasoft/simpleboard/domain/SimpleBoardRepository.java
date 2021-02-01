package com.samlasoft.simpleboard.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimpleBoardRepository extends PagingAndSortingRepository<SimpleBoard,Long> {
    Page<SimpleBoard> findAll(Pageable pageable);
}
