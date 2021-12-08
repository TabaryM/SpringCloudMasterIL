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

### Service de découverte
Pour observer les différentes instances des microservices en cours d'exécution,
j'ai mis en place un service de découverte dans le projet nommé BookDiscoveryService.
Il permet 

Problème rencontré :
connexion à la base de donnée concurrentielle impossible,
solution : commenter les lignes de connexion à la base de données
dans application.properties de bookServices.

Recherche de la dépendance Zuul (cherché sur mvnrepository.com
