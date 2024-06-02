package com.java.firebase;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class crudController {
    public crudService crudService;
    public crudController(crudService crudService){
        this.crudService=crudService;
    }

    @PostMapping("/create")
    public String createCrud(@RequestBody crud crud) throws InterruptedException, ExecutionException{
        return crudService.createCrud(crud);
    }
    @GetMapping("/get")
    public crud getCrud(@RequestParam String id) throws InterruptedException, ExecutionException{
        return crudService.getCrud(id);
    }
    @PutMapping("/update")
    public String updateCrud(@RequestBody crud crud) throws InterruptedException, ExecutionException{
        return crudService.updateCrud(crud);
    }
    @PutMapping("/delete")
    public String deleteCrud(@RequestParam String id) throws InterruptedException, ExecutionException{
        return crudService.deleteCrud(id);
    }


}
