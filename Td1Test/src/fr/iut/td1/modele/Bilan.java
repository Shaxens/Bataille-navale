package fr.iut.td1.modele;

import fr.iut.td1.miscs.Observable;

public class Bilan extends Observable {
	
	private String name;

	public String getName() {
		return name;
	}

	public Bilan() {
		super();
		System.out.println("dans constructeur bilan");
	}

	public void setChange() {
		System.out.println("dans méthode setChange .. le bilan est à jour ...");
		this.notify1();
	}
	
	public void setName(String name) {
		System.out.println("Je modifie le nom de mon bilan");
		this.name = name;
	}

}
