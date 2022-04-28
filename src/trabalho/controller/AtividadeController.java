/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.model.Atividade;
import trabalho.DAO.AtividadeDAO;
import trabalho.Utils.Data;
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

    public Atividade buscaPorId(String id) {
        long idAtividade = Long.parseLong(id);
        return atividadeDAO.buscaPorId(idAtividade);
    }

    public void removerPorId(String id) {
        long idAtividade = Long.parseLong(id);
        atividadeDAO.removerPorId(idAtividade);
    }
    
    public void criaPrepAula(OfertaDisciplinas ofertadisciplinas){
        Atividade temp = new Atividade();
        
        temp.setDescricao("Preparacao de aula: " + ofertadisciplinas.getDisciplina().getNome());
        
        temp.setHorasSemanais(ofertadisciplinas.getHorasSemanais());
        
        temp.setServidor(ofertadisciplinas.getProfessor());
        
        temp.setDataCriacao(Data.dataAtual());

        adicionar(temp);

    }
}
