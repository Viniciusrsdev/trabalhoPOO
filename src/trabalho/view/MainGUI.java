/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;

import java.util.Scanner;
import trabalho.DAO.ServidorDAO;

/**
 *
 * @author vinic_oh1fkpu
 */
public class MainGUI {

    Scanner scan = new Scanner(System.in);
    ServidorDAO servidorDAO = new ServidorDAO();

    public MainGUI() {
        // loginMenu();
        mainMenu();
    }

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("SEJA BEM VINDO AO SISTEMA IFTM\n\n");
        builder.append("\n1 - Fazer Login");
        builder.append("\n2 - Fechar aplicacao\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public int recebeOpcaoUsuario2() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Principal\n");
        builder.append("\n1 - Campus");
        builder.append("\n2 - Cursos");
        builder.append("\n3 - Disciplinas");
        builder.append("\n4 - Servidores");
        builder.append("\n5 - Oferta de Disciplinas");
        builder.append("\n6 - Orientacoes");
        builder.append("\n7 - Atividades");
        builder.append("\n8 - Comissoes");
        builder.append("\n9 - Reunioes");
        builder.append("\n10 - Sair\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public void loginMenu() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();

            switch (opc) {

                case 1:

                    System.out.println("Informe seu nome de usuario");
                    String login = scan.nextLine();

                    System.out.println("Informe sua senha");
                    String senha = scan.nextLine();

                    int tipoLogin = servidorDAO.autenticacao(login, senha);

                    if (tipoLogin == -1) {

                        System.out.println("Dados invalidos, tente novamente");

                    } else {
                        if (tipoLogin == 2) {
                            mainMenu();
                        } else {
                            mainMenu();
                        }

                    }

                    break;
                case 2:

                    break;

                default:
                    break;
            }

        } while (opc != 2);
    }

    public void mainMenu() {
        int opc;

        do {

            opc = recebeOpcaoUsuario2();

            switch (opc) {

                case 1:
                    new CampusGUI().menuCampus();

                    break;
                case 2:
                    new CursoGUI().menuCurso();
                    break;

                case 3:
                    new DisciplinaGUI().menuDisciplina();

                    break;

                case 4:
                    new ServidorGUI().menuServidor();
                    break;

                case 5:
                    new OfertaDisciplinasGUI().menuOfertaDisciplinas();
                    break;

                case 6:
                    new OrientacaoGUI().menuOrientacao();
                    break;

                case 7:
                    new AtividadeGUI().menuAtividade();
                    break;

                case 8:
                    new ComissaoGUI().menuComissao();
                    break;

                case 9:
                    new AtaReuniaoGUI().menuAtaReuniao();
                    break;

                case 10:

                    break;

                default:
                    break;
            }

        } while (opc != 10);
    }

}
