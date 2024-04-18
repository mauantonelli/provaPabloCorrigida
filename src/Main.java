import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Categoria programacao = new Categoria("Programação");

        Curso java = new Curso("Java", 400, 30, programacao);
        Curso python = new Curso("Python", 200, 30, programacao);
        programacao.inserirCursos(java, python);

        Categoria bancoDeDados = new Categoria("Banco de Dados");
        Curso postgresql = new Curso("PostgreSQL", 500, 60, bancoDeDados);
        bancoDeDados.inserirCursos(postgresql);

        System.out.println("\nCursos da categoria " + programacao.getNome());
        programacao.exibirCursosPorCategoria();

        Instrutor instrutor = new Instrutor("54321", "Instrutor B", "333", "8888-8888");

        Turma turma1 = new Turma("T3",
                LocalDate.of(2024, 3, 15),
                LocalDate.of(2024, 4, 15),
                java, instrutor);

        Turma turma2 = new Turma("T4",
                LocalDate.of(2024, 3, 15),
                LocalDate.of(2024, 4, 15),
                postgresql, instrutor);

        instrutor.inserirTurmas(turma1, turma2);

        System.out.println("\nCursos do instrutor " + instrutor.getNome());
        for (Curso c : instrutor.obterCursos())
            System.out.println(c);

        Aluno aluno = new Aluno("888", "João", "joao@joao.com");

        Matricula m1 = new Matricula(8.5, 150, turma1, aluno);
        Matricula m2 = new Matricula(9.0, 150, turma2, aluno);
        aluno.inserirMatriculas(m1, m2);

        System.out.println("\nTotal gasto por " + aluno.getNome() + ": " + aluno.calcularTotalGasto());

        System.out.println("\nCursos do aluno " + aluno.getNome());
        for (Curso c : aluno.obterCursos())
            System.out.println(c);

        List<Pessoa> lista = new ArrayList<>();
        lista.add(instrutor);
        lista.add(aluno);
        System.out.println("\nPolimorfismo: ");
        for (Pessoa p : lista) {
            System.out.println("Cursos de " + p.getNome());
            for (Curso c : p.obterCursos())
                System.out.println(c);
        }
    }
}
