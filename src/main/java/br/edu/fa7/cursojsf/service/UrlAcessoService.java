package br.edu.fa7.cursojsf.service;

import br.edu.fa7.cursojsf.model.UrlAcesso;
import br.edu.fa7.cursojsf.repository.UrlAcessoRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by clairtonluz on 13/02/16.
 */
public class UrlAcessoService {

    @Inject
    private UrlAcessoRepository urlAcessoRepository;

    public void incrementCountUrl(String url) {
        UrlAcesso urlAcesso = urlAcessoRepository.findByUrl(url);
        if (urlAcesso == null) {
            urlAcesso = new UrlAcesso(url, 0L);
        }

        urlAcesso.incrementCount();

        urlAcessoRepository.save(urlAcesso);
    }

    public List<UrlAcesso> findAll() {
        return urlAcessoRepository.findAll();
    }
}
