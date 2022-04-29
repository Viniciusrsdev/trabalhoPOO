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
        temp.setCargaHoraria(Double.parseDouble(scan.nextLine()));

        String periodicidade = Validacao.validarStringScan(disciplinaController::verificarPeriodicidade, "Informe a periodicidade(semestral/anual)", "Periodicidadeo inválida.");
        temp.setPeriodicidade(periodicidade.toUpperCase());

        CursoGUI c = new CursoGUI();
        temp.setCurso(c.selecionarCurso());

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;
    }

    public void editaDisciplina(Disciplina temp) {

        System.out.println("Informe o nome da disciplina");
        temp.setNome(scan.nextLine());

        System.out.println("Informe a carga horaria");
        temp.setCargaHoraria(Double.parseDouble(scan.nextLine()));

        String periodicidade = Validacao.validarStringScan(disciplinaController::verificarPeriodicidade, "Informe a periodicidade(semestral/anual)", "Periodicidadeo inválida.");
        temp.setPeriodicidade(periodicidade.toUpperCase());

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

            switch (opc) {

                case 1:
                    if (disciplinaController.checarListaCurso()) {
                        Disciplina d = criaDisciplina();

                        boolean foiInserido = disciplinaController.adicionar(d);

                        if (foiInserido) {
                            System.out.println("disciplina inserido com sucesso");
                        } else {
                            System.out.println("disciplina nao inserido");
                        }
                    } else {
                        System.out.println("Disciplina nao inserida, nenhum curso registrado");
                    }

                    break;
                case 2:
                    if (disciplinaController.checarListaDisciplina()) {
                        Disciplina editDisciplina = selecionarDisciplina();

                        editaDisciplina(editDisciplina);
                        System.out.println("Disciplina editada com sucesso");
                    } else {
                        System.out.println("Nao existe nenhuma disciplina registrada");
                    }

                    break;

                case 3:
                    if (disciplinaController.checarListaDisciplina()) {

                        Disciplina removeDisciplina = selecionarDisciplina();
                        disciplinaController.removerPorId(removeDisciplina.getId());

                        System.out.println("Disciplina removida com sucesso");

                    } else {
                        System.out.println("Nenhuma disciplina encontrada, tente novamente");
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
