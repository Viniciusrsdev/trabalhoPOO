/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;

import java.util.Scanner;
import trabalho.Utils.Data;
import trabalho.Utils.Validacao;
import trabalho.controller.ServidorController;
import trabalho.model.Servidor;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ServidorGUI {

    Scanner scan = new Scanner(System.in);

    ServidorController servidorController = new ServidorController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Servidor\n");
        builder.append("\n1 - Criar um Servidor");
        builder.append("\n2 - Editar um Servidor");
        builder.append("\n3 - Deletar um Servidor");
        builder.append("\n4 - Mostrar todos os Servidores");
        builder.append("\n5 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Servidor criaServidor() {

        Servidor temp = new Servidor();

        System.out.println("Informe o nome do servidor");
        temp.setNome(scan.nextLine());

        System.out.println("Informe o email do servidor");
        temp.setEmail(scan.nextLine());

        CampusGUI c = new CampusGUI();
        temp.setCampus(c.selecionarCampus());

        temp.setCargo(Validacao.validarStringScan(servidorController::verificarCargo, "Informe o cargo do servidor(professor/tecnico)", "Cargo invalido, insira professor ou tecnico").toUpperCase());

        System.out.println("Informe o login do servidor");
        temp.setLogin(scan.nextLine());

        System.out.println("Informe a senha do servidor");
        temp.setSenha(scan.nextLine());

        temp.setAdmnistrador(Validacao.validarBooleanScan(servidorController::verificarAdministrador, "O servidor sera um administrador?(s/n)", "Opcao invalida, insira sim(s) ou nao(n)"));

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;
    }

    public void editaServidor(Servidor temp) {

        System.out.println("Informe o nome do servidor");
        temp.setNome(scan.nextLine());

        System.out.println("Informe o email do servidor");
        temp.setEmail(scan.nextLine());

        CampusGUI c = new CampusGUI();
        temp.setCampus(c.selecionarCampus());

        temp.setCargo(Validacao.validarStringScan(servidorController::verificarCargo, "Informe o cargo do servidor(professor/tecnico)", "Cargo invalido, insira professor ou tecnico").toUpperCase());

        System.out.println("Informe o login do servidor");
        temp.setEmail(scan.nextLine());

        System.out.println("Informe asenha do servidor");
        temp.setEmail(scan.nextLine());

        temp.setAdmnistrador(Validacao.validarBooleanScan(servidorController::verificarAdministrador, "O servidor sera um administrador?(s/n)", "Opcao invalida, insira sim(s) ou nao(n)"));

        temp.setDataModificacao(Data.dataAtual());

    }

    public void mostrarTodosServidores() {
        Servidor[] servidores = servidorController.listar();
        boolean temServidor = false;
        for (Servidor i : servidores) {
            if (i != null) {
                System.out.println(i);
                temServidor = true;
            }
        }
        if (!temServidor) {
            System.out.println("não existe servidor cadastrado");
        }
    }

    public void mostrarTodosServidoresProfessores() {
        Servidor[] servidores = servidorController.listar();
        boolean tem = false;
        for (Servidor i : servidores) {
            if (i != null && "PROFESSOR".equals(i.getCargo())) {
                System.out.println(i);
                tem = true;
            }
        }
        if (!tem) {
            System.out.println("não existe servidor cadastrado");
        }
    }

    public Servidor selecionarServidor() {
        mostrarTodosServidores();
        Servidor selectServidor = (Servidor) Validacao.validarObjectScan(servidorController::buscaPorId, "Insira o id do Servidor:", "Servidor inválido.");
        return selectServidor;
    }

    public Servidor selecionarServidorProfessor() {
        mostrarTodosServidoresProfessores();
        Servidor selectServidor = (Servidor) Validacao.validarObjectScan(servidorController::buscaPorIdProfessor, "Insira o id do Professor:", "Professor inválido.");
        return selectServidor;
    }

    public void menuServidor() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();

            switch (opc) {

                case 1:

                    if (servidorController.checarListaCampus()) {
                        Servidor s = criaServidor();
                        boolean foiInserido = servidorController.adicionar(s);
                        if (foiInserido) {
                            System.out.println("Servidor inserido com sucesso");
                        } else {
                            System.out.println("Servidor nao inserido");
                        }
                    } else {
                        System.out.println("Servidor nao inserido, nenhum Campus registrado");
                    }
                    break;

                case 2:
                    if (servidorController.checarListaServidor()) {

                        Servidor editServidor = selecionarServidor();
                        editaServidor(editServidor);
                        System.out.println("Servidor editado com sucesso");
                    } else {
                        System.out.println("Nenhum servidor encontrado, tente novamente");
                    }

                    break;

                case 3:
                    if (servidorController.checarListaServidor()) {

                        Servidor removeServidor = selecionarServidor();
                        servidorController.removerPorId(removeServidor.getId());
                        System.out.println("Servidor removido com sucesso");
                    } else {
                        System.out.println("Nenhum servidor encontrado, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodosServidores();
                    break;

                case 5:
                    break;

                default:
                    break;
            }

        } while (opc != 5);
    }

}
