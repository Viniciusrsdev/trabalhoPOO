/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import java.util.Date;
import trabalho.DAO.OrientacaoDAO;
import trabalho.Utils.Data;
import trabalho.model.Orientacao;
import trabalho.model.Servidor;

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

    public boolean checarListaServidor() {
        return new ServidorController().checarListaServidor();
    }

    public boolean checarListaOrientacao() {
        Orientacao[] orientacao = this.listar();
        boolean temOrientacao = false;
        for (Orientacao i : orientacao) {
            if (i != null) {
                temOrientacao = true;
            }
        }
        return temOrientacao;
    }

    public Orientacao buscaPorId(String id) {
        long idOrientacao = Long.parseLong(id);
        return orientacaoDAO.buscaPorId(idOrientacao);
    }

    public void removerPorId(long id) {

        orientacaoDAO.removerPorId(id);
    }

    public void removerOrientacoesServidorDeletado(Servidor s) {
        Orientacao[] orientacao = this.listar();
        for (int i = 0; i < orientacao.length; i++) {;
            if (orientacao[i] != null && orientacao[i].getServidor() == s) {
                Long aux = orientacao[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public boolean verificarTipo(String tipo) {
        if (!"ENSINO".equals(tipo.toUpperCase()) && !"PESQUISA".equals(tipo.toUpperCase()) && !"EXTENSAO".equals(tipo.toUpperCase()) && !"ESTAGIO".equals(tipo.toUpperCase()) && !"TCC".equals(tipo.toUpperCase()) && !"MESTRADO".equals(tipo.toUpperCase()) && !"DOUTORADO".equals(tipo.toUpperCase())) {
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
