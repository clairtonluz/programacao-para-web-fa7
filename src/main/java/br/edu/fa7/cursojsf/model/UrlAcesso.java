package br.edu.fa7.cursojsf.model;

import javax.persistence.*;

@Entity
@Table(name = "url_acessos")
public class UrlAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String url;
    private Long count;

    public UrlAcesso() {
    }

    public UrlAcesso(String url, Long count) {
        this.url = url;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public void incrementCount() {
        this.count++;
    }
}
