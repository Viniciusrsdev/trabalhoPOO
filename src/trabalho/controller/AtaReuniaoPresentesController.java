/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.model.AtaReuniaoPresentes;
import trabalho.DAO.AtaReuniaoPresentesDAO;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtaReuniaoPresentesController {

    AtaReuniaoPresentesDAO atareuniaopresentesDAO = new AtaReuniaoPresentesDAO();

    public boolean adicionar(AtaReuniaoPresentes atareuniaopresentes) {
        boolean retorno = atareuniaopresentesDAO.adiciona(atareuniaopresentes);
        return retorno;
    }

    public AtaReuniaoPresentes[] listar() {
        return atareuniaopresentesDAO.listar();
    }

    public AtaReuniaoPresentes buscaPorId(String id) {
        long idAtaReuniaoPresentes = Long.parseLong(id);
        return atareuniaopresentesDAO.buscaPorId(idAtaReuniaoPresentes);
    }

    public void removerPorId(String id) {
        long idAtaReuniaoPresentes = Long.parseLong(id);
        atareuniaopresentesDAO.removerPorId(idAtaReuniaoPresentes);
    }
}
