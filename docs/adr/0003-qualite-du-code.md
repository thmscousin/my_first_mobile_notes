# ADR 0003 : outils de qualité du code

**Statut :** accepté

## Contexte

Trois outils couvrent des besoins différents, et tous sont des standards de l'écosystème Android :

- **ktlint** vérifie le formatage.
- **detekt** cherche les défauts de conception, comme une fonction trop longue ou trop complexe.
- **Android Lint** connaît la plateforme : ressources, API selon la version d'Android, accessibilité.

## Décision

- Les trois outils sont exécutés en CI, et toute erreur bloque la PR.
- ktlint utilise le style `android_studio`, pour rester cohérent avec le formateur de l'IDE.
- detekt est en version 2.0.0-alpha. La dernière version stable, 1.23.8, plante sur le JDK 25 qui fait tourner Gradle : son compilateur Kotlin embarqué ne sait pas lire cette version de Java.
- Les exceptions sont limitées à ce que Compose impose (PascalCase) et aux fichiers de thème.

## Conséquences

- Une alpha peut changer ses règles ou sa configuration d'une version à l'autre. Le risque reste limité, car detekt n'est pas embarqué dans l'APK : le pire cas est une CI à réparer.
- Il faudra passer à la 2.0 stable dès sa sortie.
- Le formatage se corrige automatiquement avec `.\gradlew.bat ktlintFormat`.
