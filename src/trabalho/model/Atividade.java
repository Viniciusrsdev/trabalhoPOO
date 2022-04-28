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
public class Atividade {

    private static long serial;
    private final long id;
    private String descricao;
    private long horasSemanais;
    private Servidor servidor;
    private String inicio;
    private String termino;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Atividade() {
        id = ++Atividade.serial;
    }

    public long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public long getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(long horasSemanais) {
        this.horasSemanais = horasSemanais;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
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
        final Atividade other = (Atividade) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Atividades{" + "id=" + id + ", descricao=" + descricao + ", horasSemanais=" + horasSemanais + ", servidor=" + servidor + ", inicio=" + inicio + ", termino=" + termino + ", dataCriacao=" + dataCriacao + ", dataModificacao=" + dataModificacao + '}';
    }

}
