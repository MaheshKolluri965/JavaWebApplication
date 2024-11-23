package com.example.learn_spring_framework;

import com.example.learn_spring_framework.games.GameRunner;
import com.example.learn_spring_framework.games.MarioGame;
import com.example.learn_spring_framework.games.Pacman;
import com.example.learn_spring_framework.games.SuperContra;

/* 
 * 
 var -> introduced in java10 (simplifies code)
     -> Allows the compiler to infer the type of the variable based on the value assigned.
 Coupling -> How much work is involved in changing something?
 Loose Coupling - we can achieve loose coupling using interfaces.
 
*/


public class App01GamingBasic {
	
	public static void main(String args[]) {
		
		//var game = new MarioGame();
		//var game = new SuperContra();
		var game = new Pacman();
		
		var gameRunner = new GameRunner(game);
		gameRunner.run();
		
	}

}
