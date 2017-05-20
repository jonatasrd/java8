package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Curso {

	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}

public class TestaCurso {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));

		cursos.sort(Comparator.comparingInt(Curso::getAlunos));

		cursos.stream().filter(c -> c.getAlunos() > 50).forEach(c -> System.out.println(c.getAlunos()));

		Stream<String> nomes = cursos.stream().map(Curso::getNome);

		nomes.forEach(System.out::println);

		cursos.stream().filter(c -> c.getAlunos() > 50).map(c -> c.getAlunos()).forEach(x -> System.out.println(x));

		// mesma coisa que o anterior usando method reference
		cursos.stream().filter(c -> c.getAlunos() > 50).map(Curso::getAlunos).forEach(System.out::println);

		cursos.stream().filter(c -> c.getAlunos() > 50).findFirst();

		cursos.stream().mapToInt(c -> c.getAlunos()).average();

		List<Curso> cursosFiltrados = cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList());

	}
}
