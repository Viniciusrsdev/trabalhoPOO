/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.controller;

import trabalho.DAO.ServidorDAO;
import trabalho.model.Campus;
import trabalho.model.Servidor;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ServidorController {

    ServidorDAO servidorDAO = new ServidorDAO();

    public boolean adicionar(Servidor servidor) {
        boolean retorno = servidorDAO.adiciona(servidor);
        return retorno;
    }

    public Servidor[] listar() {
        return servidorDAO.listar();
    }

    public boolean checarListaCampus() {
        return new CampusController().checarListaCampus();
    }

    public boolean checarListaServidor() {
        Servidor[] servidor = this.listar();
        boolean temServidor = false;
        for (Servidor i : servidor) {
            if (i != null) {
                temServidor = true;
            }
        }
        return temServidor;
    }

    public Servidor buscaPorId(String id) {
        long idServidor = Long.parseLong(id);
        return servidorDAO.buscaPorId(idServidor);
    }

    public Servidor buscaPorIdProfessor(String id) {
        long idServidor = Long.parseLong(id);
        if (verificarProfessor(servidorDAO.buscaPorId(idServidor).getCargo())) {
            return servidorDAO.buscaPorId(idServidor);
        }
        return null;
    }

    public void removerPorId(long id) {
        servidorDAO.removerPorId(id);
    }

    public void removerServidoresCampusDeletado(Campus c) {
        Servidor[] servidores = this.listar();
        for (int i = 0; i < servidores.length; i++) {;
            if (servidores[i] != null && servidores[i].getCampus() == c) {
                Long aux = servidores[i].getId();
                this.removerPorId(aux);
            }
        }

    }

    public boolean verificarAdministrador(String c) {
        if (!"S".equals(c.toUpperCase()) && !"N".equals(c.toUpperCase())) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarCargo(String c) {
        if (!"PROFESSOR".equals(c.toUpperCase()) && !"TECNICO".equals(c.toUpperCase())) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarProfessor(String c) {
        if (!"PROFESSOR".equals(c.toUpperCase())) {
            return false;
        } else {
            return true;
        }
    }
}
