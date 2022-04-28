/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.model.Comissao;
import trabalho.DAO.ComissaoDAO;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ComissaoController {

    ComissaoDAO comissaoDAO = new ComissaoDAO();

    public boolean adicionar(Comissao comissao) {
        boolean retorno = comissaoDAO.adiciona(comissao);
        return retorno;
    }

    public Comissao[] listar() {
        return comissaoDAO.listar();
    }

    public Comissao buscaPorId(String id) {
        long idComissao = Long.parseLong(id);
        return comissaoDAO.buscaPorId(idComissao);
    }

    public void removerPorId(String id) {
        long idComissao = Long.parseLong(id);
        comissaoDAO.removerPorId(idComissao);
    }
}
