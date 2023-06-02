package app;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {

	public static void main(String[] args) {
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		LocalDate d01 = LocalDate.now();
		LocalDateTime d02 = LocalDateTime.now();
		Instant d03 = Instant.now();

		LocalDate d04 = LocalDate.parse("2023-05-31");
		LocalDateTime d05 = LocalDateTime.parse("2023-05-31T23:30:26");
		Instant d06 = Instant.parse("2023-05-31T23:30:26Z");
		Instant d07 = Instant.parse("2023-05-31T23:30:26-03:00");

		LocalDate d08 = LocalDate.parse("31/05/2023", fmt1);
		LocalDateTime d09 = LocalDateTime.parse("31/05/2023 23:30", fmt2);

		LocalDate d10 = LocalDate.of(2023, 5, 31);
		LocalDateTime d11 = LocalDateTime.of(2023, 5, 31, 23, 30);

		System.out.println("d01 = " + d01);
		System.out.println("d02 = " + d02);
		System.out.println("d03 = " + d03);
		System.out.println("d04 = " + d04);
		System.out.println("d05 = " + d05);
		System.out.println("d06 = " + d06);
		System.out.println("d07 = " + d07);
		System.out.println("d08 = " + d08);
		System.out.println("d09 = " + d09);
		System.out.println("d10 = " + d10);
		System.out.println("d11 = " + d11);
		System.out.println();

		LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
		LocalDate r2 = LocalDate.ofInstant(d06, ZoneId.of("Portugal"));
		LocalDateTime r3 = LocalDateTime.ofInstant(d06, ZoneId.systemDefault());
		LocalDateTime r4 = LocalDateTime.ofInstant(d06, ZoneId.of("Portugal"));

		// instanciando uma nova data com menos ( ) dias
		LocalDate pastWeekLocalDate = d04.minusDays(7);
		// instanciando uma nova data com mais ( ) dias
		LocalDate nextWeekLocalDate = d04.plusDays(7);

		// instanciando uma nova hora com menos ( ) hora
		LocalDateTime pastWeekLocalDateTime = d05.minusDays(7);
		// instanciando uma nova hora com mais ( ) hora
		LocalDateTime nextWeekLocalDateTime = d05.plusDays(7);

		Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
		Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

		// calcula tempo de duração
		Duration t1 = Duration.between(pastWeekLocalDate.atStartOfDay(), d04.atTime(0, 0));
		Duration t2 = Duration.between(pastWeekLocalDateTime, d05);
		Duration t3 = Duration.between(pastWeekInstant, d06);
		Duration t4 = Duration.between(d06, pastWeekInstant);

		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2);
		System.out.println("r3 = " + r3);
		System.out.println("r4 = " + r4);
		System.out.println();

		System.out.println("d4 dia = " + d04.getDayOfMonth());
		System.out.println("d04 mês = " + d04.getMonthValue());
		System.out.println("d04 ano = " + d04.getYear());
		System.out.println();

		System.out.println("d05 hora = " + d05.getHour());
		System.out.println("d05 hora = " + d05.getMinute());
		System.out.println();

		System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
		System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

		System.out.println("pastWeekLocalDateTime = " + pastWeekLocalDateTime);
		System.out.println("nextWeekLocalDateTime = " + nextWeekLocalDateTime);

		System.out.println("pastWeekInstant = " + pastWeekInstant);
		System.out.println("nextWeekInstant = " + nextWeekInstant);
		System.out.println("t1 = " + t1.toDays());
		System.out.println("t2 = " + t2.toDays());
		System.out.println("t3 = " + t3.toDays());
		System.out.println("t4 = " + t4.toDays());

	}
}
