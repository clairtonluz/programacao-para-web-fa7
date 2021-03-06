package br.edu.fa7.cursojsf.model;

/**
 * Created by efraimgentil<efraimgentil@gmail.com> on 14/02/16.
 */
public class Cep {

  private String regiao;
  private String sufixo;

  public Cep() {
  }

  public Cep(String regiao, String sufixo) {
    this.regiao = regiao;
    this.sufixo = sufixo;
  }

  @Override
  public String toString() {
    return regiao + "-" + sufixo;
  }

  public String getRegiao() {
    return regiao;
  }

  public void setRegiao(String regiao) {
    this.regiao = regiao;
  }

  public String getSufixo() {
    return sufixo;
  }

  public void setSufixo(String sufixo) {
    this.sufixo = sufixo;
  }
}
