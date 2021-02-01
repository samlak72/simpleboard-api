package com.samlasoft.simpleboard.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

@Service
public class SimpleBoardService {

    @Autowired
    PagingAndSortingRepository<SimpleBoard,Long> repository;

    public void save(SimpleBoard simpleBoard){
        repository.save(simpleBoard);
    }

    public Page<SimpleBoard> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }
}
