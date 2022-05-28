package fr.navflex.controleur;

import fr.navflex.vue.Moniteur;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputControleur {
    // ATTRIBUTS
    private final Moniteur moniteur = new Moniteur();

    // OUTILS INPUT
    public String inputString()
    {
        Scanner scanner = new Scanner(System.in);

        while (true)
        {
            try {
                return scanner.next();
            } catch (InputMismatchException ime) {
                String mauvaisChoix = scanner.next();
                this.moniteur.creerMessage("Erreur : Saisie invalide : ");
                continue;
            }
        }
    }

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
}
