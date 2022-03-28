package fr.iut.td1.miscs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fr.iut.td1.interfaces.IObserver;

public abstract class Observable {

	// BLock de variables :
	private List<IObserver> obsersers;

	private int num;

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Observable() {
		// Initialisation de la collection :
		System.out.println("Dans constructeur de Observable");
		obsersers = new ArrayList<>();
	}

	// BLock de méthodes (public, protected, private) :
	public void notify1() {
		System.out.println("dans méthode notify1");
//		for (IObserver iObserver : obsersers) {
//			// Parcourir une collection
//			iObserver.update(this);
//		}
		Iterator<IObserver> it = this.obsersers.iterator();
		// Parcours de la liste de 'TOUS' les observateurs ...
		while (it.hasNext()) {
			// Le seul qui permet de parcourir une liste et
			// de modifier son contenu pendant son parcours.
			it.next().update(this);
		}
	}

	// Ajouter un observer à ma liste d'observers :
	public void addObserver(IObserver o) {
		this.obsersers.add(o);
	}
}
