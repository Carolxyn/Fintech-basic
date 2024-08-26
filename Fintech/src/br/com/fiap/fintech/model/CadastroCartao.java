package br.com.fiap.fintech.model;

    import java.time.format.DateTimeFormatter;
    import java.time.LocalDate;


    public class CadastroCartao {
        private String numeroCartao;
        private String nomeTitular;
        private LocalDate dataValidade;
        private String cvv;
        private double valorMensalidade;

        public CadastroCartao(String numeroCartao, String nomeTitular, LocalDate dataValidade, String cvv, double valorMensalidade) {
            this.numeroCartao = numeroCartao;
            this.nomeTitular = nomeTitular;
            this.dataValidade = dataValidade;
            this.cvv = cvv;
            this.valorMensalidade = valorMensalidade;
        }
        public String getNumeroCartao() {
            return numeroCartao;
        }
        public void setNumeroCartao(String numeroCartao) {
            this.numeroCartao = numeroCartao;
        }
        public String getNomeTitular() {
            return nomeTitular;
        }
        public void setNomeTitular(String nomeTitular) {
            this.nomeTitular = nomeTitular;
        }
        public LocalDate getDataValidade() {
            return dataValidade;
        }
        public void setDataValidade(LocalDate dataValidade) {
            this.dataValidade = dataValidade;
        }
        public String getCvv() {
            return cvv;
        }
        public void setCvv(String cvv) {
            this.cvv = cvv;
        }
        public double getValorMensalidade() {
            return valorMensalidade;
        }
        public void setValorMensalidade(double valorMensalidade) {
            this.valorMensalidade = valorMensalidade;
        }
        public boolean isNumeroCartaoValido() {
            int sum = 0;
            boolean alternate = false;
            for (int i = numeroCartao.length() - 1; i >= 0; i--) {
                int n = Integer.parseInt(numeroCartao.substring(i, i + 1));
                if (alternate) {
                    n *= 2;
                    if (n > 9) {
                        n -= 9;
                    }
                }
                sum += n;
                alternate = !alternate;
            }
            return (sum % 10 == 0);
        }
        public boolean isDataValidadeValida() {
            return !dataValidade.isBefore(LocalDate.now());
        }
        public boolean realizarPagamento() {
            if (!isNumeroCartaoValido()) {
                System.out.println("Número do cartão inválido.");
                return false;
            }
            if (!isDataValidadeValida()) {
                System.out.println("Cartão expirado.");
                return false;
            }
            System.out.println("Pagamento de " + valorMensalidade + " realizado com sucesso!");
            return true;
        }
    }


