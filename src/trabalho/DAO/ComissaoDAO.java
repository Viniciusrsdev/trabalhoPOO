/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.Utils.Data;
import trabalho.controller.AtaReuniaoPresentesController;
import trabalho.controller.ServidorComissoesController;
import trabalho.model.Comissao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ComissaoDAO {

    private static Comissao[] comissoes = new Comissao[5];
    private static boolean inicializado = false;

    public ComissaoDAO() {
        if (!inicializado) {
            
            Comissao c1 = new Comissao();
            c1.setNome("Comissão de Ética");
            c1.setEstado("INATIVO");
            c1.setInicio(Data.converterData("02/02/2022"));
            c1.setTermino(Data.converterData("22/06/2022"));
            c1.setHorasSemanais(5);

            adiciona(c1);
            
            Comissao c2 = new Comissao();
            c2.setNome("Comissão Interna de Supervisão");
            c2.setEstado("ATIVO");
            c2.setInicio(Data.converterData("02/02/2022"));
            c2.setHorasSemanais(3);

            adiciona(c2);
            
            Comissao c3 = new Comissao();
            c3.setNome("Comissão Própria de Avaliação");
            c3.setEstado("ATIVO");
            c3.setInicio(Data.converterData("02/02/2022"));
            c3.setHorasSemanais(4);

            adiciona(c3);
            inicializado = true;
        }

    }

    public boolean adiciona(Comissao c) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            comissoes[proximaPosicaoLivre] = c;
            return true;
        } else {
            return false;
        }

    }

    public Comissao[] listar() {
        return comissoes;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < comissoes.length; i++) {
            if (comissoes[i] != null && comissoes[i].getId() == id) {
                
                new ServidorComissoesController().removerServidorComissoesComissaoDeletado(comissoes[i]);
                new AtaReuniaoPresentesController().removerAtaReuniaoPresentesComissaoDeletado(comissoes[i]);
                comissoes[i] = null;
            }
        }
    }

    public Comissao buscaPorId(long id) {
        for (Comissao i : comissoes) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < comissoes.length; i++) {
            if (comissoes[i] == null) {
                return i;
            }

        }
        return -1;

    }
}