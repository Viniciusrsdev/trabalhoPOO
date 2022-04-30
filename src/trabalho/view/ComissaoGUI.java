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
import trabalho.controller.ComissaoController;
import trabalho.model.Comissao;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ComissaoGUI {

    Scanner scan = new Scanner(System.in);

    ComissaoController comissaoController = new ComissaoController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Comissao\n");
        builder.append("\n1 - Criar uma Comissao");
        builder.append("\n2 - Editar uma Comissao");
        builder.append("\n3 - Deletar uma Comissao");
        builder.append("\n4 - Mostrar todas as Comissoes");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Comissao criaComissao() {

        Comissao temp = new Comissao();
        Date data;

        System.out.println("Informe o nome da comissao");
        temp.setNome(scan.nextLine());

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Double.parseDouble(scan.nextLine()));

        temp.setEstado(Validacao.validarStringScan(comissaoController::verificarEstado, "Informe o estado da comissao :", "Estado invalido"));

        data = Validacao.validarDateScan(comissaoController::verificarData, "Informe a data de início da comissão (dd/MM/yyyy):", "Ano inválido");
        temp.setInicio(data);

        if ("INATIVO".equals(temp.getEstado())) {
            data = Validacao.validarDateScan(comissaoController::verificarData, "Informe a data de término da comissão (dd/MM/yyyy):", "Ano inválido");
            temp.setTermino(data);
        }

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;

    }

    public void editaComissao(Comissao temp) {

        Date data;

        System.out.println("Informe o nome da comissao");
        temp.setNome(scan.nextLine());

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Double.parseDouble(scan.nextLine()));

        temp.setEstado(Validacao.validarStringScan(comissaoController::verificarEstado, "Informe o estado da comissao :", "Estado invalido"));

        data = Validacao.validarDateScan(comissaoController::verificarData, "Informe a data de início da comissão (dd/MM/yyyy):", "Ano inválido");
        temp.setInicio(data);

        if ("INATIVO".equals(temp.getEstado())) {
            data = Validacao.validarDateScan(comissaoController::verificarData, "Informe a data de término da comissão (dd/MM/yyyy):", "Ano inválido");
            temp.setTermino(data);
        }

        temp.setDataModificacao(Data.dataAtual());

    }

    public void mostrarTodasComissoes() {
        Comissao[] comissoes = comissaoController.listar();
        boolean temComissao = false;
        for (Comissao i : comissoes) {
            if (i != null) {
                System.out.println(i);
                temComissao = true;
            }
        }
        if (!temComissao) {
            System.out.println("Não existe nenhuma Comissao cadastrada");
        }
    }

    public Comissao selecionarComissao() {
        mostrarTodasComissoes();
        Comissao selectComissao = (Comissao) Validacao.validarObjectScan(comissaoController::buscaPorId, "Insira o id da Comissao:", "Comissao inválida.");
        return selectComissao;
    }

    public void menuComissao() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();

            switch (opc) {

                case 1:
                    Comissao c = criaComissao();

                    boolean foiInserido = comissaoController.adicionar(c);

                    if (foiInserido) {
                        System.out.println("Comissao inserida com sucesso");
                    } else {
                        System.out.println("Comissao nao inserida");
                    }

                    break;
                case 2:
                    if (comissaoController.checarListaComissao()) {
                        Comissao editComissao = selecionarComissao();
                        editaComissao(editComissao);
                        System.out.println("Comissao editado com sucesso");
                    } else {
                        System.out.println("Nao existe nenhuma Comissao registrada");
                    }

                    break;

                case 3:
                    if (comissaoController.checarListaComissao()) {
                        Comissao removeComissao = selecionarComissao();
                        comissaoController.removerPorId(removeComissao.getId());
                        System.out.println("Comissao excluida com sucesso");
                    } else {
                        System.out.println("Nao existe nenhuma Comissao registrada");
                    }

                    break;

                case 4:
                    mostrarTodasComissoes();
                    break;

                case 5:

                    break;

                default:
                    break;
            }

        } while (opc != 5);
    }
}
