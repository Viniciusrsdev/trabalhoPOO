/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import java.util.Date;
import trabalho.model.Atividade;
import trabalho.DAO.AtividadeDAO;
import trabalho.Utils.Data;
import trabalho.model.Servidor;
import trabalho.model.OfertaDisciplinas;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtividadeController {

    AtividadeDAO atividadeDAO = new AtividadeDAO();

    public boolean adicionar(Atividade atividade) {
        boolean retorno = atividadeDAO.adiciona(atividade);
        return retorno;
    }

    public Atividade[] listar() {
        return atividadeDAO.listar();
    }

    public boolean checarListaServidor() {
        return new ServidorController().checarListaServidor();
    }

    public boolean checarListaAtividade() {
        Atividade[] atividade = this.listar();
        boolean temAtividade = false;
        for (Atividade i : atividade) {
            if (i != null) {
                temAtividade = true;
            }
        }
        return temAtividade;
    }

    public Atividade buscaPorId(String id) {
        long idAtividade = Long.parseLong(id);
        return atividadeDAO.buscaPorId(idAtividade);
    }

    public void removerPorId(long id) {

        atividadeDAO.removerPorId(id);
    }

    public void removerAtividadesServidorDeletado(Servidor s) {
        Atividade[] atividades = this.listar();
        for (int i = 0; i < atividades.length; i++) {;
            if (atividades[i] != null && atividades[i].getServidor() == s) {
                Long aux = atividades[i].getId();
                this.removerPorId(aux);
            }
        }
    }

    public void criaPrepAula(OfertaDisciplinas ofertadisciplinas) {
        Atividade temp = new Atividade();

        temp.setDescricao("Preparacao de aula: " + ofertadisciplinas.getDisciplina().getNome());

        temp.setHorasSemanais(ofertadisciplinas.getHorasSemanais());

        temp.setServidor(ofertadisciplinas.getProfessor());

        temp.setDataCriacao(Data.dataAtual());

        adicionar(temp);
    }

    public Date verificarData(String s) {
        Date date = Data.converterData(s);
        return date;
    }
}
