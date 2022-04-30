/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;

import java.util.Date;
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
        builder.append("\n5 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Orientacao criaOrientacao() {

        Orientacao temp = new Orientacao();

        Date data;

        String tipo = Validacao.validarStringScan(orientacaoController::verificarTipo, "Informe o tipo da orientacao (ensino, pesquisa, extensao, estagio, tcc, mestrado, doutorado)", "Tipo da orientacao inválido.");
        temp.setTipo(tipo.toUpperCase());

        System.out.println("Informe o nome do aluno");
        temp.setNomeAluno(scan.nextLine());

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Double.parseDouble(scan.nextLine()));

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        data = Validacao.validarDateScan(orientacaoController::verificarData, "Informe a data de inicio da orientacao (dd/MM/yyyy):", "Data inválida");
        temp.setInicio(data);

        data = Validacao.validarDateScan(orientacaoController::verificarData, "Informe a data de termino ou previsao de termino da orientacao(dd/MM/yyyy):", "Data inválida");
        temp.setTermino(data);

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;
    }

    public void editaOrientacao(Orientacao temp) {

        Date data;

        String tipo = Validacao.validarStringScan(orientacaoController::verificarTipo, "Informe o tipo da orientacao (ensino, pesquisa, extensao, estagio, tcc, mestrado, doutorado)", "Tipo da orientacao inválido.");
        temp.setTipo(tipo.toUpperCase());

        System.out.println("Informe o nome do aluno");
        temp.setNomeAluno(scan.nextLine());

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Double.parseDouble(scan.nextLine()));

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        data = Validacao.validarDateScan(orientacaoController::verificarData, "Informe a data de inicio da orientacao (dd/MM/yyyy):", "Data inválida");
        temp.setInicio(data);

        data = Validacao.validarDateScan(orientacaoController::verificarData, "Informe a data de termino ou previsao de termino da orientacao(dd/MM/yyyy):", "Data inválida");
        temp.setTermino(data);

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

            switch (opc) {

                case 1:
                    if (orientacaoController.checarListaServidor()) {
                        Orientacao o = criaOrientacao();

                        boolean foiInserido = orientacaoController.adicionar(o);

                        if (foiInserido) {
                            System.out.println("orientacao inserida com sucesso");
                        } else {
                            System.out.println("Orientacao nao inserida");
                        }
                    } else {
                        System.out.println("Curso nao inserido, nenhum Campus registrado");
                    }

                    break;
                case 2:

                    if (orientacaoController.checarListaOrientacao()) {
                        Orientacao editOrientacao = selecionarOrientacao();
                        editaOrientacao(editOrientacao);
                        System.out.println("Orientacao editada com sucesso");
                    } else {
                        System.out.println("Nao existe nenhuma Orientacao registrada");
                    }

                    break;

                case 3:

                    if (orientacaoController.checarListaOrientacao()) {

                        Orientacao removeOrientacao = selecionarOrientacao();
                        orientacaoController.removerPorId(removeOrientacao.getId());
                        System.out.println("Orientacao removida com sucesso");
                    } else {
                        System.out.println("Nenhuma Orientacao encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasOrientacoes();
                    break;

                case 5:

                    break;

                default:
                    break;
            }

        } while (opc != 5);
    }
}
