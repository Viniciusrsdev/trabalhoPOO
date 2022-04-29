/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.model.Disciplina;
import trabalho.DAO.DisciplinaDAO;
import trabalho.model.Curso;

/**
 *
 * @author vinic_oh1fkpu
 */
public class DisciplinaController {

    DisciplinaDAO disciplinaDAO = new DisciplinaDAO();

    public boolean adicionar(Disciplina disciplina) {
        boolean retorno = disciplinaDAO.adiciona(disciplina);
        return retorno;
    }

    public Disciplina[] listar() {
        return disciplinaDAO.listar();
    }
    
    public boolean checarListaCurso() {
        return new CursoController().checarListaCurso();
    }
    
    public boolean checarListaDisciplina() {
        Disciplina[] disciplina = this.listar();
        boolean temDisciplina = false;
        for (Disciplina i : disciplina) {
            if (i != null) {
                temDisciplina = true;
            }
        }
        return temDisciplina;
    }

    public Disciplina buscaPorId(String id) {
        long idDisciplina = Long.parseLong(id);
        return disciplinaDAO.buscaPorId(idDisciplina);
    }

    public void removerPorId(Long id) {
        
        disciplinaDAO.removerPorId(id);
    }
    
    public void removerDisciplinasCursoDeletado(Curso c) {
        Disciplina[] disciplinas = this.listar();
        for (int i = 0; i < disciplinas.length; i++) {;
            if (disciplinas[i] != null && disciplinas[i].getCurso() == c) {
                Long aux = disciplinas[i].getId();
                this.removerPorId(aux);
            }
        }
    }
    public boolean verificarPeriodicidade(String periodicidade) {
        if (!"SEMESTRAL".equals(periodicidade.toUpperCase()) && !"ANUAL".equals(periodicidade.toUpperCase())) {
            return false;
        } else {
            return true;
        }
    }
}
