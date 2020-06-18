package Tierlexikon.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_ADDPeer;

public class ConsoleUtils {
	private Scanner s;
	public ConsoleUtils() {
		s = new Scanner(System.in);
	}
	
	public int selectChoice(String[] choices) {
		for (String choice : choices)
			print(choice);
		print("Eingabe (1-" + choices.length + "):");
		while(true) {
			String ans = s.nextLine();
			try {
				int i = Integer.parseInt(ans);
				if (i < 1 || i > choices.length) {
					error("Bitte w�hlen Sie eine Zahl zwischen 1 und " + choices.length);
					continue;
				}
				return i;
			} catch (NumberFormatException e) {
				error("Nur Zahlenwerte erlaubt!");
				continue;
			}
		}
	}
	public boolean inputBool() {
		print("Eingabe (J = Ja / N = Nein):");
		String ans = s.nextLine();
		if (ans.toUpperCase().equals("J"))
			return true;
		else if (ans.toUpperCase().equals("N"))
			return false;
		error("W�hlen Sie J (Ja) oder N (Nein)!");
		return inputBool();
	}
	public int inputInt(int min, int max) {
		print("Eingabe (" + min + " - " + max + "):");
		String ansStr = s.nextLine();
		try {
			int ans = Integer.parseInt(ansStr);
			if (ans < min) {
				error("Eingabe zu klein (Minimum: " + min + ")");
				return inputInt(min, max);
			} else if (ans > max) {
				error("Eingabe zu gro� (Maximum: " + max + ")");
				return inputInt(min, max);
			}
			return ans;
		} catch (NumberFormatException e) {
			error("Geben Sie eine Zahl ein!");
			return inputInt(min, max);
		}
	}
	public char inputChar(char[] allowed) {
		print("Eingabe " + Arrays.toString(allowed) + ":");
		String ans = s.nextLine();
		if (ans.length() == 1 && new String(allowed).toUpperCase().contains(ans.toUpperCase()))
			return ans.toUpperCase().charAt(0);
		error("Geben Sie genau ein Zeichen ein! Erlaubt: " + allowed.toString());
		return inputChar(allowed);
	}
	public String inputString(int minLength, int maxLength) {
		print("Eingabe: ");
		String ans = s.nextLine();
		if(ans.length() > maxLength) {
			error("Maximal " + maxLength + " Zeichen erlaubt!");
			return inputString(minLength, maxLength);
		} else if (ans.length() < minLength) {
			error("Mindestens " + minLength + " Zeichen eingeben!");
			return inputString(minLength, maxLength);
		}
		return ans;
	}
	public LocalDate inputDate() {
		String pattern = "yyyy-MM-dd";
		DateTimeFormatter format = DateTimeFormatter.ofPattern(pattern);
		print("Datum eingeben (" + pattern + "):");
		String ans = s.nextLine();
		LocalDate date;
		try {
			date = LocalDate.parse(ans, format);
			if (date != null)
				return date;
			error("Ung�ltiges Format!");
			return inputDate();
		} catch (DateTimeParseException e) {
			error("Ung�ltiges Format!");
			return inputDate();
		}		
	}
	public void print(String s) {
		System.out.println(s);
	}
	public void error(String s) {
		System.err.println(s);
	}
	public boolean confirm() {
		print("Sind Sie sicher? (J/N)");
		String ans = s.nextLine();
		if (ans.toUpperCase().equals("J"))
			return true;
		else if (ans.toUpperCase().equals("N"))
			return false;
		error("Ung�ltige Eingabe! W�hlen sie 'J' (Ja) oder 'N' (Nein).");
		return confirm();
	}
	
}
