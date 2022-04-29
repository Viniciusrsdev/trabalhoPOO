/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho.model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author vinic_oh1fkpu
 */
public class Servidor {

    private static long serial;
    private final long id;
    private String nome;
    private String email;
    private Campus campus;
    private String cargo;
    private String login;
    private String senha;
    private boolean admnistrador;
    private LocalDateTime dataCriacao;
    private LocalDateTime dataModificacao;

    public Servidor() {
        id = ++Servidor.serial;
    }

    public Campus getCampus() {
        return campus;
    }

    public void setCampus(Campus campus) {
        this.campus = campus;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmnistrador() {
        return admnistrador;
    }

    public void setAdmnistrador(boolean admnistrador) {
        this.admnistrador = admnistrador;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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
        int hash = 5;
        hash = 67 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 67 * hash + Objects.hashCode(this.login);
        hash = 67 * hash + Objects.hashCode(this.senha);
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
        final Servidor other = (Servidor) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id + " -- " + nome + " (" + cargo + ") -- " + campus.abreviado() + " -> " + email;
    }
}
