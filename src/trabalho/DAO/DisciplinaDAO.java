/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.controller.OfertaDisciplinasController;
import trabalho.model.Disciplina;

/**
 *
 * @author vinic_oh1fkpu
 */
public class DisciplinaDAO {

    private static Disciplina[] disciplinas = new Disciplina[5];
    private static boolean inicializado = false;

    public DisciplinaDAO() {
        if (!inicializado) {

            CursoDAO cursoDAO = new CursoDAO();

            Disciplina d1 = new Disciplina();
            d1.setNome("Programacao Orientada a Objetos");
            d1.setCargaHoraria(240);
            d1.setPeriodicidade("ANUAL");
            d1.setCurso(cursoDAO.buscaPorId(1));
            adiciona(d1);

            Disciplina d2 = new Disciplina();
            d2.setNome("Interfaces WEB");
            d2.setCargaHoraria(30);
            d2.setPeriodicidade("SEMESTRAL");
            d2.setCurso(cursoDAO.buscaPorId(2));
            adiciona(d2);

            Disciplina d3 = new Disciplina();
            d3.setNome("Banco de Dados");
            d3.setCargaHoraria(90);
            d3.setPeriodicidade("SEMESTRAL");
            d3.setCurso(cursoDAO.buscaPorId(3));
            adiciona(d3);

            inicializado = true;
        }

    }

    public boolean adiciona(Disciplina d) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            disciplinas[proximaPosicaoLivre] = d;
            return true;
        } else {
            return false;
        }
    }

    public Disciplina[] listar() {
        return disciplinas;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i] != null && disciplinas[i].getId() == id) {

                new OfertaDisciplinasController().removerOfertaDisciplinasDisciplinaDeletado(disciplinas[i]);
                disciplinas[i] = null;
            }
        }
    }

    public Disciplina buscaPorId(long id) {
        for (Disciplina i : disciplinas) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < disciplinas.length; i++) {
            if (disciplinas[i] == null) {
                return i;
            }
        }
        return -1;
    }

}
