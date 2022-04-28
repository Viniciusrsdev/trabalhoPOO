/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;

import java.util.Scanner;
import trabalho.Utils.Data;
import trabalho.Utils.Validacao;

import trabalho.controller.ServidorComissoesController;

import trabalho.model.ServidorComissoes;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ServidorComissoesGUI {

    Scanner scan = new Scanner(System.in);

    ServidorComissoesController servidorcomissoesController = new ServidorComissoesController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu ServidorComissoes\n");
        builder.append("\n1 - Criar uma ServidorComissoes");
        builder.append("\n2 - Editar uma ServidorComissoes");
        builder.append("\n3 - Deletar uma ServidorComissoes");
        builder.append("\n4 - Mostrar todas as ServidorComissoes");
        builder.append("\n5 - Alguma coisa");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public ServidorComissoes criaServidorComissoes() {

        ServidorComissoes temp = new ServidorComissoes();

        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        System.out.println("Informe o papel do servidor");
        temp.setPapel(scan.nextLine());

        System.out.println("Data de inicio");
        temp.setInicio(scan.nextLine());

        System.out.println("Data de termino");
        temp.setTermino(scan.nextLine());

        temp.setDataCriacao(Data.dataAtual());

        return temp;

    }

    public void editaServidorComissoes(ServidorComissoes temp) {

        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        System.out.println("Informe o papel do servidor");
        temp.setPapel(scan.nextLine());

        System.out.println("Data de inicio");
        temp.setInicio(scan.nextLine());

        System.out.println("Data de termino");
        temp.setTermino(scan.nextLine());

        temp.setDataModificacao(Data.dataAtual());
    }

    public void mostrarTodosServidorComissoes() {
        ServidorComissoes[] servidorcomissoes = servidorcomissoesController.listar();
        boolean temServidorComissoes = false;
        for (ServidorComissoes i : servidorcomissoes) {
            if (i != null) {
                System.out.println(i);
                temServidorComissoes = true;
            }
        }
        if (!temServidorComissoes) {
            System.out.println("não existe nenhuma comissao de servidor cadastrada");
        }
    }

    public ServidorComissoes selecionarServidorComissoes() {
        mostrarTodosServidorComissoes();
        ServidorComissoes selectServidorComissoes = (ServidorComissoes) Validacao.validarObjectScan(servidorcomissoesController::buscaPorId, "Insira o id do ServidorComissoes:", "ServidorComissoes inválido.");
        return selectServidorComissoes;
    }

    public void menuServidorComissoes() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();
            long idServidorComissoes;

            switch (opc) {

                case 1:
                    ServidorComissoes sC = criaServidorComissoes();

                    boolean foiInserido = servidorcomissoesController.adicionar(sC);

                    if (foiInserido) {
                        System.out.println("ServidorComissoes inserida com sucesso");
                    } else {
                        System.out.println("ServidorComissoes nao inserida");
                    }

                    break;
                case 2:
                    ServidorComissoes editServidorComissoes = selecionarServidorComissoes();

                    if (editServidorComissoes != null) {
                        editaServidorComissoes(editServidorComissoes);
                        System.out.println("ServidorComissoes editado com sucesso");
                    } else {
                        System.out.println("ServidorComissoes nao encontrada, tente novamente");
                    }

                    break;

                case 3:
                    mostrarTodosServidorComissoes();

                    System.out.println("Informe o id da ServidorComissoes que deseja excluir");
                    String id = scan.nextLine();

                    ServidorComissoes removeServidorComissoes = servidorcomissoesController.buscaPorId(id);

                    if (removeServidorComissoes != null) {
                        servidorcomissoesController.removerPorId(id);
                        System.out.println("ServidorComissoes removida com sucesso");
                    } else {
                        System.out.println("ServidorComissoes nao encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodosServidorComissoes();
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
