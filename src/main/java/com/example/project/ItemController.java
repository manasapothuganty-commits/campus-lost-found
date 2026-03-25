package com.example.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ItemController {

    @Autowired
    ItemRepository repo;

    @PostMapping("/add")
    public Item addItem(@RequestBody Item item){
        return repo.save(item);
    }

    @GetMapping("/items")
    public List<Item> getItems(){
        return repo.findAll();
    }
   @GetMapping("/match")
public List<Item> matchItem(
        @RequestParam String name,
        @RequestParam String status
){

    List<Item> all = repo.findAll();
    List<Item> matches = new ArrayList<>();

    for(Item i : all){

        // match opposite type + same name
        if(!i.getStatus().equalsIgnoreCase(status) &&
           i.getName().equalsIgnoreCase(name)){

            matches.add(i);
        }
    }

    return matches;
}

}
