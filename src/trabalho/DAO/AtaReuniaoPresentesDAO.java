/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.model.AtaReuniaoPresentes;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtaReuniaoPresentesDAO {

    private static AtaReuniaoPresentes[] atareuniaopresentes = new AtaReuniaoPresentes[5];
    private static boolean inicializado = false;

    public AtaReuniaoPresentesDAO() {
        if (!inicializado) {

            inicializado = true;
        }

    }

    public boolean adiciona(AtaReuniaoPresentes aRP) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            atareuniaopresentes[proximaPosicaoLivre] = aRP;
            return true;
        } else {
            return false;
        }

    }

    public AtaReuniaoPresentes[] listar() {
        return atareuniaopresentes;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < atareuniaopresentes.length; i++) {
            if (atareuniaopresentes[i] != null && atareuniaopresentes[i].getId() == id) {
                atareuniaopresentes[i] = null;
            }
        }
    }

    public AtaReuniaoPresentes buscaPorId(long id) {
        for (AtaReuniaoPresentes i : atareuniaopresentes) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < atareuniaopresentes.length; i++) {
            if (atareuniaopresentes[i] == null) {
                return i;
            }

        }
        return -1;

    }
}
