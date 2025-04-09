package br.com.fiap.roardemo.service;

import br.com.fiap.roardemo.model.Roar;
import br.com.fiap.roardemo.repository.RoarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoarService {

    private final RoarRepository repository;

    public RoarService(RoarRepository repository) {
        this.repository = repository;
    }

    public List<Roar> listAll() {
        return repository.findAllByOrderByCreatedAtDesc();
    }

    public void save(Roar roar) {
        repository.save(roar);
    }

    public void like(Long id) {
        Roar roar = repository.findById(id).orElseThrow();
        roar.setLikes(roar.getLikes() + 1);
        repository.save(roar);
    }
}