/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

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

            Disciplina s1 = new Disciplina();
            s1.setNome("Programacao Orientada a Objetos");
            s1.setCargaHoraria(120);
            adiciona(s1);

            Disciplina s2 = new Disciplina();
            s2.setNome("Interfaces WEB");
            s2.setCargaHoraria(30);
            adiciona(s2);

            Disciplina s3 = new Disciplina();
            s3.setNome("Banco de Dados");
            s3.setCargaHoraria(90);
            adiciona(s3);

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
