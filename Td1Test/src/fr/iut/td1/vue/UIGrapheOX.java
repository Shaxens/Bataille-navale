package fr.iut.td1.vue;

import fr.iut.td1.interfaces.IObserver;
import fr.iut.td1.miscs.Observable;

public class UIGrapheOX implements IObserver {

	private int num;

	public int getNum() {
		return num;
	}

	public UIGrapheOX(int num) {
		this.num = num;
	}
	
	@Override
	public void update(Observable obj) {
		System.out.println("Je suis dans graphe OX.");
	}

}
