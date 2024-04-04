package com.example.LeGrandBazar.Service;

import com.example.LeGrandBazar.Entity.item;
import com.example.LeGrandBazar.Repository.itemRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Getter
@Setter
@NoArgsConstructor
public class itemService {


    private itemRepository itemRepository;

    public item getItemById(Long id) {
        return itemRepository.findById(id).orElse(null);
    }

    public List<item> searchItems(Double minPrice, Double maxPrice, String name, String description, String category) {
        return itemRepository.searchItems(minPrice, maxPrice, name, description, category);
    }

    public item addItem(item item) {
        return itemRepository.save(item);
    }

    public void sellItem(Long id) {

        item item = itemRepository.findById(id).orElse(null);
        if (item != null) {
            item.setSold(true);
            itemRepository.save(item);
        }
    }


}
