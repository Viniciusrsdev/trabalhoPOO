/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.model.Orientacao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class OrientacaoDAO {

    private static Orientacao[] orientacoes = new Orientacao[5];
    private static boolean inicializado = false;

    public OrientacaoDAO() {
        if (!inicializado) {
            inicializado = true;
        }
    }

    public boolean adiciona(Orientacao o) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            orientacoes[proximaPosicaoLivre] = o;
            return true;
        } else {
            return false;
        }

    }

    public Orientacao[] listar() {
        return orientacoes;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < orientacoes.length; i++) {
            if (orientacoes[i] != null && orientacoes[i].getId() == id) {
                orientacoes[i] = null;
            }
        }
    }

    public Orientacao buscaPorId(long id) {
        for (Orientacao i : orientacoes) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < orientacoes.length; i++) {
            if (orientacoes[i] == null) {
                return i;
            }

        }
        return -1;

    }
}
