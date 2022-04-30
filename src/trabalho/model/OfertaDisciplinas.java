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
 * @author vinic_oh1fkpu
 */
public class OfertaDisciplinas {

    private static long serial;
    private final long id;
    private Disciplina disciplina;
    private Servidor professor;
    private Date ano;
    private String semestre;
    private double horasSemanais;
    private double aulasSemanais;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public OfertaDisciplinas() {
        id = ++OfertaDisciplinas.serial;
    }

    public long getId() {
        return id;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Servidor getProfessor() {
        return professor;
    }

    public void setProfessor(Servidor professor) {
        this.professor = professor;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public double getHorasSemanais() {
        return horasSemanais;
    }

    public void setHorasSemanais(double aulasSemanais) {
        this.horasSemanais = aulasSemanais;
    }

    public double getAulasSemanais() {
        return aulasSemanais;
    }

    public void setAulasSemanais(double aulasSemanais) {
        this.aulasSemanais = aulasSemanais;
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
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final OfertaDisciplinas other = (OfertaDisciplinas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " -- " + disciplina.getNome() + " (" + professor.getNome() + ") -> " + ano + "/" + semestre;
    }

}
