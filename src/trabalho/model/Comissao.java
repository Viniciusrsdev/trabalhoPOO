/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.model;

import java.time.LocalDateTime;
import java.util.Date;
import trabalho.Utils.Data;

/**
 *
 * @author vinic_oh1fkpu
 */
public class Comissao {

    private static long serial;
    private final long id;
    private String nome;
    private double horasSemanais;
    private Date inicio;
    private Date termino;
    private String estado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Comissao() {
        id = ++Comissao.serial;
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

    public double getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(double horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado.toUpperCase();
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
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Comissao other = (Comissao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    private String formatarDatas() {
        if (estado == "ATIVO") {
            return Data.converterData(inicio) + "ate" + Data.converterData(termino);
        } else {
            return "Ativo desde " + Data.converterData(inicio);
        }
    }

    @Override
    public String toString() {
        return id + " -- " + nome + " (" + estado + ") -- Horas semanais: " + horasSemanais + " -> Inicio: " + inicio + " Termino: " + termino;
    }

}
