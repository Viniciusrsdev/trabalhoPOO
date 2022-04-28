/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;


import java.util.Scanner;
import trabalho.Utils.Data;
import trabalho.Utils.Validacao;
import trabalho.controller.AtividadeController;

import trabalho.model.Atividade;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtividadeGUI {

    Scanner scan = new Scanner(System.in);

    AtividadeController atividadeController = new AtividadeController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Atividade\n");
        builder.append("\n1 - Criar uma Atividade");
        builder.append("\n2 - Editar uma Atividade");
        builder.append("\n3 - Deletar uma Atividade");
        builder.append("\n4 - Mostrar todas as Atividades");
        builder.append("\n5 - Alguma coisa");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Atividade criaAtividade() {

        Atividade temp = new Atividade();

        System.out.println("Informe a descricao da atividade");
        temp.setDescricao(scan.nextLine());

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Long.parseLong(scan.nextLine()));

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        System.out.println("Data de inicio");
        temp.setInicio(scan.nextLine());

        System.out.println("Data de termino");
        temp.setTermino(scan.nextLine());

        temp.setDataCriacao(Data.dataAtual());

        return temp;

    }

    public void editaAtividade(Atividade temp) {

        System.out.println("Informe a descricao da atividade");
        temp.setDescricao(scan.nextLine());

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Long.parseLong(scan.nextLine()));

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        System.out.println("Data de inicio");
        temp.setInicio(scan.nextLine());

        System.out.println("Data de termino");
        temp.setTermino(scan.nextLine());

        temp.setDataModificacao(Data.dataAtual());
    }

    public void mostrarTodasAtividades() {
        Atividade[] atividades = atividadeController.listar();
        boolean temAtividade = false;
        for (Atividade i : atividades) {
            if (i != null) {
                System.out.println(i);
                temAtividade = true;
            }
        }
        if (!temAtividade) {
            System.out.println("não existe nenhuma atividade cadastrada");
        }
    }

    public Atividade selecionarAtividade() {
        mostrarTodasAtividades();
        Atividade selectAtividade = (Atividade) Validacao.validarObjectScan(atividadeController::buscaPorId, "Insira o id da Atividade:", "Atividade inválida.");
        return selectAtividade;
    }

    public void menuAtividade() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();
            long idAtividade;

            switch (opc) {

                case 1:
                    Atividade a = criaAtividade();

                    boolean foiInserido = atividadeController.adicionar(a);

                    if (foiInserido) {
                        System.out.println("Atividade inserida com sucesso");
                    } else {
                        System.out.println("Atividade nao inserida");
                    }

                    break;
                case 2:
                    Atividade editAtividade = selecionarAtividade();

                    if (editAtividade != null) {
                        editaAtividade(editAtividade);
                        System.out.println("Atividade editado com sucesso");
                    } else {
                        System.out.println("Atividade nao encontrada, tente novamente");
                    }

                    break;

                case 3:
                    mostrarTodasAtividades();

                    System.out.println("Informe o id da Atividade que deseja excluir");
                    String id = scan.nextLine();

                    Atividade removeAtividade = atividadeController.buscaPorId(id);

                    if (removeAtividade != null) {
                        atividadeController.removerPorId(id);
                        System.out.println("Atividade removida com sucesso");
                    } else {
                        System.out.println("Atividade nao encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasAtividades();
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
