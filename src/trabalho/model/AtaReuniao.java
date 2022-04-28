/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.model;

import java.time.LocalDateTime;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtaReuniao {

    private static long serial;
    private final long id;
    private Comissao comissao;
    private String data;
    private String conteudo;
    private Servidor secretario;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public AtaReuniao() {
        id = ++AtaReuniao.serial;
    }

    public long getId() {
        return id;
    }

    public Comissao getComissao() {
        return comissao;
    }

    public void setComissao(Comissao comissao) {
        this.comissao = comissao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public Servidor getSecretario() {
        return secretario;
    }

    public void setSecretario(Servidor secretario) {
        this.secretario = secretario;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final AtaReuniao other = (AtaReuniao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reunioes{" + "id=" + id + ", comissao=" + comissao + ", data=" + data + ", conteudo=" + conteudo + ", secretario=" + secretario + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

}
