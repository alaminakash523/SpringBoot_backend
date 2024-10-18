package com.akash.portfolio.Controller;

import com.akash.portfolio.dao.WorksDao;
import com.akash.portfolio.model.MyWorks;
import com.akash.portfolio.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/works")
public class WorksController {

    @Autowired
    WorkService worksService;


    @GetMapping("/all_works")
    public ResponseEntity<List<MyWorks>> getAllWorks(){
        return worksService.getAllWorks();
    }

    @GetMapping("/work/{workId}")
    public ResponseEntity<MyWorks> getWorkById(@PathVariable("workId") int workId){
        return worksService.getWorksById(workId);
    }




    @PutMapping("/updateWork")
    public ResponseEntity<String> updateWork(@RequestBody MyWorks myWorks){
        return worksService.updateWork(myWorks);
    }

    @DeleteMapping("/delete-work/{workId}")
    public ResponseEntity<String> deleteWork(@PathVariable("workId") int workId){
        return worksService.deleteWork(workId);
    }

    @PostMapping("/add-Work")
    public ResponseEntity<String> addWork(@RequestBody MyWorks myWorks){
        return worksService.addWork(myWorks);
    }

}
