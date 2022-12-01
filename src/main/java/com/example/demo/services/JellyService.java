package com.example.demo.services;


import com.example.demo.models.Jelly;
import com.example.demo.repository.JellyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JellyService {

    public final JellyRepository jellyRepository;

    public JellyService(JellyRepository jellyRepository){
        this.jellyRepository = jellyRepository;
    }

    public void delete(Jelly jellyObj){jellyRepository.delete(jellyObj);}

    public Optional<Jelly> findById(Long id){return jellyRepository.findById(id);}

    public Jelly save(Jelly jellyObj){return jellyRepository.save(jellyObj);}

    public Iterable<Jelly> findAll(){return jellyRepository.findAll();}

    public List<Jelly> findByNameContains(String word) {
        return jellyRepository.findByNameContains(word);
    }
}
