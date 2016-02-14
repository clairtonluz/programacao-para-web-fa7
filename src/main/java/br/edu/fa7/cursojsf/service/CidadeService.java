package br.edu.fa7.cursojsf.service;

import br.edu.fa7.cursojsf.model.Cidade;
import br.edu.fa7.cursojsf.repository.CidadeRepository;

import javax.inject.Inject;

/**
 * Created by clairtonluz on 13/02/16.
 */
public class CidadeService {

    @Inject
    private CidadeRepository cidadeRepository;

    public Cidade save(Cidade cidade) {
        return cidadeRepository.save(cidade);
    }

    public void remove(Long id) {
        cidadeRepository.remove(cidadeRepository.findById(id));
    }

    public Cidade findById(Long id) {
        return cidadeRepository.findById(id);
    }
}
