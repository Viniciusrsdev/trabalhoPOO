/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.Utils.Data;
import trabalho.controller.AtaReuniaoPresentesController;
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
            
            ComissaoDAO comissaoDAO = new ComissaoDAO();
            ServidorDAO servidorDAO = new ServidorDAO();
            
            AtaReuniao aR1 = new AtaReuniao();

            aR1.setComissao(comissaoDAO.buscaPorId(1));
            aR1.setSecretario(servidorDAO.buscaPorId(1));
            aR1.setConteudo("Reuniao geral");
            aR1.setData(Data.converterData("02/02/2022"));

            adiciona(aR1);
            
            AtaReuniao aR2 = new AtaReuniao();
            
            aR2.setComissao(comissaoDAO.buscaPorId(2));
            aR2.setSecretario(servidorDAO.buscaPorId(1));
            aR2.setConteudo("Reuniao de planejamento");
            aR2.setData(Data.converterData("02/12/2022"));
            
            adiciona(aR2);
            
            AtaReuniao aR3 = new AtaReuniao();
            
            aR3.setComissao(comissaoDAO.buscaPorId(3));
            aR3.setSecretario(servidorDAO.buscaPorId(2));
            aR3.setConteudo("Reuniao geral");
            aR3.setData(Data.converterData("02/02/2022"));
            
            adiciona(aR3);

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
                
                new AtaReuniaoPresentesController().removerAtaReuniaoPresentesAtaReuniaoDeletado(atareunioes[i]);
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
