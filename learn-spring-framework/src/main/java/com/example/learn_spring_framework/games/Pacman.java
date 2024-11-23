package com.example.learn_spring_framework.games;

public class Pacman implements GamingConsole{

	@Override
	public void up() {
		System.out.println("packman jump");
	}

	@Override
	public void down() {
		System.out.println("packman down");	
	}

	@Override
	public void left() {
		System.out.println("packman left");	
	}

	@Override
	public void right() {
		System.out.println("packman right");
	}
	

}
