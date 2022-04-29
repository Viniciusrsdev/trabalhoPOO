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
        builder.append("\n5 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Atividade criaAtividade() {

        Atividade temp = new Atividade();
        Date data;

        System.out.println("Informe a descricao da atividade");
        temp.setDescricao(scan.nextLine());

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Double.parseDouble(scan.nextLine()));

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        data = Validacao.validarDateScan(atividadeController::verificarData, "Informe a data de inicio da atividade (dd/MM/yyyy):", "Data inválida");
        temp.setInicio(data);

        data = Validacao.validarDateScan(atividadeController::verificarData, "Informe a data de termino ou previsao de termino da atividade(dd/MM/yyyy):", "Data inválida");
        temp.setTermino(data);

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;

    }

    public void editaAtividade(Atividade temp) {

        Date data;

        System.out.println("Informe a descricao da atividade");
        temp.setDescricao(scan.nextLine());

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Double.parseDouble(scan.nextLine()));

        ServidorGUI s = new ServidorGUI();
        temp.setServidor(s.selecionarServidor());

        data = Validacao.validarDateScan(atividadeController::verificarData, "Informe a data de inicio da atividade (dd/MM/yyyy):", "Data inválida");
        temp.setInicio(data);

        data = Validacao.validarDateScan(atividadeController::verificarData, "Informe a data de termino ou previsao de termino da atividade(dd/MM/yyyy):", "Data inválida");
        temp.setTermino(data);

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

            switch (opc) {

                case 1:
                    if (atividadeController.checarListaServidor()) {
                        Atividade a = criaAtividade();

                        boolean foiInserido = atividadeController.adicionar(a);

                        if (foiInserido) {
                            System.out.println("Atividade inserida com sucesso");
                        } else {
                            System.out.println("Atividade nao inserida");
                        }
                    } else {
                        System.out.println("Atividade nao inserida, nenhum Servidor registrado");
                    }

                    break;
                case 2:

                    if (atividadeController.checarListaAtividade()) {
                        Atividade editAtividade = selecionarAtividade();
                        editaAtividade(editAtividade);
                        System.out.println("Atividade editado com sucesso");
                    } else {
                        System.out.println("Nao existe nenhuma Atividade registrada");
                    }

                    break;

                case 3:

                    if (atividadeController.checarListaAtividade()) {

                        Atividade removeAtividade = selecionarAtividade();
                        atividadeController.removerPorId(removeAtividade.getId());
                        System.out.println("Atividade removida com sucesso");
                    } else {
                        System.out.println("Nenhuma Atividade encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasAtividades();
                    break;

                case 5:

                    break;

                default:
                    break;
            }

        } while (opc != 5);
    }
}
