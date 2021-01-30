package com.samlasoft.simpleboard.sample;

import com.samlasoft.simpleboard.domain.SimpleBoard;
import com.samlasoft.simpleboard.domain.SimpleBoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class SampleController {

    @Autowired
    SimpleBoardService simpleBoardService;

    @RequestMapping("/hello")
    public Hello hello(){
        SimpleBoard simpleBoard = new SimpleBoard();
        simpleBoard.setMessage("hello samlak!");

        simpleBoardService.save(simpleBoard);

        return new Hello("samlak", "Hello",LocalDate.now(),LocalTime.now());
    }

    @RequestMapping("/findAll")
    public List<SimpleBoard> findAll(){

        return simpleBoardService.findAll();
    }

}

@Getter
@AllArgsConstructor
class Hello {
    String name;
    String hello;
    LocalDate date;
    LocalTime time;
}
