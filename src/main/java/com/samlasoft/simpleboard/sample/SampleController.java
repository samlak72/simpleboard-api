package com.samlasoft.simpleboard.sample;

import com.samlasoft.simpleboard.domain.SimpleBoard;
import com.samlasoft.simpleboard.domain.SimpleBoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class SampleController {

    @Autowired
    SimpleBoardService simpleBoardService;

    @RequestMapping("/hello")
    public Hello hello(){
        return new Hello("samlak", "Hello",LocalDate.now(),LocalTime.now());
    }

    @RequestMapping("/findAll")
    public Page<SimpleBoard> findAll(Pageable pageable){

        pageable = PageRequest.of(pageable.getPageNumber(),pageable.getPageSize(), Sort.by("id").descending());
        return simpleBoardService.findAll(pageable);
    }

    @RequestMapping("/saveMessage")
    public Result saveMessage(@RequestBody SimpleBoard simpleBoard){
        Result result = new Result(200,"Success!");
        try{
            simpleBoardService.save(simpleBoard);
        }catch(Exception e){
            e.printStackTrace();
            result = new Result(500, "Error!");
        }

        return result;
    }

}

@Setter
@Getter
@AllArgsConstructor
class Result {
    int code;
    String message;
}

@Getter
@AllArgsConstructor
class Hello {
    String name;
    String hello;
    LocalDate date;
    LocalTime time;
}
