/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;


import java.util.Scanner;

import trabalho.controller.AtaReuniaoPresentesController;

import trabalho.model.AtaReuniaoPresentes;
import trabalho.Utils.Data;
import trabalho.Utils.Validacao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class AtaReuniaoPresentesGUI {

    Scanner scan = new Scanner(System.in);

    AtaReuniaoPresentesController atareuniaopresentesController = new AtaReuniaoPresentesController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu AtaReuniaoPresentes\n");
        builder.append("\n1 - Criar uma AtaReuniaoPresentes");
        builder.append("\n2 - Editar uma AtaReuniaoPresentes");
        builder.append("\n3 - Deletar uma AtaReuniaoPresentes");
        builder.append("\n4 - Mostrar todas as AtaReuniaoPresentes");
        builder.append("\n5 - Alguma coisa");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public AtaReuniaoPresentes criaAtaReuniaoPresentes() {

        AtaReuniaoPresentes temp = new AtaReuniaoPresentes();

        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        AtaReuniaoGUI aR = new AtaReuniaoGUI();
        temp.setAta(aR.selecionarAtaReuniao());

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        temp.setDataCriacao(Data.dataAtual());
        return temp;

    }

    public void editaAtaReuniaoPresentes(AtaReuniaoPresentes temp) {
        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        AtaReuniaoGUI aR = new AtaReuniaoGUI();
        temp.setAta(aR.selecionarAtaReuniao());

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        temp.setDataModificacao(Data.dataAtual());

    }

    public void mostrarTodasAtaReuniaoPresentes() {
        AtaReuniaoPresentes[] atasreuniaopresentes = atareuniaopresentesController.listar();
        boolean temAtaReuniaoPresentes = false;
        for (AtaReuniaoPresentes i : atasreuniaopresentes) {
            if (i != null) {
                System.out.println(i);
                temAtaReuniaoPresentes = true;
            }
        }
        if (!temAtaReuniaoPresentes) {
            System.out.println("não existe nenhuma AtaReuniaoPresentes cadastrada");
        }
    }

    public AtaReuniaoPresentes selecionarAtaReuniaoPresentes() {
        mostrarTodasAtaReuniaoPresentes();
        AtaReuniaoPresentes selectAtaReuniaoPresentes = (AtaReuniaoPresentes) Validacao.validarObjectScan(atareuniaopresentesController::buscaPorId, "Insira o id da AtaReuniaoPresentes:", "AtaReuniaoPresentes inválido.");
        return selectAtaReuniaoPresentes;
    }

    public void menuAtaReuniaoPresentes() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();
            long idAtaReuniaoPresentes;

            switch (opc) {

                case 1:
                    AtaReuniaoPresentes aRP = criaAtaReuniaoPresentes();

                    boolean foiInserido = atareuniaopresentesController.adicionar(aRP);

                    if (foiInserido) {
                        System.out.println("AtaReuniaoPresentes inserida com sucesso");
                    } else {
                        System.out.println("AtaReuniaoPresentes nao inserida");
                    }

                    break;
                case 2:
                    AtaReuniaoPresentes editAtaReuniaoPresentes = selecionarAtaReuniaoPresentes();

                    if (editAtaReuniaoPresentes != null) {
                        editaAtaReuniaoPresentes(editAtaReuniaoPresentes);
                        System.out.println("AtaReuniaoPresentes editado com sucesso");
                    } else {
                        System.out.println("AtaReuniaoPresentes nao encontrada, tente novamente");
                    }

                    break;

                case 3:
                    mostrarTodasAtaReuniaoPresentes();

                    System.out.println("Informe o id da AtaReuniaoPresentes que deseja excluir");
                    String id = scan.nextLine();

                    AtaReuniaoPresentes removeAtaReuniaoPresentes = atareuniaopresentesController.buscaPorId(id);

                    if (removeAtaReuniaoPresentes != null) {
                        atareuniaopresentesController.removerPorId(id);
                        System.out.println("AtaReuniaoPresentes removida com sucesso");
                    } else {
                        System.out.println("AtaReuniaoPresentes nao encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasAtaReuniaoPresentes();
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
