package com.example.demo.repository;

import com.example.demo.models.Guitar;
import com.example.demo.models.Jelly;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuitarRepository extends CrudRepository<Guitar, Long> {
    public List<Guitar> findByNameContains(String word);
}
