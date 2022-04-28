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

    public Servidor buscaPorId(String id) {
        long idServidor = Long.parseLong(id);
        return servidorDAO.buscaPorId(idServidor);
    }

    public void removerPorId(String id) {
        long idServidor = Long.parseLong(id);
        servidorDAO.removerPorId(idServidor);
    }

    public void removerServidoresCampusDeletado(Campus c) {
        Servidor[] servidores = this.listar();
        for (int i = 0; i < servidores.length; i++) {;
            if (servidores[i] != null && servidores[i].getCampus() == c) {
                String aux = String.valueOf(servidores[i].getId());
                this.removerPorId(aux);
            }
        }

    }
    
    public boolean checarListaCampus(){
        return new CampusController().checarListaCampus();
    }
    
    public boolean verificarAdministrador (String c){
        if (!"S".equals(c.toUpperCase()) && !"N".equals(c.toUpperCase())) {
            return false;
        } else {
            return true;
        }
    }

    public boolean verificarCargo (String c){
        if (!"PROFESSOR".equals(c.toUpperCase()) && !"TECNICO".equals(c.toUpperCase())) {
            return false;
        } else {
            return true;
        }
    }
}
