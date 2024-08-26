package br.com.fiap.fintech.model;

    import java.util.ArrayList;
    import java.util.List;

    public class GerenciadorCartao {
        private List<ContaCartao> contas;

        public GerenciadorCartao() {
            this.contas = new ArrayList<>();
        }

        public void adicionarConta(ContaCartao conta) {
            this.contas.add(conta);
        }


        public double calcularTotalDividas() {
            double total = 0.0;
            for (ContaCartao conta : contas) {
                total += conta.getValor();
            }
            return total;
        }


        public void exibirTodasContas() {
            if (contas.isEmpty()) {
                System.out.println("Nenhuma conta adicionada.");
            } else {
                for (ContaCartao conta : contas) {
                    System.out.println(conta.exibirDetalhes());
                }
            }
        }
    }

