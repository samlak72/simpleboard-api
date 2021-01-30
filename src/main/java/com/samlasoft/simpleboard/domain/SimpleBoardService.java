package com.samlasoft.simpleboard.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SimpleBoardService {

    @Autowired
    JpaRepository<SimpleBoard,Long> repository;

    public void save(SimpleBoard simpleBoard){
        repository.save(simpleBoard);
    }

    public List<SimpleBoard> findAll(){
        return repository.findAll();
    }
}
