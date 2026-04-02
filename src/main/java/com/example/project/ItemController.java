package com.example.project;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ItemController {

    @Autowired
    ItemRepository repo;

    // ✅ ADD ITEM
    @PostMapping("/add")
    public Item addItem(@RequestBody Item item){
        item.setCreatedAt(LocalDateTime.now()); // ⭐ auto date
        return repo.save(item);
    }

    // ✅ GET ALL ITEMS
    @GetMapping("/items")
    public List<Item> getItems(){
        return repo.findAll();
    }

    // 🔥 SMART MATCH
    @GetMapping("/match")
    public List<Item> matchItem(
            @RequestParam String name,
            @RequestParam String status
    ){

        List<Item> all = repo.findAll();
        List<Item> matches = new ArrayList<>();

        for(Item i : all){

            if(!i.getStatus().equalsIgnoreCase(status) &&
               i.getName().toLowerCase().contains(name.toLowerCase())){

                matches.add(i);
            }
        }

        return matches;
    }

    // 🔥 RESOLVE ITEM (ADVANCED FEATURE)
    @PutMapping("/resolve/{id}")
    public Item resolveItem(@PathVariable int id){
        Item item = repo.findById(id).orElse(null);

        if(item != null){
            item.setStatus("RESOLVED");
            return repo.save(item);
        }

        return null;
    }
}








// package com.example.project;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// @CrossOrigin
// public class ItemController {

//     @Autowired
//     ItemRepository repo;

//     @PostMapping("/add")
//     public Item addItem(@RequestBody Item item){
//         return repo.save(item);
//     }

//     @GetMapping("/items")
//     public List<Item> getItems(){
//         return repo.findAll();
//     }
//    @GetMapping("/match")
// public List<Item> matchItem(
//         @RequestParam String name,
//         @RequestParam String status
// ){

//     List<Item> all = repo.findAll();
//     List<Item> matches = new ArrayList<>();

//     for(Item i : all){

//         // match opposite type + same name
//         if(!i.getStatus().equalsIgnoreCase(status) &&
//            i.getName().equalsIgnoreCase(name)){

//             matches.add(i);
//         }
//     }

//     return matches;
// }

// }
