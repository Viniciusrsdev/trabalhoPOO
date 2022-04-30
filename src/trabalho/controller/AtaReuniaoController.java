/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import java.util.Date;
import trabalho.model.AtaReuniao;
import trabalho.DAO.AtaReuniaoDAO;
import trabalho.Utils.Data;
import trabalho.model.Comissao;
import trabalho.model.Servidor;

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

    public boolean checarListaComissao() {
        return new ComissaoController().checarListaComissao();
    }

    public boolean checarListaServidor() {
        return new ServidorController().checarListaServidor();
    }

    public boolean checarListaAtaReuniao() {
        AtaReuniao[] atareuniao = this.listar();
        boolean temAtaReuniao = false;
        for (AtaReuniao i : atareuniao) {
            if (i != null) {
                temAtaReuniao = true;
            }
        }
        return temAtaReuniao;
    }

    public AtaReuniao buscaPorId(String id) {
        long idAtaReuniao = Long.parseLong(id);
        return atareuniaoDAO.buscaPorId(idAtaReuniao);
    }

    public void removerPorId(long id) {

        atareuniaoDAO.removerPorId(id);
    }

    public void removerAtaReuniaoComissaoDeletado(Comissao c) {
        AtaReuniao[] atareuniao = this.listar();
        for (int i = 0; i < atareuniao.length; i++) {;
            if (atareuniao[i] != null && atareuniao[i].getComissao() == c) {
                Long aux = atareuniao[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public void removerAtaReuniaoServidorDeletado(Servidor s) {
        AtaReuniao[] atareuniao = this.listar();
        for (int i = 0; i < atareuniao.length; i++) {;
            if (atareuniao[i] != null && atareuniao[i].getSecretario() == s) {
                Long aux = atareuniao[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public Date verificarData(String s) {
        Date date = Data.converterData(s);
        return date;
    }
}
