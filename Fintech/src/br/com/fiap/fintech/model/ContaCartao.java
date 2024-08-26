package br.com.fiap.fintech.model;

    import java.time.LocalDate;

    public class ContaCartao {
        private double valor;
        private String descricao;
        private LocalDate data;

        public ContaCartao(double valor, String descricao, LocalDate data) {
            this.valor = valor;
            this.descricao = descricao;
            this.data = data;
        }


        public double getValor() {
            return valor;
        }

        public void setValor(double valor) {
            this.valor = valor;
        }

        public String getDescricao() {
            return descricao;
        }

        public void setDescricao(String descricao) {
            this.descricao = descricao;
        }

        public LocalDate getData() {
            return data;
        }

        public void setData(LocalDate data) {
            this.data = data;
        }


        public String exibirDetalhes() {
            return "Descrição: " + descricao + ", Valor: R$ " + valor + ", Data: " + data;
        }
    }


