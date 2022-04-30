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
import trabalho.model.OfertaDisciplinas;
import trabalho.controller.OfertaDisciplinasController;

/**
 *
 * @author vinic_oh1fkpu
 */
public class OfertaDisciplinasGUI {

    Scanner scan = new Scanner(System.in);

    OfertaDisciplinasController ofertadisciplinasController = new OfertaDisciplinasController();

    public int recebeOpcaoUsuario() {

        StringBuilder builder = new StringBuilder("");

        builder.append("\nMenu Oferta de Disciplinas\n");
        builder.append("\n1 - Criar uma Oferta de Disciplina");
        builder.append("\n2 - Editar uma Oferta de Disciplina");
        builder.append("\n3 - Deletar uma Oferta de Disciplina");
        builder.append("\n4 - Mostrar todas as  Ofertas de Disciplina");
        builder.append("\n5 - Voltar\n");
        builder.append("\nEscolha uma opcao: ");

        System.out.print(builder.toString());

        return Integer.parseInt(scan.nextLine());
    }

    public OfertaDisciplinas criaOfertaDisciplinas() {

        Date data;
        long meses;

        OfertaDisciplinas temp = new OfertaDisciplinas();

        DisciplinaGUI d = new DisciplinaGUI();
        temp.setDisciplina(d.selecionarDisciplina());

        ServidorGUI s = new ServidorGUI();
        temp.setProfessor(s.selecionarServidorProfessor());

        data = Validacao.validarDateScan(ofertadisciplinasController::verificarAno, "Informe o ano da oferta de disciplina (yyyy):", "Ano inválido");
        temp.setAno(data);

        System.out.println("Informe o semestre da oferta de disciplina");
        temp.setSemestre(scan.nextLine());

        if (temp.getDisciplina().getPeriodicidade() == "ANUAL") {
            meses = 10;
        } else {
            meses = 5;
        }

        temp.setHorasSemanais(temp.getDisciplina().getCargaHoraria() / (meses * 4));

        temp.setAulasSemanais(temp.getHorasSemanais() / ((temp.getDisciplina().getCurso().getCampus().getDuracaoAulas()) / 60));

        temp.setDataCriacao(Data.dataAtual());
        temp.setDataModificacao(Data.dataAtual());

        return temp;
    }

    public void editaOfertaDisciplinas(OfertaDisciplinas temp) {

        Date data;
        long meses;

        DisciplinaGUI d = new DisciplinaGUI();
        temp.setDisciplina(d.selecionarDisciplina());

        ServidorGUI s = new ServidorGUI();
        temp.setProfessor(s.selecionarServidorProfessor());

        data = Validacao.validarDateScan(ofertadisciplinasController::verificarAno, "Informe o ano da oferta de disciplina (yyyy):", "Ano inválido");
        temp.setAno(data);

        System.out.println("Informe o semestre da oferta de disciplina");
        temp.setSemestre(scan.nextLine());

        if (temp.getDisciplina().getPeriodicidade() == "ANUAL") {
            meses = 10;
        } else {
            meses = 5;
        }

        temp.setHorasSemanais(temp.getDisciplina().getCargaHoraria() / (meses * 4));

        temp.setAulasSemanais(temp.getHorasSemanais() / ((temp.getDisciplina().getCurso().getCampus().getDuracaoAulas()) / 60));

        temp.setDataModificacao(Data.dataAtual());

    }

    public void mostrarTodasOfertasDisciplinas() {
        OfertaDisciplinas[] ofertadisciplinas = ofertadisciplinasController.listar();
        boolean temOfertaDisciplinas = false;
        for (OfertaDisciplinas i : ofertadisciplinas) {
            if (i != null) {
                System.out.println(i);
                temOfertaDisciplinas = true;
            }
        }
        if (!temOfertaDisciplinas) {
            System.out.println("não existe oferta de disciplina cadastrado");
        }
    }

    public OfertaDisciplinas selecionarOfertaDisciplinas() {
        mostrarTodasOfertasDisciplinas();
        OfertaDisciplinas selectOfertaDisciplinas = (OfertaDisciplinas) Validacao.validarObjectScan(ofertadisciplinasController::buscaPorId, "Insira o id do OfertaDisciplinas:", "OfertaDisciplinas inválido.");
        return selectOfertaDisciplinas;
    }

    public void menuOfertaDisciplinas() {
        int opc;

        do {

            opc = recebeOpcaoUsuario();

            switch (opc) {

                case 1:
                    if (ofertadisciplinasController.checarListaDisciplina() && ofertadisciplinasController.checarListaServidor()) {
                        OfertaDisciplinas oD = criaOfertaDisciplinas();

                        boolean foiInserido = ofertadisciplinasController.adicionar(oD);
                        if (foiInserido) {
                            System.out.println("oferta de disciplina inserida com sucesso");
                        } else {
                            System.out.println("oferta de disciplina nao inserida");
                        }
                    } else {
                        System.out.println("oferta de disciplina nao inserida, nenhum Servidor ou disciplina registrado");
                    }

                    break;
                case 2:

                    if (ofertadisciplinasController.checarListaOfertaDisciplinas()) {
                        OfertaDisciplinas editOfertaDisciplinas = selecionarOfertaDisciplinas();
                        editaOfertaDisciplinas(editOfertaDisciplinas);
                        System.out.println("oferta de disciplina editada com sucesso");
                    } else {
                        System.out.println("Nao existe nenhum oferta de disciplina registrado");
                    }
                    break;

                case 3:

                    if (ofertadisciplinasController.checarListaOfertaDisciplinas()) {

                        OfertaDisciplinas removeOfertaDisciplinas = selecionarOfertaDisciplinas();
                        ofertadisciplinasController.removerPorId(removeOfertaDisciplinas.getId());
                        System.out.println("oferta de disciplina removida com sucesso");
                    } else {
                        System.out.println("Nenhuma oferta de disciplina encontrada, tente novamente");
                    }

                    break;

                case 4:
                    mostrarTodasOfertasDisciplinas();
                    break;

                case 5:
                    break;

                default:
                    break;
            }

        } while (opc != 5);
    }
}
