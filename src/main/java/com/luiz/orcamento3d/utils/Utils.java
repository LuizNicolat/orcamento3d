package com.luiz.orcamento3d.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

	public static String convertLocalDateToString(LocalDate date) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return date.format(fmt);
	}

	public static String convertMinutesToHoursAndMinutes(int minutes_) {
		// Conversão de minutos para horas de impressão
		int hours = minutes_ / 60;
		int minutes = minutes_ % 60;
		// System.out.printf("%d:%02d", hours, minutes);

		return hours + ":" + minutes;
	}

	public static double convertMinutesToHoursAndMinutesWithDot(int minutes_) {
		// Conversão de minutos para horas de impressão
		int hours = minutes_ / 60;
		int minutes = minutes_ % 60;
		// System.out.printf("%d:%02d", hours, minutes);

		return Double.valueOf(hours + "." + minutes);
	}

	public static double calculateKilowatsPerMinutes(int potency, int minutes) {

		double totalKw = (potency * convertMinutesToHoursAndMinutesWithDot(minutes) / 1000);
		return totalKw;
	}

	public static double totalValueFromKwUsed(int potency, int minutes) {

		return convertMinutesToHoursAndMinutesWithDot(minutes) * calculateKilowatsPerMinutes(potency, minutes);
	}
}
