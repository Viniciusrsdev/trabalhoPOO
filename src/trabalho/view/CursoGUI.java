/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.view;

import java.util.Date;
import trabalho.controller.CursoController;
import trabalho.model.Curso;
import java.util.Scanner;
import trabalho.Utils.Validacao;
import trabalho.Utils.Data;

/**
 *
 * @author vinic_oh1fkpu
 */
public class CursoGUI {

    CursoController cursoController = new CursoController();

    Scanner scan = new Scanner(System.in);

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Cursos\n");
        builder.append("\n1 - Criar um Curso");
        builder.append("\n2 - Editar um Curso");
        builder.append("\n3 - Deletar um Cursos");
        builder.append("\n4 - Mostrar todos os Cursos");
        builder.append("\n5 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public Curso criaCurso() {

        Curso temp = new Curso();
        Date data;

        System.out.println("Informe o nome do curso");
        temp.setNome(scan.nextLine());

        String estado = Validacao.validarStringScan(cursoController::verificarEstado, "Informe o estado do curso(ativo/inativo)", "Estado inválido.");
        temp.setEstado(estado.toUpperCase());

        CampusGUI c = new CampusGUI();
        temp.setCampus(c.selecionarCampus());

        data = Validacao.validarDateScan(cursoController::verificarAno, "Informe o ano de inicio do curso (yyyy):", "Ano inválido");
        temp.setInicio(data);

        if ("INATIVO".equals(temp.getEstado())) {
            data = Validacao.validarDateScan(cursoController::verificarAno, "Informe o ano de término do curso (yyyy):", "Ano inválido");
            temp.setTermino(data);
        }

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;
    }

    public void editaCurso(Curso temp) {

        Date data;

        System.out.println("Informe o nome do curso");
        temp.setNome(scan.nextLine());

        String estado = Validacao.validarStringScan(cursoController::verificarEstado, "Informe o estado do curso(ativo/inativo)", "Estado inválido.");
        temp.setEstado(estado.toUpperCase());

        CampusGUI c = new CampusGUI();
        temp.setCampus(c.selecionarCampus());

        data = Validacao.validarDateScan(cursoController::verificarAno, "Informe o ano de inicio do curso (yyyy):", "Ano inválido");
        temp.setInicio(data);

        if ("INATIVO".equals(temp.getEstado())) {
            data = Validacao.validarDateScan(cursoController::verificarAno, "Informe o ano de término do curso (yyyy):", "Ano inválido");
            temp.setTermino(data);
        }

        temp.setDataModificacao(Data.dataAtual());

    }

    public void mostrarTodoscursos() {
        Curso[] cursos = cursoController.listar();
        boolean temCurso = false;
        for (Curso i : cursos) {
            if (i != null) {
                System.out.println(i);
                temCurso = true;
            }
        }
        if (!temCurso) {
            System.out.println("Nao existe nenhum curso cadastrado");
        }
    }

    public Curso selecionarCurso() {
        mostrarTodoscursos();
        Curso selectCurso = (Curso) Validacao.validarObjectScan(cursoController::buscaPorId, "Insira o id do Curso:", "Curso inválido.");
        return selectCurso;
    }

    public void menuCurso() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();

            switch (opc) {

                case 1:
                    if (cursoController.checarListaCampus()) {
                        Curso c = criaCurso();
                        boolean foiInserido = cursoController.adicionar(c);
                        if (foiInserido) {
                            System.out.println("Curso inserido com sucesso");
                        } else {
                            System.out.println("Curso nao inserido");
                        }
                    } else {
                        System.out.println("Curso nao inserido, nenhum Campus registrado");
                    }
                    break;
                case 2:

                    if (cursoController.checarListaCurso()) {
                        Curso editCurso = selecionarCurso();
                        editaCurso(editCurso);
                        System.out.println("Curso editado com sucesso");
                    } else {
                        System.out.println("Nao existe nenhum Curso registrado");
                    }
                    break;

                case 3:
                    if (cursoController.checarListaCampus()) {

                        Curso removeCurso = selecionarCurso();
                        cursoController.removerPorId(removeCurso.getId());
                        System.out.println("Curso removido com sucesso");
                    } else {
                        System.out.println("Nenhum curso encontrado, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodoscursos();
                    break;

                case 5:

                    break;

                default:
                    break;
            }

        } while (opc != 5);

    }

}
