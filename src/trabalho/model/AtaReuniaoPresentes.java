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
public class AtaReuniaoPresentes {

    private static long serial;
    private final long id;
    private Comissao comissao;
    private AtaReuniao ata;
    private Servidor servidor;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public AtaReuniaoPresentes() {
        id = ++AtaReuniaoPresentes.serial;
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

    public AtaReuniao getAta() {
        return ata;
    }

    public void setAta(AtaReuniao ata) {
        this.ata = ata;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
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
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final AtaReuniaoPresentes other = (AtaReuniaoPresentes) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " -- " + comissao.getNome() + " (" + ata.getConteudo() + " -> " + servidor.getNome();
    }

}
