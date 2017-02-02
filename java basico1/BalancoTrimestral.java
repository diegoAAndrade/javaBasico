class BalancoTrimestral{
	public static void main(String[] args){
		
		int gastosJaneiro = 15000;
		int gastosFevereiro = 23000;
		int gastosMarco = 17000;
		
		int gastosTrimestre = gastosJaneiro + gastosFevereiro + gastosMarco;
		float mediaTrimestral = gastosTrimestre / 3;
		
		System.out.println("O gasto trimestral foi de " + gastosTrimestre);
		System.out.println("O valor da média trimestral foi de  " + mediaTrimestral);
	}
}