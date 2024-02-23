package conta;

import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;


public class Menu {

	public static void main(String[] args) {

		/*Conta c1 = new Conta(1, 123, 1, "Jubileia", 2500);

		c1.visualizar();
		//c1.setAgencia(456);
		//System.out.println(c1.getAgencia());

		if (c1.sacar(100)) {
			System.out.println("Saque efetuado com sucesso. O novo saldo é de R$: " + c1.getSaldo());
		} else {
			System.out.println("O saldo é insuficiente");
		}
		
		c1.depositar(1000);
		System.out.println("O novo saldo é: " + c1.getSaldo()); */
			
		ContaCorrente contacorrente1 = new ContaCorrente(33, 22, 1, "Thiago", 1000, 6500);
		
		System.out.println(contacorrente1.getNumero());
		System.out.println(contacorrente1.getAgencia());
		System.out.println(contacorrente1.getTipo());
		System.out.println(contacorrente1.getTitular());
		System.out.println(contacorrente1.getSaldo());
		System.out.println(contacorrente1.getLimite());
		
		System.out.println("Saldo atual " + contacorrente1.getSaldo());
		System.out.println("--------------------------");
		
		ContaPoupanca contaPoupanca1 = new ContaPoupanca(33, 22, 2, "Luna", 1000);
		contaPoupanca1.gerarTaxa();
		System.out.println(contaPoupanca1.getSaldo());
		System.out.println("--------------------------");
		contaPoupanca1.sacar(1001);
		System.out.println("--------------------------");
		System.out.println(contaPoupanca1.getSaldo());
		
		
	}

	
}




