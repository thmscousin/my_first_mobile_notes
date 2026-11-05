# ADR 0001 : le code vit côté Windows

**Statut :** accepté

## Contexte

L'environnement de travail mêle Windows, où Android Studio et le SDK sont installés, et WSL. Ouvrir depuis Android Studio un projet stocké dans WSL est fragile, et l'accès USB au téléphone passe par Windows.

## Décision

Le dépôt est dans `C:\Users\thmsc\AndroidStudioProjects\my_first_mobile_notes`. Gradle tourne avec le JDK Windows d'Android Studio. Git et `gh` tournent dans WSL, sur le même dossier via `/mnt/c`.

## Conséquences

- Il n'y a qu'un seul SDK à maintenir, et Android Studio, l'USB et l'émulateur fonctionnent nativement.
- Le système de fichiers Windows n'a pas de bit exécutable, d'où `core.fileMode=false`. Le bit de `gradlew` est enregistré explicitement dans Git pour la CI Linux.
- `.gitattributes` force LF sur `gradlew` et CRLF sur les `.bat`, sinon l'un des deux scripts casserait sur son OS.
