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
import trabalho.model.Campus;
import trabalho.controller.CampusController;

/**
 *
 * @author vinic_oh1fkpu
 */
public class CampusGUI {

    Scanner scan = new Scanner(System.in);

    CampusController campusController = new CampusController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Campus\n");
        builder.append("\n1 - Criar um Campus");
        builder.append("\n2 - Editar um Campus");
        builder.append("\n3 - Deletar um Campus");
        builder.append("\n4 - Mostrar todos os Campus");
        builder.append("\n5 - Alguma coisa");
        builder.append("\n6 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Campus criaCampus() {

        Campus temp = new Campus();
        Date data;

        System.out.println("Informe o nome do campus");
        temp.setNome(scan.nextLine());

        System.out.println("Informe a abreviacao do campus");
        temp.setAbreviacao(scan.nextLine());

        System.out.println("Informe a duracao das aulas do campus (em minutos)");
        temp.setDuracaoAulas(Long.parseLong(scan.nextLine()));

        data = Validacao.validarDateScan(campusController::verificarData, "Informe a data de criacao do campus(dd/MM/yyyy):", "Data inválida");
        temp.setDataCriacaoCampus(data);

        System.out.println("Informe a cidade do campus");
        temp.setCidade(scan.nextLine());

        System.out.println("Informe o bairro do campus");
        temp.setBairro(scan.nextLine());

        System.out.println("Informe o endereco do campus");
        temp.setEndereco(scan.nextLine());

        String cep = Validacao.validarStringScan(campusController::verificarCep, "Informe o cep do campus (00000000):", "Cep inválido, lembre-se de inserir apenas números.");
        temp.setCep(cep.substring(0, 5) + "-" + cep.substring(5));

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;
    }

    public void editaCampus(Campus temp) {

        Date data;

        System.out.println("Informe o nome do campus");
        temp.setNome(scan.nextLine());

        System.out.println("Informe a abreviacao do campus");
        temp.setAbreviacao(scan.nextLine());

        System.out.println("Informe a duracao das aulas do campus (em minutos)");
        temp.setDuracaoAulas(Long.parseLong(scan.nextLine()));

        data = Validacao.validarDateScan(campusController::verificarData, "Informe a data de criacao do campus(dd/MM/yyyy):", "Data inválida");
        temp.setDataCriacaoCampus(data);

        System.out.println("Informe a cidade do campus");
        temp.setCidade(scan.nextLine());

        System.out.println("Informe o bairro do campus");
        temp.setBairro(scan.nextLine());

        System.out.println("Informe o endereco do campus");
        temp.setEndereco(scan.nextLine());

        String cep = Validacao.validarStringScan(campusController::verificarCep, "Informe o cep do campus (00000000):", "Cep inválido, lembre-se de inserir apenas números.");
        temp.setCep(cep.substring(0, 5) + "-" + cep.substring(5));

        temp.setDataModificacao(Data.dataAtual());

    }

    public void mostrarTodosCampus() {
        Campus[] campus = campusController.listar();
        boolean temCampus = false;
        for (Campus i : campus) {
            if (i != null) {
                System.out.println(i);
                temCampus = true;
            }
        }
        if (!temCampus) {
            System.out.println("Nao existe nenhum campus cadastrado");
        }
    }

    public Campus selecionarCampus() {

        mostrarTodosCampus();
        Campus selectCampus = (Campus) Validacao.validarObjectScan(campusController::buscaPorId, "Insira o id do Campus:", "Campus inválido.");
        return selectCampus;
    }

    public void menuCampus() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();

            switch (opc) {

                case 1:
                    Campus c = criaCampus();

                    boolean foiInserido = campusController.adicionar(c);

                    if (foiInserido) {
                        System.out.println("Campus inserido com sucesso");
                    } else {
                        System.out.println("Campus nao inserido");
                    }

                    break;
                case 2:

                    if (campusController.checarListaCampus()) {
                        mostrarTodosCampus();
                        Campus editCampus = selecionarCampus();
                        editaCampus(editCampus);
                        System.out.println("Campus editado com sucesso");
                    } else {
                        System.out.println("Nenhum Campus registrado");
                    }
                    break;

                case 3:
                    if (campusController.checarListaCampus()) {
                        mostrarTodosCampus();
                        Campus removeCampus = selecionarCampus();
                        campusController.removerPorId(removeCampus.getId());
                        System.out.println("Campus removido com sucesso");
                    } else {
                        System.out.println("Nenhum campus encontrado, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodosCampus();
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
