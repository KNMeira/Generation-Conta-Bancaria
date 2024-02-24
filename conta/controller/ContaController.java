package conta.controller;

import java.util.ArrayList;

import conta.model.Conta;
import conta.repository.*;

public class ContaController implements ContaRepository {
	
	private ArrayList<Conta> listaContas = new ArrayList<Conta>();
	
	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null)
			conta.visualizar();
		else
			System.out.println("\n A conta: "  +  "não foi encontrada!");
		
	}

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}
		
	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta);
		System.out.println("\n A conta número: " + conta.getNumero() + "foi criada com sucesso!");
		
	}

	@Override
	public void atualizar(Conta conta) {
		var buscaConta = buscarNaCollection(conta.getNumero());
		
		if(buscaConta != null) {
			listaContas.set(listaContas.indexOf(buscaConta), conta);
			System.out.println("\n A Conta número: " + conta.getNumero() + " foi atualizada com sucesso!");
		} else
			System.out.println("\n A Conta número: " + conta.getNumero() + " não foi encontrada!");
		
	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		
		if (conta != null) {
			if (listaContas.remove(conta) == true)
				System.out.println("\n A Conta numero: " + numero + " foi deletada com sucesso!");
		} else
			System.out.println("\n AConta numero: " + numero + " não foi encontrada!");
		
	}

	@Override
	public void sacar(int numero, float valor) {
		var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			
			if(conta.sacar(valor) == true)
				System.out.println("\n O Saque na Conta número: " + numero + "foi efetuado com sucesso!");
		} else
			System.out.println("\n A Conta numero: " + numero + "não foi encontrada!");
		
	}

	@Override
	public void depositar(int numero, float valor) {
var conta = buscarNaCollection(numero);
		
		if(conta != null) {
			conta.depositar(valor);
			System.out.println("\n O depósito da Conta numero: " + numero + "foi efetuado com sucesso!");
		} else
			System.out.println("\n A Conta número: " + numero + " não foi econtrada ou a Conta destino não é uma Conta Corrente!");
		
		
	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		var contaOrigem = buscarNaCollection(numeroOrigem);
		var contaDestino = buscarNaCollection(numeroDestino);
		
		if(contaOrigem != null && contaDestino != null) {
			
			if(contaOrigem.sacar(valor) == true) {
				
				if(contaOrigem.sacar(valor) == true) {
					contaDestino.depositar(valor);
					System.out.println("\n A Transferência foi efetuada com sucesso!");
				}
			} else
				System.out.println("\n A Conta de origem ou destino não foram encontradas!");
		}
		
	}
	
	public int gerarNumero() {
		return ++ numero ;
	}
	
	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas) {
			if(conta.getNumero() == numero) {
				return conta;
			}
		}
		return null;
	}

}
