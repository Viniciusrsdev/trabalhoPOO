/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this dlate file, choose Tools | Templates
 * and open the dlate in the editor.
 */
package trabalho.view;


import java.util.Scanner;
import trabalho.Utils.Data;
import trabalho.model.Disciplina;
import trabalho.controller.DisciplinaController;

import trabalho.Utils.Validacao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class DisciplinaGUI {

    Scanner scan = new Scanner(System.in);

    DisciplinaController disciplinaController = new DisciplinaController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Disciplina\n");
        builder.append("\n1 - Criar uma Disciplina");
        builder.append("\n2 - Editar uma Disciplina");
        builder.append("\n3 - Deletar uma Disciplina");
        builder.append("\n4 - Mostrar todas as Disciplinas");
        builder.append("\n5 - Mostrar a oferta de uma Disciplina");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Disciplina criaDisciplina() {

       Disciplina temp = new Disciplina();

        System.out.println("Informe o nome da disciplina");
        temp.setNome(scan.nextLine());

        System.out.println("Informe a carga horaria");
        temp.setCargaHoraria(Long.parseLong(scan.nextLine()));
        
       

        System.out.println("Informe a periodicidade(semestral/anual)");
        temp.setPeriodicidade(scan.nextLine());

        CursoGUI c = new CursoGUI();
        temp.setCurso(c.selecionarCurso());
        
         

        temp.setDataCriacao(Data.dataAtual());

        return temp;
    }

    public void editaDisciplina(Disciplina temp) {

        System.out.println("Informe o nome da disciplina");
        temp.setNome(scan.nextLine());

        System.out.println("Informe a carga horaria");
        temp.setCargaHoraria(Long.parseLong(scan.nextLine()));

        System.out.println("Informe a periodicidade(semestral/anual)");
        temp.setPeriodicidade(scan.nextLine());

        CursoGUI c = new CursoGUI();
        temp.setCurso(c.selecionarCurso());
        
      

        temp.setDataModificacao(Data.dataAtual());
    }

    public void mostrarTodasDisciplinas() {
        Disciplina[] disciplinas = disciplinaController.listar();
        boolean temDisciplina = false;
        for (Disciplina i : disciplinas) {
            if (i != null) {
                System.out.println(i);
                temDisciplina = true;
            }
        }
        if (!temDisciplina) {
            System.out.println("não existe nenhuma disciplina cadastrada");
        }
    }

    public Disciplina selecionarDisciplina() {
        mostrarTodasDisciplinas();
        Disciplina selectDisciplina = (Disciplina) Validacao.validarObjectScan(disciplinaController::buscaPorId, "Insira o id da Disciplina:", "Disciplina inválido.");
        return selectDisciplina;
    }

    public void menuDisciplina() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();
            long idDisciplina;

            switch (opc) {

                case 1:
                    Disciplina d = criaDisciplina();

                    boolean foiInserido = disciplinaController.adicionar(d);

                    if (foiInserido) {
                        System.out.println("disciplina inserido com sucesso");
                    } else {
                        System.out.println("disciplina nao inserido");
                    }

                    break;
                case 2:
                    Disciplina editDisciplina = selecionarDisciplina();
                    if (editDisciplina != null) {
                        editaDisciplina(editDisciplina);
                        System.out.println("Disciplina editado com sucesso");
                    } else {
                        System.out.println("Disciplina nao encontrada, tente novamente");
                    }

                    break;

                case 3:
                    mostrarTodasDisciplinas();

                    System.out.println("Informe o id da disciplina que deseja excluir");
                    String id = scan.nextLine();

                    Disciplina removeDisciplina = disciplinaController.buscaPorId(id);

                    if (removeDisciplina != null) {
                        disciplinaController.removerPorId(id);
                        System.out.println("Disciplina removida com sucesso");
                    } else {
                        System.out.println("Disciplina nao encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasDisciplinas();
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
