class EmpregadoDaFaculdade {
	private String nome;
	private double salario;
	double getGastos() {
		return this.salario;
	}
	String getInfo() {
		return "nome: " + this.nome + " com salário " + this.salario;
	}
	 // métodos de get, set e outros
}
class ProfessorDaFaculdade extends EmpregadoDaFaculdade {
	private int horasDeAula;
	double getGastos() {
		return this.getSalario() + this.horasDeAula * 10;
	}
	String getInfo() {
		String informacaoBasica = super.getInfo();
		String informacao = informacaoBasica + " horas de aula: " 
												+ this.horasDeAula;
		return informacao;
	}
	// métodos de get, set e outros que forem necessários
}
class GeradorDeRelatorio {
	public void adiciona(EmpregadoDaFaculdade f) {
		System.out.println(f.getInfo());
		System.out.println(f.getGastos());
	}
}
class Reitor extends EmpregadoDaFaculdade {
	 // informações extras
	String getInfo() {
		return super.getInfo() + " e ele é um reitor";
	}
	 // não sobrescrevemos o getGastos!!!
}