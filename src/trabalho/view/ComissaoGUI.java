/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;


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
        builder.append("\n5 - Alguma coisa");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Comissao criaComissao() {

        Comissao temp = new Comissao();

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Long.parseLong(scan.nextLine()));

        System.out.println("Data de inicio");
        temp.setInicio(scan.nextLine());

        System.out.println("Data de termino");
        temp.setTermino(scan.nextLine());

        System.out.println("Informe o estado da comissao");
        temp.setEstado(scan.nextLine());

        temp.setDataCriacao(Data.dataAtual());

        return temp;

    }

    public void editaComissao(Comissao temp) {

        System.out.println("Informe a quantidade de horas semanais");
        temp.setHorasSemanais(Long.parseLong(scan.nextLine()));

        System.out.println("Data de inicio");
        temp.setInicio(scan.nextLine());

        System.out.println("Data de termino");
        temp.setTermino(scan.nextLine());

        System.out.println("Informe o estado da comissao");
        temp.setEstado(scan.nextLine());

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
            String idComissao;

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
                    Comissao editComissao = selecionarComissao();

                    if (editComissao != null) {
                        editaComissao(editComissao);
                        System.out.println("Comissao editado com sucesso");
                    } else {
                        System.out.println("Comissao nao encontrada, tente novamente");
                    }

                    break;

                case 3:
                    mostrarTodasComissoes();

                    System.out.println("Informe o id da Comissao que deseja excluir");
                    String id = scan.nextLine();

                    Comissao removeComissao = comissaoController.buscaPorId(id);

                    if (removeComissao != null) {
                        comissaoController.removerPorId(id);
                        System.out.println("Comissao removida com sucesso");
                    } else {
                        System.out.println("Comissao nao encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasComissoes();
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
