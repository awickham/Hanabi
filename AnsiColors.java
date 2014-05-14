import org.fusesource.jansi.*;

public class AnsiColors {
	private static Ansi ansi = new Ansi();
	public static Ansi getColor(String color) {
		switch (color) {
			case "Red": return ansi.fg(Ansi.Color.RED);
			case "White": return ansi.fg(Ansi.Color.WHITE);
			case "Blue": return ansi.fg(Ansi.Color.BLUE);
			case "Green": return ansi.fg(Ansi.Color.GREEN);
			case "Yellow": return ansi.fg(Ansi.Color.YELLOW);
			default: return ansi.fg(Ansi.Color.WHITE);
		}
	}
	public static void printStringInColor(String s, String color) {
		AnsiConsole.out.print(getColor(color));
		System.out.println(s);
		AnsiConsole.out.print(ansi.fg(Ansi.Color.WHITE));
	}
}