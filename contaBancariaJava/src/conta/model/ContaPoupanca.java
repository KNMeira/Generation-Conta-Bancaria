package conta.model;

public class ContaPoupanca extends Conta{
	
	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo) {
		super(numero, agencia, tipo, titular, saldo);	
		
	}
	
	public void gerarTaxa() {
	     saldo += saldo * .006;
	    
	   }

}