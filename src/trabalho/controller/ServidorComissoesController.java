/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.model.ServidorComissoes;
import trabalho.DAO.ServidorComissoesDAO;

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

    public ServidorComissoes buscaPorId(String id) {
        long idServidorComissoes = Long.parseLong(id);
        return servidorcomissoesDAO.buscaPorId(idServidorComissoes);
    }

    public void removerPorId(String id) {
        long idServidorComissoes = Long.parseLong(id);
        servidorcomissoesDAO.removerPorId(idServidorComissoes);
    }
}
