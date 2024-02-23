package conta.model;

public class ContaCorrente extends Conta {
	
	private float limite;
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		if(this.getSaldo() + this.getLimite() < valor) {
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
