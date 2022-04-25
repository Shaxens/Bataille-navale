package fr.navflex.joueur;

public class Joueur {

    // Attributs
    private int id;
    private String nom;

    // Getter
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Constructeur
    public Joueur (int id,String nom) {
        this.setId(id);
        this.setNom(nom);
    }

}
