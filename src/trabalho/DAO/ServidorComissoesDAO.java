/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.Utils.Data;
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

            ServidorDAO servidorDAO = new ServidorDAO();
            ComissaoDAO comissaoDAO = new ComissaoDAO();

            ServidorComissoes c1 = new ServidorComissoes();
            c1.setComissao(comissaoDAO.buscaPorId(1));
            c1.setServidor(servidorDAO.buscaPorId(1));
            c1.setPapel("PRESIDENTE");
            c1.setEntrada(Data.converterData("05/11/2006"));
            c1.setSaida(Data.converterData("05/04/2007"));

            adiciona(c1);

            ServidorComissoes c2 = new ServidorComissoes();
            c2.setComissao(comissaoDAO.buscaPorId(2));
            c2.setServidor(servidorDAO.buscaPorId(2));
            c2.setPapel("VICE");
            c2.setEntrada(Data.converterData("05/12/2006"));
            c2.setSaida(Data.converterData("05/04/2007"));

            adiciona(c2);

            ServidorComissoes c3 = new ServidorComissoes();
            c3.setComissao(comissaoDAO.buscaPorId(3));
            c3.setServidor(servidorDAO.buscaPorId(3));
            c3.setPapel("PRESIDENTE");
            c3.setEntrada(Data.converterData("05/11/2006"));
            c3.setSaida(Data.converterData("05/04/2007"));

            adiciona(c3);

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
