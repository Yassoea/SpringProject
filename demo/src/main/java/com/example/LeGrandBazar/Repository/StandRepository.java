package com.example.LeGrandBazar.Repository;

import com.example.LeGrandBazar.Entity.Stand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface StandRepository extends JpaRepository<Stand, Long> {

}
