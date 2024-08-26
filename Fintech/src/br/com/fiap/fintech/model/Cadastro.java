package br.com.fiap.fintech.model;

import java.time.LocalDate;
import java.util.regex.Pattern;

    public class Cadastro {
        private String email;
        private LocalDate dataDeNascimento;
        private String senha;
        private String confirmacaoSenha;

        public Cadastro(String email, LocalDate dataDeNascimento, String senha, String confirmacaoSenha) {
            this.email = email;
            this.dataDeNascimento = dataDeNascimento;
            this.senha = senha;
            this.confirmacaoSenha = confirmacaoSenha;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public LocalDate getDataDeNascimento() {
            return dataDeNascimento;
        }
        public void setDataDeNascimento(LocalDate dataDeNascimento) {
            this.dataDeNascimento = dataDeNascimento;
        }
        public String getSenha() {
            return senha;
        }
        public void setSenha(String senha) {
            this.senha = senha;
        }
        public String getConfirmacaoSenha() {
            return confirmacaoSenha;
        }
        public void setConfirmacaoSenha(String confirmacaoSenha) {
            this.confirmacaoSenha = confirmacaoSenha;
        }
        public boolean isSenhaConfirmada() {
            return this.senha.equals(this.confirmacaoSenha);
        }
        public boolean isEmailValido() {
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(emailRegex);
            return pattern.matcher(this.email).matches();
        }
        public boolean registrar() {
            if (!isEmailValido()) {
                System.out.println("Email inválido.");
                return false;
            }
            if (!isSenhaConfirmada()) {
                System.out.println("As senhas não coincidem.");
                return false;
            }
            System.out.println("Usuário registrado com sucesso!");
            return true;
        }
    }


