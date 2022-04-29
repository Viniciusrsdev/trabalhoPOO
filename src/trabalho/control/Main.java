/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.control;

import trabalho.DAO.AtaReuniaoDAO;
import trabalho.DAO.AtaReuniaoPresentesDAO;
import trabalho.DAO.AtividadeDAO;
import trabalho.DAO.CampusDAO;
import trabalho.DAO.ComissaoDAO;
import trabalho.DAO.CursoDAO;
import trabalho.DAO.DisciplinaDAO;
import trabalho.DAO.OfertaDisciplinasDAO;
import trabalho.DAO.OrientacaoDAO;
import trabalho.DAO.ServidorComissoesDAO;
import trabalho.DAO.ServidorDAO;
import trabalho.view.MainGUI;

/**
 *
 * @author vinic_oh1fkpu
 */
public class Main {

    public Main() {
        CampusDAO campusDAO = new CampusDAO();
        CursoDAO cursoDAO = new CursoDAO();
        ServidorDAO servidorDAO = new ServidorDAO();
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
        OfertaDisciplinasDAO ofertaDisciplinasDAO = new OfertaDisciplinasDAO();
        ComissaoDAO comissaoDAO = new ComissaoDAO();
        ServidorComissoesDAO servidorComissoesDAO = new ServidorComissoesDAO();
        AtaReuniaoDAO ataReuniaoDAO = new AtaReuniaoDAO();
        AtaReuniaoPresentesDAO ataReuniaoPresentesDAO = new AtaReuniaoPresentesDAO();
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        OrientacaoDAO orientacaoDAO = new OrientacaoDAO();
        MainGUI mainGUI = new MainGUI();

    }

    public static void main(String[] args) {

        new Main();

    }
}
