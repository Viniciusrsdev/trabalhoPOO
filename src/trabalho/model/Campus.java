/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Campus {

   private static long serial;
    private final long id;
    private String nome;
    private String abreviacao;
    private long duracaoAulas;
    private Date dataCriacaoCampus;
    private String cidade;
    private String bairro;
    private String endereco;
    private String cep;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Campus() {
        id = ++Campus.serial;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public long getDuracaoAulas() {
        return duracaoAulas;
    }

    public void setDuracaoAulas(long duracaoAulas) {
        this.duracaoAulas = duracaoAulas;
    }

    public static long getSerial() {
        return serial;
    }

    public static void setSerial(long serial) {
        Campus.serial = serial;
    }

    public Date getDataCriacaoCampus() {
        return dataCriacaoCampus;
    }

    public void setDataCriacaoCampus(Date dataCriacaoCampus) {
        this.dataCriacaoCampus = dataCriacaoCampus;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Campus other = (Campus) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome + " {id=" + id + ", abreviacao=" + abreviacao + ", duracaoAulas=" + duracaoAulas + ", dataCriacaoCampus=" + dataCriacaoCampus + ", cidade=" + cidade + ", bairro=" + bairro + ", endereco=" + endereco + ", cep=" + cep + '}';
    }

}
