package com.example.LeGrandBazar.Controller;

import com.example.LeGrandBazar.Entity.item;
import com.example.LeGrandBazar.Entity.item;
import com.example.LeGrandBazar.Service.itemService;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Getter
@Setter
@RequestMapping("/items")
public class itemController {


    private itemService itemService;

    @GetMapping("/{id}")
    public item getItemById(@PathVariable Long id) {
        return itemService.getItemById(id);
    }

    @GetMapping("/search")
    public List<item> searchItems(@RequestParam(required = false) Double minPrice,
                                  @RequestParam(required = false) Double maxPrice,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String description,
                                  @RequestParam(required = false) String category) {
        return itemService.searchItems(minPrice, maxPrice, name, description, category);
    }

    @PostMapping("/add")
    public item addItem(@RequestBody item item) {
        return itemService.addItem(item);
    }

    @PutMapping("/sell/{id}")
    public void sellItem(@PathVariable Long id) {
        itemService.sellItem(id);
    }


}
