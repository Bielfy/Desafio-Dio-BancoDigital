package Aplicativo;

import Modelos.Cliente.Cliente;
import Modelos.Contas.Conta;
import Modelos.Contas.ContaCorrente;
import Modelos.Contas.ContaPoupanca;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem vindo ao Banco, Gostaria de realizar cadastro?");
        System.out.println("Por favor digite Sim ou Não");
        String simOuNao = scanner.nextLine();

        if (simOuNao.equalsIgnoreCase("Sim")) {
            Cliente Jose = new Cliente();


            System.out.println("Digite o nome do cliente:");
            String nomeCliente = scanner.nextLine();

            Cliente novoCliente = new Cliente();
            novoCliente.setNome(nomeCliente);

            Conta cc = new ContaCorrente(novoCliente);
            Conta poupanca = new ContaPoupanca(novoCliente);

            boolean continuar = true;

            while (continuar) {
                System.out.println("Escolha uma opção:");
                System.out.println("1 - Depositar");
                System.out.println("2 - Sacar");
                System.out.println("3 - Transferir para a Poupança");
                System.out.println("4 - Imprimir Extrato");
                System.out.println("5 - Sair");

                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.println("Digite o valor que deseja Depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        cc.depositar(valorDeposito);
                        break;
                    case 2:
                        System.out.println("Digite o valor que deseja Sacar: ");
                        double valorSaque = scanner.nextDouble();
                        cc.sacar(valorSaque);
                        break;
                    case 3:
                        System.out.println("Digite o valor que deseja Transferir para a Poupança: ");
                        double valorTransferencia = scanner.nextDouble();
                        cc.transferir(valorTransferencia, poupanca);
                        break;
                    case 4:
                        cc.imprimirExtrato();
                        poupanca.imprimirExtrato();
                        System.out.println(" ");
                        break;
                    case 5:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }

            scanner.close();
        } else {
            System.out.println("Tudo bem, volte sempre ;)");
        }
    }
}
