/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.model.AtaReuniao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtaReuniaoDAO {

    private static AtaReuniao[] atareunioes = new AtaReuniao[5];
    private static boolean inicializado = false;

    public AtaReuniaoDAO() {

        if (!inicializado) {

            inicializado = true;
        }

    }

    public boolean adiciona(AtaReuniao aR) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            atareunioes[proximaPosicaoLivre] = aR;
            return true;
        } else {
            return false;
        }

    }

    public AtaReuniao[] listar() {
        return atareunioes;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < atareunioes.length; i++) {
            if (atareunioes[i] != null && atareunioes[i].getId() == id) {
                atareunioes[i] = null;
            }
        }
    }

    public AtaReuniao buscaPorId(long id) {
        for (AtaReuniao i : atareunioes) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < atareunioes.length; i++) {
            if (atareunioes[i] == null) {
                return i;
            }

        }
        return -1;

    }
}
