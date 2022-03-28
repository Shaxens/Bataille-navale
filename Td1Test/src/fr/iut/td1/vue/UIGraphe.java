package fr.iut.td1.vue;

import fr.iut.td1.interfaces.IObserver;
import fr.iut.td1.miscs.Observable;
import fr.iut.td1.modele.Bilan;

public class UIGraphe implements IObserver {

	private int num;

	public int getNum() {
		return num;
	}

	public UIGraphe(int num) {
		this.num = num;
	}

	@Override
	public void update(Observable obj) {
		System.out.println("Je suis dans graphe.");
		Bilan bilan = (Bilan) obj;
		System.out.println("bilan n° " + obj.getNum());
		System.out.println("Son nom est " + bilan.getName());
		System.out.println("dans methode update du graphe N° " + num);
	}
}
