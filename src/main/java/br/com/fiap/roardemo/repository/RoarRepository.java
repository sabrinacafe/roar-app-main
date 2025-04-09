package br.com.fiap.roardemo.repository;

import br.com.fiap.roardemo.model.Roar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoarRepository extends JpaRepository<Roar, Long> {

    // Buscar todos os roars em ordem decrescente de criação
    List<Roar> findAllByOrderByCreatedAtDesc();
}