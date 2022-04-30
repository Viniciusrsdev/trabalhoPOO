/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import java.util.Date;
import trabalho.DAO.CursoDAO;
import trabalho.Utils.Data;
import trabalho.model.Campus;
import trabalho.model.Curso;

/**
 *
 * @author vinic_oh1fkpu
 */
public class CursoController {

    CursoDAO cursoDAO = new CursoDAO();

    public boolean adicionar(Curso curso) {
        boolean retorno = cursoDAO.adiciona(curso);
        return retorno;
    }

    public Curso[] listar() {
        return cursoDAO.listar();
    }

    public boolean checarListaCampus() {
        return new CampusController().checarListaCampus();
    }

    public boolean checarListaCurso() {
        Curso[] curso = this.listar();
        boolean temCurso = false;
        for (Curso i : curso) {
            if (i != null) {
                temCurso = true;
            }
        }
        return temCurso;
    }

    public Curso buscaPorId(String id) {
        long idCurso = Long.parseLong(id);
        return cursoDAO.buscaPorId(idCurso);
    }

    public void removerPorId(long id) {
        cursoDAO.removerPorId(id);
    }

    public void removerCursosCampusDeletado(Campus c) {
        Curso[] cursos = this.listar();
        for (int i = 0; i < cursos.length; i++) {;
            if (cursos[i] != null && cursos[i].getCampus() == c) {
                Long aux = cursos[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public boolean verificarEstado(String estado) {
        if (!"ATIVO".equals(estado.toUpperCase()) && !"INATIVO".equals(estado.toUpperCase())) {
            return false;
        } else {
            return true;
        }
    }

    public Date verificarAno(String s) {
        Date date = Data.converterDataEmAno(s);
        return date;
    }
}
