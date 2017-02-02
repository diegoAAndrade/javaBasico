class Funcionario {
	protected String nome;
	protected String cpf;
	protected double salario;
	
	// métodos devem vir aqui
	public double getBonificacao() {
		return this.salario * 0.10;
	}
}

class Gerente extends Funcionario {
	int senha;
	int numeroDeFuncionariosGerenciados;

	public boolean autentica(int senha) {
		if (this.senha == senha) {
			System.out.println("Acesso Permitido!");
			return true;
		} else {
			System.out.println("Acesso Negado!");
			return false;
		}
	}
	
	public double getBonificacao() {
		return this.salario * 0.15;
	}

	// setter da senha omitido
}

class ControleDeBonificacoes {
	private double totalDeBonificacoes = 0;

	public void registra(Funcionario funcionario) {
		this.totalDeBonificacoes += funcionario.getBonificacao();
	}

	public double getTotalDeBonificacoes() {
		return this.totalDeBonificacoes;
	}
}

class TestaGerente {
	public static void main(String[] args) {
		Gerente gerente = new Gerente();

		// podemos chamar métodos do Funcionario:
		gerente.setNome("João da Silva");

		// e também métodos do Gerente!
		gerente.setSenha(4231);
		gerente.setSalario(5000.0);
		System.out.println(gerente.getBonificacao());

	    ControleDeBonificacoes controle = new ControleDeBonificacoes();

		Gerente funcionario1 = new Gerente();
		funcionario1.setSalario(5000.0);
		controle.registra(funcionario1);

		Funcionario funcionario2 = new Funcionario();
		funcionario2.setSalario(1000.0);
		controle.registra(funcionario2);

		System.out.println(controle.getTotalDeBonificacoes());
	}
}