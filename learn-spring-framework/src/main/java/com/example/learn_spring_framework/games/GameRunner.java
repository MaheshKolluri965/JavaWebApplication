package com.example.learn_spring_framework.games;

public class GameRunner {
	
	//private MarioGame game;
	private GamingConsole game;
	
	public GameRunner(GamingConsole game) { // Loose Coupling
		this.game = game;
	}

	public void run() {
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
	}
}
