/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.controller.AtaReuniaoPresentesController;
import trabalho.controller.AtividadeController;
import trabalho.controller.OfertaDisciplinasController;
import trabalho.controller.OrientacaoController;
import trabalho.controller.ServidorComissoesController;
import trabalho.model.Servidor;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ServidorDAO {

    private static Servidor[] servidores = new Servidor[5];
    private static boolean inicializado = false;

    public ServidorDAO() {

        if (!inicializado) {
            CampusDAO campusDAO = new CampusDAO();
            Servidor s1 = new Servidor();
            s1.setNome("Eduardo");
            s1.setEmail("eduardo.iftm@edu.br");
            s1.setCargo("PROFESSOR");
            s1.setLogin("admin");
            s1.setSenha("admin");
            s1.setAdmnistrador(true);
            s1.setCampus(campusDAO.buscaPorId(1));
            this.adiciona(s1);

            Servidor s2 = new Servidor();
            s2.setNome("Camilo");
            s2.setEmail("camilo.lelis.iftm@edu.br");
            s2.setCargo("PROFESSOR");
            s2.setLogin("user1");
            s2.setSenha("pass1");
            s2.setAdmnistrador(false);
            s2.setCampus(campusDAO.buscaPorId(2));
            adiciona(s2);

            Servidor s3 = new Servidor();
            s3.setNome("Ernani");
            s3.setEmail("ernani.ernanim.iftm@edu.br");
            s3.setCargo("TECNICO");
            s3.setLogin("user2");
            s3.setSenha("pass2");
            s3.setAdmnistrador(false);
            s3.setCampus(campusDAO.buscaPorId(3));
            adiciona(s3);
            inicializado = true;
        }

    }

    public boolean adiciona(Servidor s) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            servidores[proximaPosicaoLivre] = s;
            return true;
        } else {
            return false;
        }

    }

    public Servidor[] listar() {
        return servidores;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < servidores.length; i++) {
            if (servidores[i] != null && servidores[i].getId() == id) {

                new ServidorComissoesController().removerServidorComissoesServidorDeletado(servidores[i]);
                new OrientacaoController().removerOrientacoesServidorDeletado(servidores[i]);
                new OfertaDisciplinasController().removerOfertaDisciplinasServidorDeletado(servidores[i]);
                new AtividadeController().removerAtividadesServidorDeletado(servidores[i]);
                new AtaReuniaoPresentesController().removerAtaReuniaoPresentesServidorDeletado(servidores[i]);
                servidores[i] = null;

            }
        }

    }

    public Servidor buscaPorId(long id) {
        for (Servidor i : servidores) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < servidores.length; i++) {
            if (servidores[i] == null) {
                return i;
            }

        }
        return -1;

    }

    public int autenticacao(String login, String senha) {
        for (Servidor i : servidores) {
            if (i != null && i.getLogin().equals(login) && i.getSenha().equals(senha)) {
                if (i.isAdmnistrador()) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        return -1;
    }
}
