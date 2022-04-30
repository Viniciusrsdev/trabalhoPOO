/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import java.util.Date;
import trabalho.DAO.OfertaDisciplinasDAO;
import trabalho.Utils.Data;
import trabalho.model.OfertaDisciplinas;
import trabalho.model.Servidor;
import trabalho.model.Disciplina;

/**
 *
 * @author vinic_oh1fkpu
 */
public class OfertaDisciplinasController {

    OfertaDisciplinasDAO ofertadisciplinasDAO = new OfertaDisciplinasDAO();

    public boolean adicionar(OfertaDisciplinas ofertadisciplinas) {
        boolean retorno = ofertadisciplinasDAO.adiciona(ofertadisciplinas);
        //   if (retorno){
        //       new AtividadeController().criaPrepAula(ofertadisciplinas);
        //  }
        return retorno;
    }

    public OfertaDisciplinas[] listar() {
        return ofertadisciplinasDAO.listar();
    }

    public boolean checarListaServidor() {
        return new ServidorController().checarListaServidor();
    }

    public boolean checarListaDisciplina() {
        return new DisciplinaController().checarListaDisciplina();
    }

    public boolean checarListaOfertaDisciplinas() {
        OfertaDisciplinas[] ofertadisciplinas = this.listar();
        boolean temOfertaDisciplinas = false;
        for (OfertaDisciplinas i : ofertadisciplinas) {
            if (i != null) {
                temOfertaDisciplinas = true;
            }
        }
        return temOfertaDisciplinas;
    }

    public OfertaDisciplinas buscaPorId(String id) {
        long idOfertaDisciplinas = Long.parseLong(id);
        return ofertadisciplinasDAO.buscaPorId(idOfertaDisciplinas);
    }

    public void removerPorId(long id) {

        ofertadisciplinasDAO.removerPorId(id);
    }

    public void removerOfertaDisciplinasServidorDeletado(Servidor s) {
        OfertaDisciplinas[] ofertadisciplinas = this.listar();
        for (int i = 0; i < ofertadisciplinas.length; i++) {;
            if (ofertadisciplinas[i] != null && ofertadisciplinas[i].getProfessor() == s) {
                Long aux = ofertadisciplinas[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public void removerOfertaDisciplinasDisciplinaDeletado(Disciplina d) {
        OfertaDisciplinas[] ofertadisciplinas = this.listar();
        for (int i = 0; i < ofertadisciplinas.length; i++) {;
            if (ofertadisciplinas[i] != null && ofertadisciplinas[i].getDisciplina() == d) {
                Long aux = ofertadisciplinas[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public Date verificarAno(String s) {
        Date date = Data.converterDataEmAno(s);
        return date;
    }

}
