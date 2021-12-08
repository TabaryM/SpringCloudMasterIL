# Rapport Spring cloud MicroServices

Objectif du TP : Créer et gérer des microservices avec Spring cloud.

## Service Métier
Le coeur de mon application est le projet BookService.
Il est le même que pour les projets précédents.
J'y ai cependant ajouté la classe InitDB qui initialise la base de données.

## Service de configuration
J'ai ajouté un service de configuration nommé BookConfigService.
Il permet de centraliser les configurations des microservices.
Les données sont partagées par via un repository git.

## Service de découverte
Pour observer les différentes instances des microservices en cours d'exécution,
j'ai mis en place un service de découverte dans le projet nommé BookDiscoveryService.
Il permet de savoir quels microservices sont en cours d'exécution.

## Service de proxy
J'ai commencé la création du service de proxy, mais je ne l'ai pas terminé.
Je pense avoir compris qu'il sert à répartir la charge des requêtes faites sur le service global entre tous les microservices.


## Problèmes rencontrés
Lors du lancement des multiples microservices métiers,
j'ai rencontré un problème de connexions concurrentielles à la base de données.
En effet tous les microservices cherchaient à se connecter à la base de données lors de l'exécution du programme InitDB.
J'ai résolu ce problème en retirant les paramètres de connexion à la bdd dans le fichier application.properties.
(Les lignes que j'ai retiré pour résoudre ce prolème sont commentées dans le fichier).
