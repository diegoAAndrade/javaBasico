class Conta{
	protected double saldo;
	
	public double getSaldo(){
		return this.saldo;
	}
	
	public void deposita(double valorASerDepositado){
		this.saldo += valorASerDepositado;
	}
	
	public boolean saca(double valorASerSacado){
		if (valorASerSacado > this.saldo){
			return false;
		}else {
			this.saldo -= valorASerSacado;
			return true;
		}
	}
	public void atualiza(double taxa){
		this.saldo += this.saldo * taxa;
	}
}

class ContaCorrente extends Conta{
	public void atualiza(double taxa){
		this.saldo += this.saldo * taxa * 2;
	}
}
class ContaPoupanca extends Conta {
	public void atualiza(double taxa){
		this.saldo += this.saldo * taxa * 3;
	}
	public void deposita(double valorASerDepositado){
		this.saldo += valorASerDepositado - 0.10;
	}
	
}

class AtualizadorDeContas {
    private double saldoTotal = 0;
    private double selic;

    public AtualizadorDeContas(double selic) {
        this.selic = selic;
    }

    public void roda(Conta c) {
        System.out.println("===============================");
        System.out.println("Saldo anterior: " + c.getSaldo());
        c.atualiza(this.selic);
        System.out.println("Saldo atualizado: " + c.getSaldo());
        this.saldoTotal += c.getSaldo();
    }

    public double getSaldoTotal() {
        return this.saldoTotal;
    }

    // outros métodos, colocar o getter para saldoTotal!
}

class TestaContas {
    public static void main(String[] args) {
        Conta c = new Conta();
        Conta cc = new ContaCorrente();
        Conta cp = new ContaPoupanca();

        c.deposita(1000); 
        cc.deposita(1000); 
        cp.deposita(1000);

        AtualizadorDeContas adc = new AtualizadorDeContas(0.01);

        adc.roda(c);
        adc.roda(cc);
        adc.roda(cp);

        System.out.println("Saldo Total: " + adc.getSaldoTotal());
    }

}
