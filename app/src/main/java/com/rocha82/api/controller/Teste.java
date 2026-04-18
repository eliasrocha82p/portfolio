package com.rocha82.api.controller.Test;
import com.rocha82.list.LinkedList;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/person")
public class Teste{
    @GetMapping("/{id}")
    public String person(){
        LinkedList ll=new LinkedList();
        ll.add("teste");
        return ll.get(0);
    }
}