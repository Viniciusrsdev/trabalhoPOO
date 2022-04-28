/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.DAO.OrientacaoDAO;
import trabalho.model.Orientacao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class OrientacaoController {

    OrientacaoDAO orientacaoDAO = new OrientacaoDAO();

    public boolean adicionar(Orientacao orientacao) {
        boolean retorno = orientacaoDAO.adiciona(orientacao);
        return retorno;
    }

    public Orientacao[] listar() {
        return orientacaoDAO.listar();
    }

    public Orientacao buscaPorId(String id) {
        long idOrientacao = Long.parseLong(id);
        return orientacaoDAO.buscaPorId(idOrientacao);
    }

    public void removerPorId(String id) {
        long idOrientacao = Long.parseLong(id);
        orientacaoDAO.removerPorId(idOrientacao);
    }

}
