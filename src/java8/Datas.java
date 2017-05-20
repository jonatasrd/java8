package java8;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {

	public static void main(String[] args) {

		LocalDate agora = LocalDate.now();
		System.out.println(agora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		// Crie um LocalDate para representar o dia 25 de Janeiro de 2099.
		LocalDate futuro = LocalDate.of(2099, 1, 25);

		Period periodo = Period.between(agora, futuro);
		System.out.println(periodo.getYears());
	}

}
