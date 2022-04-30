/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.model.AtaReuniaoPresentes;
import trabalho.DAO.AtaReuniaoPresentesDAO;
import trabalho.model.Servidor;
import trabalho.model.Comissao;
import trabalho.model.AtaReuniao;

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

    public boolean checarListaServidor() {
        return new ServidorController().checarListaServidor();
    }

    public boolean checarListaComissao() {
        return new ComissaoController().checarListaComissao();
    }

    public boolean checarListaAtaReuniao() {
        return new AtaReuniaoController().checarListaAtaReuniao();
    }

    public boolean checarListaAtaReuniaoPresentes() {
        AtaReuniaoPresentes[] atareuniaopresentes = this.listar();
        boolean temAtaReuniaoPresentes = false;
        for (AtaReuniaoPresentes i : atareuniaopresentes) {
            if (i != null) {
                temAtaReuniaoPresentes = true;
            }
        }
        return temAtaReuniaoPresentes;
    }

    public AtaReuniaoPresentes buscaPorId(String id) {
        long idAtaReuniaoPresentes = Long.parseLong(id);
        return atareuniaopresentesDAO.buscaPorId(idAtaReuniaoPresentes);
    }

    public void removerPorId(long id) {

        atareuniaopresentesDAO.removerPorId(id);
    }

    public void removerAtaReuniaoPresentesServidorDeletado(Servidor s) {
        AtaReuniaoPresentes[] atareuniaopresentes = this.listar();
        for (int i = 0; i < atareuniaopresentes.length; i++) {;
            if (atareuniaopresentes[i] != null && atareuniaopresentes[i].getServidor() == s) {
                Long aux = atareuniaopresentes[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public void removerAtaReuniaoPresentesComissaoDeletado(Comissao c) {
        AtaReuniaoPresentes[] atareuniaopresentes = this.listar();
        for (int i = 0; i < atareuniaopresentes.length; i++) {;
            if (atareuniaopresentes[i] != null && atareuniaopresentes[i].getComissao() == c) {
                Long aux = atareuniaopresentes[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public void removerAtaReuniaoPresentesAtaReuniaoDeletado(AtaReuniao aR) {
        AtaReuniaoPresentes[] atareuniaopresentes = this.listar();
        for (int i = 0; i < atareuniaopresentes.length; i++) {;
            if (atareuniaopresentes[i] != null && atareuniaopresentes[i].getAta() == aR) {
                Long aux = atareuniaopresentes[i].getId();
                this.removerPorId(aux);
            }
        }
    }
}
