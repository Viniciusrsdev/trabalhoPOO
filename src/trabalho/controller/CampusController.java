/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import java.util.Date;
import trabalho.DAO.CampusDAO;
import trabalho.Utils.Data;
import trabalho.model.Campus;

/**
 *
 * @author vinic_oh1fkpu
 */
public class CampusController {

    CampusDAO campusDAO = new CampusDAO();

    public boolean adicionar(Campus campus) {
        boolean retorno = campusDAO.adiciona(campus);
        return retorno;
    }

    public Campus[] listar() {
        return campusDAO.listar();
    }

    public boolean checarListaCampus() {
        Campus[] campus = this.listar();
        boolean temCampus = false;
        for (Campus i : campus) {
            if (i != null) {
                temCampus = true;
            }
        }
        return temCampus;
    }

    public Campus buscaPorId(String id) {
        long idCampus = Long.parseLong(id);
        return campusDAO.buscaPorId(idCampus);
    }

    public void removerPorId(long id) {
        campusDAO.removerPorId(id);
    }

    public Date verificarData(String s) {
        Date date = Data.converterData(s);
        return date;
    }

    public boolean verificarCep(String s) {
        if (s.length() == 8) {
            return true;
        }
        return false;
    }

}
