package com.example.demo.repository;

import com.example.demo.models.Jelly;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JellyRepository extends CrudRepository<Jelly, Long> {
    public List<Jelly> findByNameContains(String word);
}
