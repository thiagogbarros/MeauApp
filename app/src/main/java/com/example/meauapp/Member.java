package com.example.meauapp;

public class Member {
    private String Nome, Email, Estado, Cidade, Endereco, Telefone, Nome_Usuario, Senha, Confirmacao_Senha,FotoPerfil;
    private Integer Idade;
    public Member() {

    }

    public String getFotoPerfil() {
        return FotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        FotoPerfil = fotoPerfil;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String cidade) {
        Cidade = cidade;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        Telefone = telefone;
    }

    public String getNome_Usuario() {
        return Nome_Usuario;
    }

    public void setNome_Usuario(String nome_Usuario) {
        Nome_Usuario = nome_Usuario;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
    }

    public String getConfirmacao_Senha() {
        return Confirmacao_Senha;
    }

    public void setConfirmacao_Senha(String confirmacao_Senha) {
        Confirmacao_Senha = confirmacao_Senha;
    }

    public Integer getIdade() {
        return Idade;
    }

    public void setIdade(Integer idade) {
        Idade = idade;
    }


}
