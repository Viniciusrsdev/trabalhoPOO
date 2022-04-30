/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import java.util.Date;
import trabalho.model.ServidorComissoes;
import trabalho.DAO.ServidorComissoesDAO;
import trabalho.Utils.Data;
import trabalho.model.Servidor;
import trabalho.model.Comissao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ServidorComissoesController {

    ServidorComissoesDAO servidorcomissoesDAO = new ServidorComissoesDAO();

    public boolean adicionar(ServidorComissoes servidorcomissoes) {
        boolean retorno = servidorcomissoesDAO.adiciona(servidorcomissoes);
        return retorno;
    }

    public ServidorComissoes[] listar() {
        return servidorcomissoesDAO.listar();
    }

    public boolean checarListaComissao() {
        return new ComissaoController().checarListaComissao();
    }

    public boolean checarListaServidor() {
        return new ServidorController().checarListaServidor();
    }

    public boolean checarListaServidorComissoes() {
        ServidorComissoes[] servidorcomissoes = this.listar();
        boolean temServidorComissoes = false;
        for (ServidorComissoes i : servidorcomissoes) {
            if (i != null) {
                temServidorComissoes = true;
            }
        }
        return temServidorComissoes;
    }

    public ServidorComissoes buscaPorId(String id) {
        long idServidorComissoes = Long.parseLong(id);
        return servidorcomissoesDAO.buscaPorId(idServidorComissoes);
    }

    public void removerPorId(long id) {

        servidorcomissoesDAO.removerPorId(id);
    }

    public void removerServidorComissoesServidorDeletado(Servidor s) {
        ServidorComissoes[] servidorcomissoes = this.listar();
        for (int i = 0; i < servidorcomissoes.length; i++) {;
            if (servidorcomissoes[i] != null && servidorcomissoes[i].getServidor() == s) {
                Long aux = servidorcomissoes[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public void removerServidorComissoesComissaoDeletado(Comissao c) {
        ServidorComissoes[] servidorcomissoes = this.listar();
        for (int i = 0; i < servidorcomissoes.length; i++) {;
            if (servidorcomissoes[i] != null && servidorcomissoes[i].getComissao() == c) {
                Long aux = servidorcomissoes[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public boolean verificarPapel(String papel) {
        if (!"PRESIDENTE".equals(papel.toUpperCase()) && !"VICE".equals(papel.toUpperCase()) && !"SECRETARIO".equals(papel.toUpperCase()) && !"PARTICIPANTE".equals(papel.toUpperCase()) && !"SUPLENTE".equals(papel.toUpperCase())) {
            return false;
        } else {
            return true;
        }
    }

    public Date verificarData(String s) {
        Date date = Data.converterData(s);
        return date;
    }
}
