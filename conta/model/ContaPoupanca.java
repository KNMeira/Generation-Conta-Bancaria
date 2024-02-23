package conta.model;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);	
		
	}
	
	public void gerarTaxa() {
	     saldo += saldo * .006;
	    
	   }

	@Override
	public boolean sacar(float valor) {
		if(this.getSaldo() < valor) {
			System.out.println("\n Saldo insuficiente");
			return false;
		}
		this.setSaldo(this.getSaldo() - valor);
		System.out.println("\n valor sacado com sucesso");
		return true;
	}

	@Override
	public void depositar(float valor) {
		this.setSaldo(this.saldo + valor);
		
	}

	@Override
	public void visualizar() {
			String tipoConta = "";
			
			switch(this.tipo) {
			case 1:
				tipoConta = "Conta Corrente";
				break;
			case 2:
				tipoConta = "Conta Poupança";
				break;
			
			}
			
			System.out.println("********************");
			System.out.println("Dados da Conta");
			System.out.println("********************");
			System.out.println("Número da conta: " + this.numero);
			System.out.println("Agência da conta: " + this.agencia);
			System.out.println("Tipo da conta: " + tipoConta);
			System.out.println("Titular da conta: " + this.titular);
			System.out.println("Saldo da conta: " + this.saldo);
		
	}

}