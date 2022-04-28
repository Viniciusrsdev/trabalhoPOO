/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.model.Atividade;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtividadeDAO {

    private static Atividade[] atividades = new Atividade[5];
    private static boolean inicializado = false;

    public AtividadeDAO() {
        if (!inicializado) {

            inicializado = true;
        }

    }

    public boolean adiciona(Atividade a) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            atividades[proximaPosicaoLivre] = a;
            return true;
        } else {
            return false;
        }

    }

    public Atividade[] listar() {
        return atividades;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < atividades.length; i++) {
            if (atividades[i] != null && atividades[i].getId() == id) {
                atividades[i] = null;
            }
        }
    }

    public Atividade buscaPorId(long id) {
        for (Atividade i : atividades) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < atividades.length; i++) {
            if (atividades[i] == null) {
                return i;
            }

        }
        return -1;

    }
}
