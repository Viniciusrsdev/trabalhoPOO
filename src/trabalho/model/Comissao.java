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
public class Comissao {

    private static long serial;
    private final long id;
    private long horasSemanais;
    private String inicio;
    private String termino;
    private String estado;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Comissao() {
        id = ++Comissao.serial;
    }

    public long getId() {
        return id;
    }

    public long getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(long horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    @Override
    public String toString() {
        return "Comissoes{" + "id=" + id + ", horasSemanais=" + horasSemanais + ", inicio=" + inicio + ", termino=" + termino + ", estado=" + estado + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

}
