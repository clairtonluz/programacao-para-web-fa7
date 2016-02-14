package br.edu.fa7.cursojsf.service;

import br.edu.fa7.cursojsf.model.Estado;
import br.edu.fa7.cursojsf.repository.EstadoRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by clairtonluz on 13/02/16.
 */
public class EstadoService {

    @Inject
    private EstadoRepository estadoRepository;

    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    public Estado save(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void remove(Long id) {
        estadoRepository.remove(estadoRepository.findById(id));
    }

    public Estado findById(Long id) {
        return estadoRepository.findById(id);
    }
}
