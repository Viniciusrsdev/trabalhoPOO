/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.model.AtaReuniao;
import trabalho.DAO.AtaReuniaoDAO;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtaReuniaoController {

    AtaReuniaoDAO atareuniaoDAO = new AtaReuniaoDAO();

    public boolean adicionar(AtaReuniao atareuniao) {
        boolean retorno = atareuniaoDAO.adiciona(atareuniao);
        return retorno;
    }

    public AtaReuniao[] listar() {
        return atareuniaoDAO.listar();
    }

    public AtaReuniao buscaPorId(String id) {
        long idAtaReuniao = Long.parseLong(id);
        return atareuniaoDAO.buscaPorId(idAtaReuniao);
    }

    public void removerPorId(String id) {
        long idAtaReuniao = Long.parseLong(id);
        atareuniaoDAO.removerPorId(idAtaReuniao);
    }
}
