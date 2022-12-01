package com.example.demo.services;


import com.example.demo.models.Guitar;
import com.example.demo.models.Jelly;
import com.example.demo.repository.GuitarRepository;
import com.example.demo.repository.JellyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GuitarService {

    public final GuitarRepository guitarRepository;

    public GuitarService(GuitarRepository guitarRepository){
        this.guitarRepository = guitarRepository;
    }

    public void delete(Guitar guitarObj){guitarRepository.delete(guitarObj);}

    public Optional<Guitar> findById(Long id){return guitarRepository.findById(id);}

    public Guitar save(Guitar guitarObj){return guitarRepository.save(guitarObj);}

    public Iterable<Guitar> findAll(){return guitarRepository.findAll();}

    public List<Guitar> findByNameContains(String word) {
        return guitarRepository.findByNameContains(word);
    }
}
