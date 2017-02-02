class Funcionario{
	private String nome;
	private String departamento;
	private double salario;
	private String dataInicio;
	private String certidaoIdentidade;
	private int falta;
	private int advertencia;
	private int indisciplina;
	private static int identificador;
	
	public static int getIdentificador(){
		return Funcionario.identificador;
	}
	
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nomeFuncionario){
		this.nome = nomeFuncionario;
	}
	public double getSalario(){
		return this.salario;
	}
	public void setSalario(double salarioFuncionario){
		this.salario = salarioFuncionario;
	}
	
	public Funcionario(){
		Funcionario.identificador++;
		
	}
	public Funcionario(String nomeFuncionario){
		this.nome = nomeFuncionario;
		Funcionario.identificador++;
	}		
	
	public double calculaGanhoAnual(){
		return this.salario * 12;
	}
	void recebeAumento(String argumento){
		if(argumento == "bom"){
			this.salario *= 1.20;
		}
	}
	
	public void pontosAdvertencia(int penalidade){
		this.advertencia += penalidade;
	}
	
	public void Mostra(){
		System.out.println("salario atual:" + this.salario);
        System.out.println("ganho anual:" + this.calculaGanhoAnual());
	}
}

class Empresa{
	private String nome;
	private String cnpj;
	private String endereco;
	Funcionario empregados[];
	private int livre = 0;
	
	public Empresa(int numFuncionario){
		this.empregados = empregados;
	}
	public Empresa(){}
	
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nomeEmpresa){
		this.nome = nomeEmpresa;
	}
	public String getCnpj(){
		return this.cnpj;
	}
	public void setCnpj(String cnpjEmpresa){
		this.cnpj = cnpjEmpresa;
	}
	public String getEndereco(){
		return this.endereco;
	}
	public void setEndereco(String enderecoEmpresa){
		this.endereco = enderecoEmpresa;
	}
    public Funcionario getFuncionario (int posicao) {
        return this.empregados[posicao];
    }
	public void setEmpregados(Funcionario empregadosEmpresa, int posicao){
		this.empregados[posicao] = empregadosEmpresa;
	}
	
	public void Adicionar(Funcionario f){
		this.empregados[this.livre] = f;
		this.livre++;
	}
	
	public void MostraTodasInformacoes(){
	
		for(int i = 0; i < this.livre; i++){
			this.empregados[i].Mostra();
		}
	}
	/*
	public boolean Contem(Funcionario f){
		for(int i = 0; i< this.livre; i++){
			if(this.empregados[i].nome == f.getNome()){
				return true;
				break;
			}
		}
		return false;
	}
	*/
}

class TestaFuncionario {

    public static void main(String[] args) {
		
		Empresa empresa = new Empresa();
		empresa.empregados = new Funcionario[10];
		
		for (int i = 0; i < 5; i++) {
			Funcionario f = new Funcionario();
			f.setSalario(1000 + i * 100);
			empresa.Adicionar(f);
		}
		empresa.MostraTodasInformacoes();
		
    }
}