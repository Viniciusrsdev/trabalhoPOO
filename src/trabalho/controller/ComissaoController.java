/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import java.util.Date;
import trabalho.model.Comissao;
import trabalho.DAO.ComissaoDAO;
import trabalho.Utils.Data;

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
    
 
    
    public boolean checarListaComissao() {
        Comissao[] comissao = this.listar();
        boolean temComissao = false;
        for (Comissao i : comissao) {
            if (i != null) {
                temComissao = true;
            }
        }
        return temComissao;
    }

    public Comissao buscaPorId(String id) {
        long idComissao = Long.parseLong(id);
        return comissaoDAO.buscaPorId(idComissao);
    }

    public void removerPorId(Long id) {
        comissaoDAO.removerPorId(id);
    }
    
    public boolean verificarEstado(String estado) {
        if (!"ATIVO".equals(estado.toUpperCase()) && !"INATIVO".equals(estado.toUpperCase())) {
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
