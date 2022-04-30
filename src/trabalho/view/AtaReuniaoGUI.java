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
        builder.append("\n5 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public AtaReuniao criaAtaReuniao() {

        AtaReuniao temp = new AtaReuniao();
        Date data;

        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        data = Validacao.validarDateScan(atareuniaoController::verificarData, "Informe a data da reuniao (dd/MM/yyyy):", "Data inválida");
        temp.setData(data);

        System.out.println("Informe o conteudo");
        temp.setConteudo(scan.nextLine());

        ServidorGUI s = new ServidorGUI();
        temp.setSecretario(s.selecionarServidor());

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;

    }

    public void editaAtaReuniao(AtaReuniao temp) {

        Date data;

        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        data = Validacao.validarDateScan(atareuniaoController::verificarData, "Informe a data da reuniao (dd/MM/yyyy):", "Data inválida");
        temp.setData(data);

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

            switch (opc) {

                case 1:
                    if (atareuniaoController.checarListaComissao() && atareuniaoController.checarListaServidor()) {
                        AtaReuniao aR = criaAtaReuniao();

                        boolean foiInserido = atareuniaoController.adicionar(aR);

                        if (foiInserido) {
                            System.out.println("AtaReuniao inserida com sucesso");
                        } else {
                            System.out.println("AtaReuniao nao inserida");
                        }
                    } else {
                        System.out.println("AtaReuniao nao inserido, nenhum Campus registrado");
                    }

                    break;
                case 2:
                    if (atareuniaoController.checarListaAtaReuniao()) {
                        AtaReuniao editAtaReuniao = selecionarAtaReuniao();
                        editaAtaReuniao(editAtaReuniao);
                        System.out.println("AtaReuniao editado com sucesso");
                    } else {
                        System.out.println("Nao existe nenhum AtaReuniao registrado");
                    }
                    break;

                case 3:
                    if (atareuniaoController.checarListaAtaReuniao()) {

                        AtaReuniao removeAtaReuniao = selecionarAtaReuniao();
                        atareuniaoController.removerPorId(removeAtaReuniao.getId());
                        System.out.println("AtaReuniao removido com sucesso");
                    } else {
                        System.out.println("Nenhum AtaReuniao encontrado, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasAtaReunioes();
                    break;

                case 5:

                    break;

                default:
                    break;
            }

        } while (opc != 5);
    }
}
