# Bataille navale [![java version](https://img.shields.io/badge/Java-17-success)](https://img.shields.io/badge/Java-17-success) [![prerelease version](https://img.shields.io/badge/Pre--release-v0.0.1-orange)](https://img.shields.io/badge/Pre--release-v0.0.1-orange) [![progress status](https://img.shields.io/badge/-In%20progress-informational)](https://img.shields.io/badge/-In%20progress-informational)

![Logo NavFlex](/img/github/logo.png "NavFlex")

***Made by NavFlex***

Application logiciel permettant de jouer à la bataille navale à l'aide d'une invite de commande.

<details><summary><h2>Comment jouer</h2></summary>

  <p>La bataille navale se joue à 2 joueurs, chaque joueur positionne ses bateaux sur le plateau de jeu.</p>
  <blockquote>Les navires ne bougeront pas pendant la partie</blockquote>
  <p>Une fois tous les bateaux positionnés le jeu commence en tour par tour. Chaque joueur devra choisir une position où tirer pour atteindre les navires adverses. </p>
  <p>La partie se termine lorsqu'un des joueurs à perdu tout ses bateaux</p>

</details>

<details><summary><h2>Fonctionnement</h2></summary>
  
  <h3>Avant de jouer</h3>
  <p>Tout d'abord chaque joueur choisit un nom.</p>
  
  ```java
  Veuillez entrer le nom du joueur 1 : Goldorak
  Le nom du joueur 1 est Goldorak.
  ```
  
  <p>Une fois les positions des navires choisis, l'un après l'autre, les joueurs pourront choisir les cases où ils veulent tirer.</p>
  
  ```java
  -- Goldorak --
  En quelle position voulez-vous placer le Porte-Avions (A-J)(1-10) ? C5
  Votre Porte-Avions se trouve en C5.
  
  En quelle position voulez-vous placer le Croiseur (A-J)(1-10) ?
  ```
  
  <br>
  
  <h3>Comment tirer sur une position</h3>
  <p>Vous devriez voir cette ligne :</p>
  
  ```java
  En quel position souhaitez-vous tirer ?
  ```
  
  <p>Vous pourrez y répondre de cette façon : </p>
  
  ```java
  En quel position souhaitez-vous tirer ? C10
  ```
  
  <br>
  <h3>Score</h3>
  <p>Le score des joueurs sera calculé en fonction des bateaux restants et de leurs points de vie.</p>
  


</details>  


<details><summary><h2>Diagramme</h2></summary>
  
  ```mermaid
    graph TD;
    Tour-->Joueur;
    Joueur-->Flotte;
    Score-->Joueur;
    Score-->Flotte;
    Flotte-->Navire;
    Navire-->Coordonnées;
    TypeNavire-->Navire;
```
  
</details>


<details><summary><h2>Plateau de la bataille navale</h2></summary>
  <p align="center">  
    <img src="/img/github/bataille-navale.jpg">
  </p>
</details>
  
