/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.DAO;

import trabalho.Utils.Data;
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
            ServidorDAO servidorDAO = new ServidorDAO();
            DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
            
            OfertaDisciplinas oD1 = new OfertaDisciplinas();
            oD1.setDisciplina(disciplinaDAO.buscaPorId(1));
            oD1.setProfessor(servidorDAO.buscaPorId(1));
            oD1.setAno(Data.converterDataEmAno("2022"));
            oD1.setSemestre("1");
            oD1.setHorasSemanais(6);
            oD1.setAulasSemanais(8);

            adiciona(oD1);
            
            OfertaDisciplinas oD2 = new OfertaDisciplinas();
            oD2.setDisciplina(disciplinaDAO.buscaPorId(2));
            oD2.setProfessor(servidorDAO.buscaPorId(1));
            oD2.setAno(Data.converterDataEmAno("2022"));
            oD2.setSemestre("2");
            oD2.setHorasSemanais(2);
            oD2.setAulasSemanais(2);

            adiciona(oD2);
            
            OfertaDisciplinas oD3 = new OfertaDisciplinas();
            oD3.setDisciplina(disciplinaDAO.buscaPorId(3));
            oD3.setProfessor(servidorDAO.buscaPorId(2));
            oD3.setAno(Data.converterDataEmAno("2022"));
            oD3.setSemestre("1");
            oD3.setHorasSemanais(5);
            oD3.setAulasSemanais(6);

            adiciona(oD3);
            
                        
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
