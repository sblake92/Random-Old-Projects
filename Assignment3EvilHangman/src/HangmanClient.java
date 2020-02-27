import java.util.*;

public class HangmanClient {

	public static void main(String[] args) {
		String[] words = {"ally", "beta", "cool", "deal", "else", "flew",
				"good", "hope", "ibex"};
		List<String> dict = new ArrayList<String>(Arrays.asList(words));
		HangmanManager game = new HangmanManager(dict, 4, 7);
		helperDisplay(game);
		
		System.out.println(game.record('e'));
	}
	private static void helperDisplay(HangmanManager game) {
		System.out.println("guesses " + game.guessesLeft());
		System.out.println("guessed " + game.guesses());
		System.out.println("current " + game.pattern());
		System.out.println("words: " + game.words());
	}
}
