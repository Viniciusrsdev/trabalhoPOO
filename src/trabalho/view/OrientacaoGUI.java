/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;


import java.util.Scanner;
import trabalho.Utils.Data;
import trabalho.Utils.Validacao;
import trabalho.controller.OrientacaoController;

import trabalho.model.Orientacao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class OrientacaoGUI {

    Scanner scan = new Scanner(System.in);

    OrientacaoController orientacaoController = new OrientacaoController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Orientacao\n");
        builder.append("\n1 - Criar uma Orientacao");
        builder.append("\n2 - Editar uma Orientacao");
        builder.append("\n3 - Deletar uma Orientacao");
        builder.append("\n4 - Mostrar todas as Orientacoes");
        builder.append("\n5 - Alguma coisa");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Orientacao criaOrientacao() {

        Orientacao temp = new Orientacao();

        System.out.println("Informe o tipo da orientacao");
        temp.setTipo(scan.nextLine());

        System.out.println("Informe o nome do aluno");
        temp.setNomeAluno(scan.nextLine());

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

    public void editaOrientacao(Orientacao temp) {

        System.out.println("Informe o tipo da orientacao");
        temp.setTipo(scan.nextLine());

        System.out.println("Informe o nome do aluno");
        temp.setNomeAluno(scan.nextLine());

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

    public void mostrarTodasOrientacoes() {
        Orientacao[] orientacoes = orientacaoController.listar();
        boolean temOrientacao = false;
        for (Orientacao i : orientacoes) {
            if (i != null) {
                System.out.println(i);
                temOrientacao = true;
            }
        }
        if (!temOrientacao) {
            System.out.println("não existe nenhuma orientacao cadastrada");
        }
    }

    public Orientacao selecionarOrientacao() {
        mostrarTodasOrientacoes();
        Orientacao selectOrientacao = (Orientacao) Validacao.validarObjectScan(orientacaoController::buscaPorId, "Insira o id do Orientacao:", "Curso Orientacao.");
        return selectOrientacao;
    }

    public void menuOrientacao() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();
            long idOrientacao;

            switch (opc) {

                case 1:
                    Orientacao o = criaOrientacao();

                    boolean foiInserido = orientacaoController.adicionar(o);

                    if (foiInserido) {
                        System.out.println("orientacao inserida com sucesso");
                    } else {
                        System.out.println("Orientacao nao inserida");
                    }

                    break;
                case 2:
                    Orientacao editOrientacao = selecionarOrientacao();

                    if (editOrientacao != null) {
                        editaOrientacao(editOrientacao);
                        System.out.println("Orientacao editada com sucesso");
                    } else {
                        System.out.println("Orientacao nao encontrada, tente novamente");
                    }

                    break;

                case 3:
                    mostrarTodasOrientacoes();

                    System.out.println("Informe o id da Orientacao que deseja excluir");
                    String id = scan.nextLine();

                    Orientacao removeOrientacao = orientacaoController.buscaPorId(id);

                    if (removeOrientacao != null) {
                        orientacaoController.removerPorId(id);
                        System.out.println("Orientacao removida com sucesso");
                    } else {
                        System.out.println("Orientacao nao encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasOrientacoes();
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
