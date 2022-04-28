/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.model.ServidorComissoes;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ServidorComissoesDAO {

    private static ServidorComissoes[] servidorcomissoes = new ServidorComissoes[5];
    private static boolean inicializado = false;

    public ServidorComissoesDAO() {
        if (!inicializado) {
            inicializado = true;
        }

    }

    public boolean adiciona(ServidorComissoes sC) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            servidorcomissoes[proximaPosicaoLivre] = sC;
            return true;
        } else {
            return false;
        }

    }

    public ServidorComissoes[] listar() {
        return servidorcomissoes;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < servidorcomissoes.length; i++) {
            if (servidorcomissoes[i] != null && servidorcomissoes[i].getId() == id) {
                servidorcomissoes[i] = null;
            }
        }
    }

    public ServidorComissoes buscaPorId(long id) {
        for (ServidorComissoes i : servidorcomissoes) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < servidorcomissoes.length; i++) {
            if (servidorcomissoes[i] == null) {
                return i;
            }

        }
        return -1;

    }

}
