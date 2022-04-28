/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.Utils.Data;
import trabalho.controller.CursoController;
import trabalho.controller.ServidorController;
import trabalho.model.Campus;

/**
 *
 * @author vinic_oh1fkpu
 */
public class CampusDAO {

    private static Campus[] campi = new Campus[5];
    private static boolean inicializado = false;

    public CampusDAO() {
        if (!inicializado) {
            Campus c1 = new Campus();
            c1.setNome("Campus Uberaba Parque Tecnologico");
            c1.setAbreviacao("UPT");
            c1.setDuracaoAulas(50);
            c1.setDataCriacaoCampus(Data.converterData("02/02/1998"));
            c1.setCidade("Uberaba");
            c1.setBairro("Univerde Cidade");
            c1.setEndereco("Avenida florestan, 1800");
            c1.setCep("38055-159");

            this.adiciona(c1);

            Campus c2 = new Campus();
            c2.setNome("Campus IFTM Fazenda");
            c2.setAbreviacao("FAZ");
            c2.setDuracaoAulas(60);
            c2.setDataCriacaoCampus(Data.converterData("02/03/1999"));
            c2.setCidade("Uberaba");
            c2.setBairro("Univerde Cidade");
            c2.setEndereco("Avenida florestan, 1940");
            c2.setCep("38045-169");
            adiciona(c2);

            Campus c3 = new Campus();
            c3.setNome("Campus Iturama");
            c3.setAbreviacao("ITU");
            c3.setDuracaoAulas(50);
            c3.setDataCriacaoCampus(Data.converterData("22/12/2002"));
            c3.setCidade("Iturama");
            c3.setBairro("Sao Joao da Penha");
            c3.setEndereco("Rua Maranhao, 14");
            c3.setCep("38022-963");
            adiciona(c3);

            inicializado = true;
        }

    }

    public boolean adiciona(Campus c) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            campi[proximaPosicaoLivre] = c;
            return true;
        } else {
            return false;
        }
    }

    public Campus[] listar() {
        return campi;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < campi.length; i++) {
            if (campi[i] != null && campi[i].getId() == id) {

                new CursoController().removerCursosCampusDeletado(campi[i]);
                new ServidorController().removerServidoresCampusDeletado(campi[i]);

                campi[i] = null;

            }
        }

    }

    public Campus buscaPorId(long id) {
        for (Campus i : campi) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < campi.length; i++) {
            if (campi[i] == null) {
                return i;
            }

        }
        return -1;

    }
}
