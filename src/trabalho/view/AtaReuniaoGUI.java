/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;


import java.util.Date;
import java.util.Scanner;
import trabalho.controller.AtaReuniaoController;

import trabalho.model.AtaReuniao;
import trabalho.Utils.Data;
import trabalho.Utils.Validacao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtaReuniaoGUI {

    Scanner scan = new Scanner(System.in);

    AtaReuniaoController atareuniaoController = new AtaReuniaoController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu AtaReuniao\n");
        builder.append("\n1 - Criar uma AtaReuniao");
        builder.append("\n2 - Editar uma AtaReuniao");
        builder.append("\n3 - Deletar uma AtaReuniao");
        builder.append("\n4 - Mostrar todas as AtaReuniao");
        builder.append("\n5 - Alguma coisa");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public AtaReuniao criaAtaReuniao() {

        AtaReuniao temp = new AtaReuniao();
        Date data;

        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        System.out.println("Informe a data");
        temp.setData(scan.nextLine());

        System.out.println("Informe o conteudo");
        temp.setConteudo(scan.nextLine());

        ServidorGUI s = new ServidorGUI();
        temp.setSecretario(s.selecionarServidor());

        temp.setDataCriacao(Data.dataAtual());

        return temp;

    }

    public void editaAtaReuniao(AtaReuniao temp) {

        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        System.out.println("Informe a data");
        temp.setData(scan.nextLine());

        System.out.println("Informe o conteudo");
        temp.setConteudo(scan.nextLine());

        ServidorGUI s = new ServidorGUI();
        temp.setSecretario(s.selecionarServidor());

        temp.setDataModificacao(Data.dataAtual());

    }

    public void mostrarTodasAtaReunioes() {
        AtaReuniao[] atareunioes = atareuniaoController.listar();
        boolean temAtaReuniao = false;
        for (AtaReuniao i : atareunioes) {
            if (i != null) {
                System.out.println(i);
                temAtaReuniao = true;
            }
        }
        if (!temAtaReuniao) {
            System.out.println("não existe nenhuma AtaReuniao cadastrada");
        }
    }

    public AtaReuniao selecionarAtaReuniao() {
        mostrarTodasAtaReunioes();
        AtaReuniao selectAtaReuniao = (AtaReuniao) Validacao.validarObjectScan(atareuniaoController::buscaPorId, "Insira o id da AtaReuniao:", "AtaReuniao inválida.");
        return selectAtaReuniao;
    }

    public void menuAtaReuniao() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();
            long idAtaReuniao;

            switch (opc) {

                case 1:
                    AtaReuniao aR = criaAtaReuniao();

                    boolean foiInserido = atareuniaoController.adicionar(aR);

                    if (foiInserido) {
                        System.out.println("AtaReuniao inserida com sucesso");
                    } else {
                        System.out.println("AtaReuniao nao inserida");
                    }

                    break;
                case 2:
                    AtaReuniao editAtaReuniao = selecionarAtaReuniao();

                    if (editAtaReuniao != null) {
                        editaAtaReuniao(editAtaReuniao);
                        System.out.println("AtaReuniao editada com sucesso");
                    } else {
                        System.out.println("AtaReuniao nao encontrada, tente novamente");
                    }

                    break;

                case 3:
                    mostrarTodasAtaReunioes();

                    System.out.println("Informe o id da AtaReuniao que deseja excluir");
                    String id = scan.nextLine();

                    AtaReuniao removeAtaReuniao = atareuniaoController.buscaPorId(id);

                    if (removeAtaReuniao != null) {
                        atareuniaoController.removerPorId(id);
                        System.out.println("AtaReuniao removida com sucesso");
                    } else {
                        System.out.println("AtaReuniao nao encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasAtaReunioes();
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
