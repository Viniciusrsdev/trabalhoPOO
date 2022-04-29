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
        builder.append("\n5 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public ServidorComissoes criaServidorComissoes() {

        ServidorComissoes temp = new ServidorComissoes();
        Date data;

        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        String papel = Validacao.validarStringScan(servidorcomissoesController::verificarPapel, "Informe o papel do servidor (presidente, vice, secretario, participante, suplente)", "Papel inválido.");
        temp.setPapel(papel.toUpperCase());

        data = Validacao.validarDateScan(servidorcomissoesController::verificarData, "Informe a data de entrada do servidor na comissao (dd/MM/yyyy):", "Data inválida");
        temp.setEntrada(data);

        data = Validacao.validarDateScan(servidorcomissoesController::verificarData, "Informe a data de saida ou previsao de saida do servidor na comissao(dd/MM/yyyy):", "Data inválida");
        temp.setSaida(data);

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;

    }

    public void editaServidorComissoes(ServidorComissoes temp) {

        
        Date data;

        ComissaoGUI co = new ComissaoGUI();
        temp.setComissao(co.selecionarComissao());

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        String papel = Validacao.validarStringScan(servidorcomissoesController::verificarPapel, "Informe o papel do servidor (presidente, vice, secretario, participante, suplente)", "Papel inválido.");
        temp.setPapel(papel.toUpperCase());

        data = Validacao.validarDateScan(servidorcomissoesController::verificarData, "Informe a data de entrada do servidor na comissao (dd/MM/yyyy):", "Data inválida");
        temp.setEntrada(data);

        data = Validacao.validarDateScan(servidorcomissoesController::verificarData, "Informe a data de saida ou previsao de saida do servidor na comissao(dd/MM/yyyy):", "Data inválida");
        temp.setSaida(data);


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
            

            switch (opc) {

                case 1:
                    if (servidorcomissoesController.checarListaServidor() && servidorcomissoesController.checarListaComissao()) {
                    ServidorComissoes sC = criaServidorComissoes();

                    boolean foiInserido = servidorcomissoesController.adicionar(sC);

                    if (foiInserido) {
                        System.out.println("ServidorComissoes inserida com sucesso");
                    } else {
                        System.out.println("ServidorComissoes nao inserida");
                    }} else {
                        System.out.println("ServidorComissoes nao inserido, nenhum Servidor ou Comissao registrado");
                    }

                    break;
                case 2:
                    if (servidorcomissoesController.checarListaServidorComissoes()) {
                        ServidorComissoes editServidorComissoes = selecionarServidorComissoes();
                        editaServidorComissoes(editServidorComissoes);
                        System.out.println("ServidorComissoes editada com sucesso");
                    } else {
                        System.out.println("Nao existe nenhuma ServidorComissoes registrada");
                    }

                    break;

                case 3:
           
                         if (servidorcomissoesController.checarListaServidorComissoes()) {

                        ServidorComissoes removeServidorComissoes = selecionarServidorComissoes();
                        servidorcomissoesController.removerPorId(removeServidorComissoes.getId());
                        System.out.println("ServidorComissoes removida com sucesso");
                    } else {
                        System.out.println("Nenhuma ServidorComissoes encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodosServidorComissoes();
                    break;

                case 5:

                    break;

              

                default:
                    break;
            }

        } while (opc != 5);
    }
}
