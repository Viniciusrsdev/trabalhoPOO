/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.model.OfertaDisciplinas;

/**
 *
 * @author vinic_oh1fkpu
 */
public class OfertaDisciplinasDAO {

    private static OfertaDisciplinas[] ofertasDisciplinas = new OfertaDisciplinas[5];
    private static boolean inicializado = false;

    public OfertaDisciplinasDAO() {
        if (!inicializado) {
            inicializado = true;
        }
    }

    public boolean adiciona(OfertaDisciplinas oD) {
        int proximaPosicaoLivre = this.proximaPosicaoLivre();
        if (proximaPosicaoLivre != -1) {
            ofertasDisciplinas[proximaPosicaoLivre] = oD;
            return true;
        } else {
            return false;
        }

    }

    public OfertaDisciplinas[] listar() {
        return ofertasDisciplinas;
    }

    public void removerPorId(long id) {
        for (int i = 0; i < ofertasDisciplinas.length; i++) {
            if (ofertasDisciplinas[i] != null && ofertasDisciplinas[i].getId() == id) {
                ofertasDisciplinas[i] = null;

            }
        }

    }

    public OfertaDisciplinas buscaPorId(long id) {
        for (OfertaDisciplinas i : ofertasDisciplinas) {
            if (i != null && i.getId() == id) {
                return i;
            }
        }
        return null;

    }

    private int proximaPosicaoLivre() {
        for (int i = 0; i < ofertasDisciplinas.length; i++) {
            if (ofertasDisciplinas[i] == null) {
                return i;
            }

        }
        return -1;

    }

    //funcao nao utilizada
   // public void mostraOfertasDisciplina(Long id) {
    //    boolean tem = false;

     //   for (OfertaDisciplinas i : ofertasDisciplinas) {
      //      if (i != null && i.getDisciplina().getId() == id) {
       //         System.out.println(i);
       //         tem = true;
       //     }
      //  }
      //  if (!tem) {
      //      System.out.println("não existe oferta de disciplina cadastrado");
     //   }
 //   }

}
