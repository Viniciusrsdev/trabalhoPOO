/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.Utils.Data;
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

            ServidorDAO servidorDAO = new ServidorDAO();

            Orientacao o1 = new Orientacao();

            o1.setTipo("ENSINO");
            o1.setNomeAluno("Vinicius Rodrigues de Sousa");
            o1.setHorasSemanais(2);
            o1.setServidor(servidorDAO.buscaPorId(1));
            o1.setInicio(Data.converterData("02/02/2022"));
            o1.setTermino(Data.converterData("22/06/2022"));

            adiciona(o1);

            Orientacao o2 = new Orientacao();

            o2.setTipo("Pesquisa");
            o2.setNomeAluno("Caio Freitas");
            o2.setHorasSemanais(3);
            o2.setServidor(servidorDAO.buscaPorId(1));
            o2.setInicio(Data.converterData("02/02/2022"));
            o2.setTermino(Data.converterData("22/06/2022"));

            adiciona(o2);

            Orientacao o3 = new Orientacao();

            o3.setTipo("ENSINO");
            o3.setNomeAluno("Ronildo Cesar");
            o3.setHorasSemanais(2);
            o3.setServidor(servidorDAO.buscaPorId(2));
            o3.setInicio(Data.converterData("02/02/2022"));
            o3.setTermino(Data.converterData("22/06/2022"));

            adiciona(o3);
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
