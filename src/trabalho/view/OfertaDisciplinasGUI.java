/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;

import java.util.Scanner;
import trabalho.Utils.Data;
import trabalho.Utils.Validacao;

import trabalho.model.OfertaDisciplinas;
import trabalho.controller.OfertaDisciplinasController;

/**
 *
 * @author vinic_oh1fkpu
 */
public class OfertaDisciplinasGUI {

    Scanner scan = new Scanner(System.in);

    OfertaDisciplinasController ofertadisciplinasController = new OfertaDisciplinasController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Oferta de Disciplinas\n");
        builder.append("\n1 - Criar uma Oferta de Disciplina");
        builder.append("\n2 - Editar uma Oferta de Disciplina");
        builder.append("\n3 - Deletar uma Oferta de Disciplina");
        builder.append("\n4 - Mostrar todas as  Ofertas de Disciplina");
        builder.append("\n5 - Alguma coisa");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public OfertaDisciplinas criaOfertaDisciplinas() {

        OfertaDisciplinas temp = new OfertaDisciplinas();

        DisciplinaGUI d = new DisciplinaGUI();
        temp.setDisciplina(d.selecionarDisciplina());

        ServidorGUI s = new ServidorGUI();
        temp.setProfessor(s.selecionarServidorProfessor());

        System.out.println("Informe o ano da oferta de disciplina");
        temp.setAno(scan.nextLine());

        System.out.println("Informe o semestre da oferta de disciplina");
        temp.setSemestre(scan.nextLine());

        
        temp.setHorasSemanais(temp.getDisciplina().getCargaHoraria() / 20);
        

        temp.setDataCriacao(Data.dataAtual());

        return temp;
    }

    public void editaOfertaDisciplinas(OfertaDisciplinas temp) {

        DisciplinaGUI d = new DisciplinaGUI();
        temp.setDisciplina(d.selecionarDisciplina());

        ServidorGUI s = new ServidorGUI();
        temp.setProfessor(s.selecionarServidorProfessor());

        System.out.println("Informe o ano da oferta de disciplina");
        temp.setAno(scan.nextLine());

        System.out.println("Informe o semestre da oferta de disciplina");
        temp.setSemestre(scan.nextLine());

        temp.setHorasSemanais(temp.getDisciplina().getCargaHoraria() / 20);

        temp.setDataModificacao(Data.dataAtual());

    }

    public void mostrarTodasOfertasDisciplinas() {
        OfertaDisciplinas[] ofertadisciplinas = ofertadisciplinasController.listar();
        boolean temOfertaDisciplinas = false;
        for (OfertaDisciplinas i : ofertadisciplinas) {
            if (i != null) {
                System.out.println(i);
                temOfertaDisciplinas = true;
            }
        }
        if (!temOfertaDisciplinas) {
            System.out.println("não existe oferta de disciplina cadastrado");
        }
    }

    public OfertaDisciplinas selecionarOfertaDisciplinas() {
        mostrarTodasOfertasDisciplinas();
        OfertaDisciplinas selectOfertaDisciplinas = (OfertaDisciplinas) Validacao.validarObjectScan(ofertadisciplinasController::buscaPorId, "Insira o id do OfertaDisciplinas:", "OfertaDisciplinas inválido.");
        return selectOfertaDisciplinas;
    }

    public void menuOfertaDisciplinas() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();
            long idOfertaDisciplinas;

            switch (opc) {

                case 1:
                    OfertaDisciplinas oD = criaOfertaDisciplinas();

                    boolean foiInserido = ofertadisciplinasController.adicionar(oD);
                    if (foiInserido) {
                        System.out.println("oferta de disciplina inserida com sucesso");
                    } else {
                        System.out.println("oferta de disciplina nao inserida");

                    }

                    break;
                case 2:
                    OfertaDisciplinas editOfertaDisciplinas = selecionarOfertaDisciplinas();

                    if (editOfertaDisciplinas != null) {
                        editaOfertaDisciplinas(editOfertaDisciplinas);
                        System.out.println("oferta de disciplina editada com sucesso");
                    } else {
                        System.out.println("oferta de disciplina nao encontrada, tente novamente");
                    }

                    break;

                case 3:
                    mostrarTodasOfertasDisciplinas();

                    System.out.println("Informe o id do oferta de disciplina que deseja excluir");
                    String id = scan.nextLine();

                    OfertaDisciplinas removeOfertaDisciplinas = ofertadisciplinasController.buscaPorId(id);

                    if (removeOfertaDisciplinas != null) {
                        ofertadisciplinasController.removerPorId(id);
                        System.out.println("oferta de disciplina removida com sucesso");
                    } else {
                        System.out.println("oferta de disciplina nao encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasOfertasDisciplinas();
                    break;

                case 5:
                    break;

                case 6:
                    break;

                default:
                    break;
            }

        } while (opc != 6);
    }
}
