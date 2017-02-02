class Turma{
	Aluno[] alunos;
	
	void ImprimeNotas(){
		for(int i = 0; i < this.alunos.length; i++){
			Aluno aluno = this.alunos[i];
			if(aluno == null) continue;
			System.out.println(aluno.nota);
		}
	}
}
class Aluno{
	String nome;
	int nota;
}
class TesteDaTurma{
	
	public static void main (String[] args){
		
		Turma fj11 = new Turma();
		fj11.alunos = new Aluno[10];
		
		fj11.alunos[0] = new Aluno();
		fj11.alunos[0].nome = "Mauricio";
		fj11.alunos[0].nota = 9;
		
		fj11.alunos[1] = new Aluno();
		fj11.alunos[1].nome = "Marcelo";
		fj11.alunos[1].nota = 5;
		
		fj11.alunos[2] = new Aluno();
		fj11.alunos[2].nome = "Adriano";
		fj11.alunos[2].nota = 7;
		
		fj11.ImprimeNotas();	
	}
}