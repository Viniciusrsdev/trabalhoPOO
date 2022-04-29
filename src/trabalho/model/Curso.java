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
public class Curso {

    private static long serial;
    private final long id;
    private String nome;
    private String estado;
    private Campus campus;
    private Date inicio;
    private Date termino;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Curso() {
        id = ++Curso.serial;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public static long getSerial() {
        return serial;
    }

    public static void setSerial(long serial) {
        Curso.serial = serial;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
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
        final Curso other = (Curso) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    private String periodo() {
        if ("ATIVO".equals(this.estado)) {
            return "desde " + Data.converterDataEmAno(this.inicio);
        } else {

            return "de " + Data.converterDataEmAno(this.inicio) + " até " + Data.converterDataEmAno(this.termino);
        }
    }

    @Override
    public String toString() {
        return id + " -- " + nome + " (" + estado + ") -- " + campus.abreviado() + " -> " + periodo();
    }

}
