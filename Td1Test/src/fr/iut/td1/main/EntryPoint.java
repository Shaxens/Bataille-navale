package fr.iut.td1.main;

import fr.iut.td1.modele.Bilan;
import fr.iut.td1.vue.UIGraphe;
import fr.iut.td1.vue.UIGrapheOX;

public class EntryPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("HELLO WORLD");
		System.out.println("-----------------------------");
		// Création du bilan :
		Bilan bilan = new Bilan();
		bilan.setNum(1);
		System.out.println("-----------------------------");
		// Création du graphe :
		UIGraphe graphe = new UIGraphe(1);
		UIGraphe graphe2 = new UIGraphe(2);
		UIGraphe graphe3 = new UIGraphe(3);
		UIGrapheOX graphe4 = new UIGrapheOX(4);
		// Je rejoute mon graphe en tant qu'observateur ...
		// Bilan est observé par UIGraphe :
		bilan.addObserver(graphe);
		bilan.addObserver(graphe2);
		bilan.addObserver(graphe3);
		bilan.addObserver(graphe4);
		bilan.setName("Toto");
		// Bilan envoie l'ordre de changement aux observateurs ..
		bilan.setChange();

	}
}
