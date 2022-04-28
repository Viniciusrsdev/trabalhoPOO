/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.Utils.Data;
import trabalho.model.Curso;
import trabalho.model.Campus;

/**
 *
 * @author vinic_oh1fkpu
 */
public class CursoDAO {

    private static Curso[] cursos = new Curso[5];
    private static boolean inicializado = false;

    public CursoDAO() {

        if (!inicializado) {
            Curso c1 = new Curso();
            c1.setNome("Engenharia de Computacao");
            c1.setEstado("ATIVO");
            c1.setInicio(Data.converterDataEmAno("2006"));

            adiciona(c1);

            Curso c2 = new Curso();
            c2.setNome("Analise e Desenvolvimento de Sistemas");
            c2.setEstado("ATIVO");
            c2.setInicio(Data.converterDataEmAno("2010"));

            adiciona(c2);

            Curso c3 = new Curso();
            c3.setNome("Tecnologia de Informacao");
            c3.setEstado("INATIVO");
            c3.setInicio(Data.converterDataEmAno("2000"));
            c3.setTermino(Data.converterDataEmAno("2010"));

            adiciona(c3);

            inicializado = true;
        }
    }

    public boolean adiciona(Curso c) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            cursos[proximaPosicaoLivre] = c;
            return true;
        } else {
            return false;
        }
    }

    public Curso[] listar() {
        return cursos;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] != null && cursos[i].getId() == id) {
                cursos[i] = null;
            }
        }
    }

//    public void removerCursosCampusDeletado(Campus c) {
//
//        for (int i = 0; i < cursos.length; i++) {;
//            if (cursos[i] != null && cursos[i].getCampus() == c) {
//                cursos[i] = null;
//            }
//        }
//
//    }

    public Curso buscaPorId(long id) {
        for (Curso i : cursos) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < cursos.length; i++) {
            if (cursos[i] == null) {

                return i;
            }
        }
        return -1;

    }

}
