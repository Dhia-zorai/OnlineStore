# Online Store 3

Une application web simple de gestion de stock développée avec **Spring Boot** et **Thymeleaf**. Ce projet permet de gérer un catalogue de produits (CRUD) avec une persistance en mémoire.

##  Fonctionnalités

- **Affichage** : Liste complète des produits avec détails (nom, code, prix, quantité).
- **Ajout** : Formulaire de création de nouveaux produits avec validation des données.
- **Modification** : Mise à jour des informations d'un produit existant.
- **Suppression** : Retrait de produits du catalogue.

##  Technologies utilisées

- **Java 21**
- **Spring Boot 4.x** (Web MVC, Validation)
- **Thymeleaf** (Moteur de templates)
- **Lombok** (Génération de code boilerplate)
- **Maven** (Gestionnaire de dépendances)

##  Installation et Lancement

1. Cloner le projet :
   ```bash
   git clone <url-du-repo>
   ```

2. Lancer l'application avec Maven :
   ```bash
   ./mvnw spring-boot:run
   ```

3. Accéder à l'application :
   Ouvrez votre navigateur sur [http://localhost:8080/products](http://localhost:8080/products)

##  Structure du projet

- `src/main/java/.../web/controllers` : Logique de navigation et gestion des requêtes.
- `src/main/java/.../web/models` : Entités et formulaires de données.
- `src/main/resources/templates` : Vues HTML (Thymeleaf).
