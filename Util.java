import org.fusesource.jansi.AnsiConsole;

public class Util {
	private static final String ANSI_CLS = "\u001b[2J";
	private static final String ANSI_HOME = "\u001b[H";
	public static void clearScreen() {
        AnsiConsole.out.print(ANSI_CLS + ANSI_HOME);
        AnsiConsole.out.flush();
		AnsiConsole.out.print("");
	}
}