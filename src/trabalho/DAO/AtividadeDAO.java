/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.Utils.Data;
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

            ServidorDAO servidorDAO = new ServidorDAO();
            Atividade a1 = new Atividade();

            a1.setDescricao("Preparacao de Aula - Banco de Dados");
            a1.setHorasSemanais(5);
            a1.setServidor(servidorDAO.buscaPorId(3));
            a1.setInicio(Data.converterData("02/02/2022"));
            a1.setTermino(Data.converterData("22/06/2022"));

            adiciona(a1);

            Atividade a2 = new Atividade();

            a2.setDescricao("Preparacao de Aula - Programacao Orientada a Objetos");
            a2.setHorasSemanais(6);
            a2.setServidor(servidorDAO.buscaPorId(1));
            a2.setInicio(Data.converterData("12/02/2020"));
            a2.setTermino(Data.converterData("27/06/2020"));

            adiciona(a2);

            Atividade a3 = new Atividade();

            a3.setDescricao("Preparacao de Aula - Programacao Orientada a Objetos");
            a3.setHorasSemanais(6);
            a3.setServidor(servidorDAO.buscaPorId(1));
            a3.setInicio(Data.converterData("02/02/2020"));
            a3.setTermino(Data.converterData("22/06/2020"));

            adiciona(a3);

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
