/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.DAO.OfertaDisciplinasDAO;
import trabalho.model.OfertaDisciplinas;

/**
 *
 * @author vinic_oh1fkpu
 */
public class OfertaDisciplinasController {

    OfertaDisciplinasDAO ofertadisciplinasDAO = new OfertaDisciplinasDAO();

    public boolean adicionar(OfertaDisciplinas ofertadisciplinas) {
        boolean retorno = ofertadisciplinasDAO.adiciona(ofertadisciplinas);
        if (retorno){
            new AtividadeController().criaPrepAula(ofertadisciplinas);
        }
        return retorno;
    }

    public OfertaDisciplinas[] listar() {
        return ofertadisciplinasDAO.listar();
    }

    public OfertaDisciplinas buscaPorId(String id) {
        long idOfertaDisciplinas = Long.parseLong(id);
        return ofertadisciplinasDAO.buscaPorId(idOfertaDisciplinas);
    }

    public void removerPorId(String id) {
        long idOfertaDisciplinas = Long.parseLong(id);
        ofertadisciplinasDAO.removerPorId(idOfertaDisciplinas);
    }

}
