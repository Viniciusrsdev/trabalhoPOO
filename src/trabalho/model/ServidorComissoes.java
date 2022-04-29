/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.model;

import java.time.LocalDateTime;
import java.util.Date;
import trabalho.Utils.Data;

/**
 *
 * @author vinic_oh1fkpu
 */
public class ServidorComissoes {

    private static long serial;
    private final long id;
    private Comissao comissao;
    private Servidor servidor;
    private String papel;
    private Date entrada;
    private Date saida;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public ServidorComissoes() {
        id = ++ServidorComissoes.serial;
    }

    public long getId() {
        return id;
    }

    public Comissao getComissao() {
        return comissao;
    }

    public void setComissao(Comissao comissao) {
        this.comissao = comissao;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Date getEntrada() {
        return entrada;
    }

    public void setEntrada(Date entrada) {
        this.entrada = entrada;
    }

    public Date getSaida() {
        return saida;
    }

    public void setSaida(Date saida) {
        this.saida = saida;
    }

   
    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(LocalDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServidorComissoes other = (ServidorComissoes) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    private String formatarDatas(){
        return " -> Entrou em " + Data.converterData(entrada) + " e saiu em " + Data.converterData(saida);
    }
    
    @Override
    public String toString() {
        return id + " -- " + comissao.getNome() + " - " + servidor.getNome() + "(" + papel + ")" + formatarDatas();
    }

}
