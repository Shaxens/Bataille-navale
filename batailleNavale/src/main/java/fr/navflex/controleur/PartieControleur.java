package fr.navflex.controleur;

import fr.navflex.modele.joueur.Joueur;
import fr.navflex.modele.partie.Partie;
import fr.navflex.modele.partie.Tour;
import fr.navflex.vue.Moniteur;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PartieControleur {
    // ATTRIBUTS
    Moniteur moniteur = new Moniteur();
    JoueurControleur controleur = new JoueurControleur();

    // OUTILS INPUT
    public int inputEntier()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException ime) {
                String mauvaisChoix = scanner.next();
                this.moniteur.creerMessage("Erreur : Saisie invalide, veuillez saisir un entier : ");
                continue;
            }
        }
    }

    public int inputEntierPositif()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            try {
                int input = scanner.nextInt();
                if (input >= 0) {
                    return input;
                }
                else throw new IllegalArgumentException("Erreur : Saisie invalide, veuillez saisir un entier superieur a 0 : ");
            } catch (Exception e) {
                String mauvaisChoix = scanner.next();
                this.moniteur.creerMessage("Erreur : Saisie invalide, veuillez saisir un entier : ");
                continue;
            }
        }
    }

    public int inputChoixListeObjetSansId(ArrayList liste)
    {
        while (true)
        {
            try {
                int choixDansListe = inputEntierPositif();
                if (liste.size() < choixDansListe || choixDansListe < 1)
                {
                    throw new IllegalArgumentException("Erreur : " + choixDansListe + " n est pas une option de la liste.");
                }
                return choixDansListe;
            } catch (InputMismatchException | IllegalArgumentException ime) {
                this.moniteur.creerMessage(ime.getMessage());
                continue;
            }
        }
    }

    // METHODES
    public Partie initialiserPartie()
    {
        moniteur.creerMessage("\nNouvelle partie !\nVeuillez selectionner le nombre de Joueur : ");
        int nombreJoueur = inputEntierPositif();
        while (nombreJoueur < 2)
        {
            if (nombreJoueur == 0) {
                moniteur.creerMessage("Si il n'y a aucun joueur on va s'ennuyer, faites un choix plus raisonnable :  ");
            }
            else if (nombreJoueur == 1) {
                moniteur.creerMessage("Ah bonne idee c'est valide ! un mode contre moi-meme arrive bientot !\nMais pour l'instant jouez plutot avec au moins un ami, combien d'ami du coup ? :");
            }
            nombreJoueur = inputEntierPositif();
        }


        return new Partie(1,new ArrayList<Joueur>(), new ArrayList<Tour>());
    }
}
