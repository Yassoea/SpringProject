package com.example.LeGrandBazar.Repository;

import com.example.LeGrandBazar.Entity.item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface itemRepository extends JpaRepository<item, Long> {

    List<item> searchItems(Double minPrice, Double maxPrice, String name, String description, String category);

}
