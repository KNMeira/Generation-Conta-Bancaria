package conta;

import java.io.IOException;
import java.util.*;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
				/* // Teste da Classe Conta
				Conta c1 = new Conta(3, 123, 1, "Mariana", 500000.0f);
				c1.visualizar();
				c1.sacar(12000.0f);
				c1.visualizar();
				c1.depositar(5000.0f);
				c1.visualizar();
		        
				// Teste da Classe Conta Corrente
				ContaCorrente cc1 = new ContaCorrente(1, 123, 1, "José da Silva", 0.0f, 1000.0f);
				cc1.visualizar();
				cc1.sacar(12000.0f);
				cc1.visualizar();
				cc1.depositar(5000.0f);
				cc1.visualizar();
				
		        // Teste da Classe Conta Poupança
				ContaPoupanca cp1 = new ContaPoupanca(2, 123, 2, "Maria dos Santos", 100000.0f, 15);
				cp1.visualizar();
		        cp1.sacar(1000.0f);
				cp1.visualizar();
				cp1.depositar(5000.0f);
				cp1.visualizar(); */
		
		Scanner scanner = new Scanner(System.in);

		int opcao;
		int numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite = 0, valor;
		
		ContaController contas = new ContaController();

		while (true) {

			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO GENERATION                     ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     ");

			//opcao = scanner.nextInt();
			
			try {
				opcao = scanner.nextInt();
			}catch(InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				scanner.nextLine();
				opcao=0;
			}

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu futuro começa aqui!");
				sobre();
				scanner.close();
				System.exit(0);
			}

			if (opcao == 9) {
				System.out.println("\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
                scanner.close();
				System.exit(0);
			}

			scanner.nextLine();
			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_PURPLE + "\n Criar Conta");
				System.out.println("Digite o Número da Agência: ");
				agencia = scanner.nextInt();
				System.out.println("Digite o Nome do Titular da Conta: ");
				scanner.skip("\\R?");
				titular = scanner.nextLine();
				
				do {
					System.out.println("Digite o Tipo da Conta (1-CC ou 2-CP): ");
					tipo = scanner.nextInt();
				}while(tipo < 1 && tipo > 2);
				
				System.out.println("Digite o Saldo da Conta (R$): ");
				saldo = scanner.nextFloat();
				
				switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = scanner.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite ));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = scanner.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
				}
				
				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_BLUE + "\n Listar todas as Contas");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_YELLOW + "\n Buscar Conta por número");
				
				System.out.println("Digite o número da conta");
				numero = scanner.nextInt();
				
				contas.procurarPorNumero(numero);
				
				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_GREEN + "\n Atualizar dados da Conta");
				
				System.out.println("Digite o número da Conta: ");
				numero = scanner.nextInt();
				
				var buscaConta = contas.buscarNaCollection(numero);
				
				if(buscaConta != null) {
					
					tipo = buscaConta.getTipo();
					
					System.out.println("Digite o Número da Agência: ");
					agencia = scanner.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					scanner.skip("\\R?");
					titular = scanner.nextLine();
					
					System.out.println("Digite o Saldo da Conta(R$): ");
					saldo = scanner.nextFloat();
					
					switch(tipo) {
					case 1 -> {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = scanner.nextFloat();
						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite ));
					}
					case 2 -> {
						System.out.println("Digite o dia do Aniversario da Conta: ");
						aniversario = scanner.nextInt();
						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					default -> {
						System.out.println("Tipo de conta inválido!");
					}
				  }
				}else {
					System.out.println("A conta não foi encontrada!");
				}

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_RED + "\n Apagar Conta");
				
				System.out.println("Digite o número da conta: ");
				numero = scanner.nextInt();
				
				contas.deletar(numero);
				
				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_CYAN + "\n Sacar");
				
				System.out.println("Digite o número da Conta: ");
				numero = scanner.nextInt();
				
				do {
					System.out.println("Digite o valor do Saque (R$): ");
					valor = scanner.nextInt();
				}while(valor <= 0);
				
				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_GREEN_BOLD + "\n Depositar");
				
				System.out.println("Digite o número da Conta: ");
				numero = scanner.nextInt();
				
				do {
					System.out.println("Digite o valor do Depósito (R$): ");
					valor = scanner.nextInt();
				}while(valor <= 0);
				
				contas.depositar(numero, valor);
				
				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_YELLOW_BOLD + "\n Transferir");
				
				System.out.println("Digite o número da conta de origem: ");
				numero = scanner.nextInt();
				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = scanner.nextInt();
				
				do {
					System.out.println("Digite o valor da Transferência (R$): ");
					valor = scanner.nextFloat();
				}while(valor <= 0);
				
				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
			default:
				System.out.println("\nOpção Inválida" + Cores.TEXT_RESET);
				
				keyPress();
				break;
			}
		}
	}
	
		

		private static void sobre() {
		
	}
		
		public static void keyPress() {

			try {

				System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
				System.in.read();

			} catch (IOException e) {

				System.out.println("Você pressionou uma tecla diferente de enter!");

			}

		
		}
		
	}

	





