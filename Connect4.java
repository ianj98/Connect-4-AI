/**
 * Connect4.java
 * 
 * Controller that plays the connect 4 game. 
 * @author Delos Chang
 *
 */

public class Connect4 {
	public static void main(String [] args){
		int COMP_DEPTH = 5; // set the depth

		// Hold the view methods. 
		Connect4View view = new Connect4ViewGraphical();

		Player [] players = new Player[2];

		// Initialize the game
			// Computer - for computer
			// Professor - for Prof. Drysdale's AI
		
		String playerName = view.getAnswer("Enter the name of the first player." +
		"\n(Include 'Computer' if you want a computer player) ");
		
		if (playerName.contains("Computer")){
			players[0] = new ComputerConnect4Player(playerName, COMP_DEPTH);
		} else if (playerName.contains("Professor")){ 
			players[0] = new ComputerPlayerABPlus(playerName, 16);
		} else { 
			players[0] = new Connect4HumanPlayer(playerName);
		}
		
		playerName = view.getAnswer("Enter the name of the second player." +
		"\n(Include 'Computer' if you want a computer player) ");
		
		if (playerName.contains("Computer")){
			players[1] = new ComputerConnect4Player(playerName, COMP_DEPTH);
		} else if (playerName.contains("Professor")){ 
			players[1] = new ComputerPlayerABPlus(playerName, 16);
		} else { 
			players[1] = new Connect4HumanPlayer(playerName);
		}
		
		Connect4Game state = new Connect4Game(0, players); 
		
		view.display(state);
		
		// Hold current game state
		while (!state.gameIsOver()){
			System.out.println("Make a Move");
			int move = state.getPlayerToMove().getMove(state, view);
			
			state.makeMove(move);
			view.display(state);
		}
		
		// The game is over
		
		
		
	}
}
