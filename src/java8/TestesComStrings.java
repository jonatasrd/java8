package java8;

import static java.util.Comparator.comparing;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class TestesComStrings {

	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		lista.add("alura online");
		lista.add("casa do codigo");
		lista.add("caelum");

		Consumer<String> consumidor = new ImprimeNaLinha();
		ComparadorPorTamanho comparador = new ComparadorPorTamanho();

		lista.forEach(consumidor);
		lista.sort(comparador);
		System.out.println(lista);

		lista.forEach(new Consumer<String>() {
			@Override
			public void accept(String palavra) {
				System.out.println(palavra);
			}
		});

		System.out.println("\n\n");

		lista.forEach(palavra -> System.out.println(palavra));

		lista.forEach(System.out::println);

		List<String> palavras = new ArrayList<>();
		palavras.add("Jonatas");
		palavras.add("Raul");
		palavras.add("Fernando");

		palavras.sort(new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if (s1.length() < s2.length())
					return -1;
				if (s1.length() > s2.length())
					return 1;
				return 0;
			}
		});

		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		palavras.sort((s1, s2) -> s1.length() - s2.length());

		palavras.sort(Comparator.comparing(s -> s.length()));

		// com import static
		palavras.sort(comparing(String::length));
	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
	}

}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		if (s1.length() < s2.length())
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}