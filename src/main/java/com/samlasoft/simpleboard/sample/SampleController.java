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
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class SampleController {

    @Autowired
    SimpleBoardService simpleBoardService;

    @RequestMapping("/api/v1/hello")
    public Hello hello(){
        LocalTime time = LocalTime.of(LocalTime.now().getHour(),LocalTime.now().getMinute(),LocalTime.now().getSecond());
        return new Hello("samlak", "Hello",LocalDate.now(),time);
    }

    @GetMapping("/api/v1/simpleboards/{page}")
    public Page<SimpleBoard> findAll(@PathVariable int page, Pageable pageable){

        pageable = PageRequest.of(page,pageable.getPageSize(), Sort.by("id").descending());
        return simpleBoardService.findAll(pageable);
    }

    @PostMapping("/api/v1/simpleboard")
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

    @PutMapping("/api/v1/simpleboard")
    public Result updateMessage(@RequestBody SimpleBoard simpleBoard){
        Result result = new Result(200,"Success!");
        try{
            simpleBoardService.save(simpleBoard);
        }catch(Exception e){
            e.printStackTrace();
            result = new Result(500, "Error!");
        }

        return result;
    }

    @DeleteMapping("/api/v1/simpleboard")
    @ResponseBody
    public Result deleteMessage(@RequestBody SimpleBoard simpleBoard ){
        Result result = new Result(200,"Success!");
        try{
            simpleBoardService.remove(simpleBoard);
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
