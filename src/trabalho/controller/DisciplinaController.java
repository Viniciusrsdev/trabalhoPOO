/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.model.Disciplina;
import trabalho.DAO.DisciplinaDAO;

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

    public Disciplina buscaPorId(String id) {
        long idDisciplina = Long.parseLong(id);
        return disciplinaDAO.buscaPorId(idDisciplina);
    }

    public void removerPorId(String id) {
        long idDisciplina = Long.parseLong(id);
        disciplinaDAO.removerPorId(idDisciplina);
    }

}
