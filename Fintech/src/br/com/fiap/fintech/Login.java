package br.com.fiap.fintech;

import br.com.fiap.fintech.model.*;

import java.time.LocalDate;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // 1. Login do Usuário

        // Configurando o login com nome de usuário e senha
        Usuario login = new Usuario("usuarioExemplo", "senha123");

        // Solicitando o nome de usuário e senha do usuário
        System.out.print("Digite o nome de usuário: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Digite a senha: ");
        String enteredPassword = scanner.nextLine();

        // Autenticando o usuário
        if (login.authenticate(enteredUsername, enteredPassword)) {
            System.out.println("Login bem-sucedido!\n");
        } else {
            System.out.println("Nome de usuário ou senha incorretos.");
            scanner.close();
            return; // Encerrar o programa se o login falhar
        }




                // 2. Cadastro do Usuário

                System.out.print("Digite seu email: ");
                String email = scanner.nextLine();

                System.out.print("Digite sua data de nascimento (yyyy-mm-dd): ");
                LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());

                System.out.print("Digite uma nova senha: ");
                String novaSenha = scanner.nextLine();

                System.out.print("Confirme a nova senha: ");
                String confirmacaoSenha = scanner.nextLine();

                Cadastro usuario = new Cadastro(email, dataNascimento, novaSenha, confirmacaoSenha);

                // Tentativa de registro do usuário
                if (usuario.registrar()) {
                    System.out.println("Usuário cadastrado com sucesso.\n");
                } else {
                    System.out.println("Falha no cadastro do usuário.");
                    scanner.close();
                    return;
                }


                // 3. Cadastro de Endereço

                System.out.print("Digite a rua: ");
                String rua = scanner.nextLine();

                System.out.print("Digite o número: ");
                int numero = Integer.parseInt(scanner.nextLine());

                System.out.print("Digite o CEP: ");
                String cep = scanner.nextLine();

                System.out.print("Digite o complemento (se houver): ");
                String complemento = scanner.nextLine();

                CadastroEndereco endereco = new CadastroEndereco(rua, numero, cep, complemento);
                System.out.println("Endereço cadastrado: " + endereco.exibirEnderecoCompleto() + "\n");


                // 4. Cadastro de Cartão de Crédito

                System.out.print("Digite o número do cartão: ");
                String numeroCartao = scanner.nextLine();

                System.out.print("Digite o nome do titular do cartão: ");
                String nomeTitular = scanner.nextLine();

                System.out.print("Digite a data de validade do cartão (yyyy-mm-dd): ");
                LocalDate dataValidade = LocalDate.parse(scanner.nextLine());

                System.out.print("Digite o CVV do cartão: ");
                String cvv = scanner.nextLine();

                // Usar mensalidade double
                System.out.print("Digite o valor da mensalidade: ");
                double valorMensalidade = Double.parseDouble(scanner.nextLine());

                CadastroCartao cartao = new CadastroCartao(numeroCartao, nomeTitular, dataValidade, cvv, valorMensalidade);

                // Tentativa de pagamento da mensalidade
                if (cartao.realizarPagamento()) {
                    System.out.println("Mensalidade paga com sucesso.\n");
                } else {
                    System.out.println("Falha no pagamento da mensalidade.");
                    return;
                }


                // 5. Gerenciamento de Contas do Cartão

                GerenciadorCartao gerenciador = new GerenciadorCartao();

                // Adicionando contas/dívidas ao gerenciador
                gerenciador.adicionarConta(new ContaCartao(150.75, "Compra em supermercado", LocalDate.of(2024, 8, 1)));
                gerenciador.adicionarConta(new ContaCartao(250.50, "Compra online", LocalDate.of(2024, 8, 5)));
                gerenciador.adicionarConta(new ContaCartao(120.00, "Pagamento de assinatura", LocalDate.of(2024, 8, 10)));

                // Exibir todas as contas/dívidas
                System.out.println("Contas adicionadas:");
                gerenciador.exibirTodasContas();

                // Calcular e exibir o total das dívidas
                double totalDividas = gerenciador.calcularTotalDividas();
                System.out.println("\nTotal das dívidas: R$ " + totalDividas);

                // Fechar o scanner
                scanner.close();
            }
        }












