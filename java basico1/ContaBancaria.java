class Conta {
	private int numero;
    private double saldo;
    private double limite;
	Cliente titular;
	private Data dataEntrada;
	private static int totalDeContas;
	
	Conta() {
        Conta.totalDeContas = Conta.totalDeContas + 1;
    }
	
	public Conta(int numero, double limite) {
		this(numero, limite, 0);
	}

	public Conta(int numero, double limite, double saldoInicial) {
		this.numero = numero;
		this.limite = limite;
		this.saldo = saldoInicial;
	}
	
	
	public int getNumero(){
		return this.numero;
	}
	public void setNumero(int _numero){
		this.numero = _numero;
	}
	public double getSaldo(){
		return this.saldo;
	}
	public void setSaldo(double _saldo){
		this.saldo = _saldo;
	}
	public double getLimite(){
		return this.limite;
	}
	public void setLimite(double _limite){
		this.limite = _limite;
	}
	public Cliente getTitular(){
		return this.titular;
	}
	public void setTitular(Cliente _titular){
		this.titular = _titular;
	}
	public Data getDataEntrada(){
		return this.dataEntrada;
	}
	public void setDataEntrada(Data _dataEntrada){
		this.dataEntrada = _dataEntrada;
	}
	public int getTotalDeContas() {
        return Conta.totalDeContas;
    }
		
	public boolean saca(double quantidade) {
		if (this.saldo > quantidade){
			this.saldo -= quantidade;
			return true;
		}
		else{
			return false;
		}
	}
	
	public void deposita(double quantidade) {
        
		this.saldo += quantidade;
	}
	
    public boolean transfere(Conta destino, double valor) {
        boolean retirou = this.saca(valor);
        if (retirou == false) {
            // não deu pra sacar!
            return false;
        }
        else {
            destino.deposita(valor);
            return true;
        }
    }
	public String DataComprovante(){
		return (String)(this.dataEntrada.getDia() + "/" + this.dataEntrada.getMes() + "/" + dataEntrada.getAno());
	}
}

class Cliente {
    private String nome;
    private String sobrenome;
    private String cpf;
	
	public String getNome(){
		return this.nome;
	}
	public void setNome(String _nome){
		this.nome = _nome;
	}
	public String getSobrenome(){
		return this.sobrenome;
	}
	public void setSobrenome(String _sobrenome){
		this.sobrenome = _sobrenome;
	}
	public String getCpf(){
		return this.cpf;
	}
	public void setCpf(String _cpf){
		this.cpf = _cpf;
	}
}
class Data{
	private int dia;
	private int mes;
	private int ano;
	
	public int getDia(){
		return this.dia;
	}
	public void setDia(int _dia){
		this.dia = _dia;
	}
	public int getMes(){
		return this.mes;
	}
	public void setMes(int _mes){
		this.mes = _mes;
	}
	public int getAno(){
		return this.ano;
	}
	public void setAno(int _ano){
		this.ano = _ano;
	}
	public Data(int dia, int mes, int ano) {
		if (! isDataViavel(dia, mes, ano)) {
			System.out.println("A data não existe!");
		}else{
			this.dia = dia;
			this.mes = mes;
			this.ano = ano;
		}
	}

	private boolean isDataViavel(int dia, int mes, int ano) {
		if (dia <= 0 || mes <= 0 || mes > 12 || ano <= 0) {
			return false;
		}

		int ultimoDiaDoMes = 31; // por padrao são 31 dias
		if (mes == 4 || mes == 6 || mes == 9 || mes == 11 ) {
			ultimoDiaDoMes = 30;
		} else if (mes == 2) {
			ultimoDiaDoMes = 28;
			if((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0))){
				ultimoDiaDoMes = 29;
			}
		}
		if (dia > ultimoDiaDoMes) {
			return false;
		}

		return true;
	}
}

class Programa {
    public static void main(String[] args) {
		Conta minhaConta = new Conta();
		Cliente c = new Cliente();
		minhaConta.setTitular(c);
		Data d = new Data(31,2,2016);
		minhaConta.setDataEntrada(d);
		
		minhaConta.titular.setNome("Duke");
        minhaConta.setSaldo(1000.0);

 		boolean consegui = minhaConta.saca(200);
		if (consegui) {
			System.out.println("Consegui sacar " + minhaConta.getSaldo() + " no dia " + minhaConta.DataComprovante());
		} else {
			System.out.println("Não consegui sacar no dia " + minhaConta.DataComprovante());
		}

        // deposita 500 reais
        minhaConta.deposita(500);
        System.out.println("o meu saldo é de " + minhaConta.getSaldo() + "no dia " + minhaConta.DataComprovante());
    }
}