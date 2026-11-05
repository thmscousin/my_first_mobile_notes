# my_first_mobile_notes

Application Android de notes, conçue pour un seul utilisateur sur un seul téléphone. Son but premier est d'apprendre l'écosystème Android : développement, tests, CI/CD et publication.

Le projet en est à ses débuts : l'app n'affiche encore qu'un écran d'exemple.

**Fonctions prévues :** notes, catégories, couleurs, tags, épingles et recherche. L'app ne demandera pas la permission `INTERNET`, donc les notes ne pourront pas quitter le téléphone par le réseau.

## Stack

Kotlin, Jetpack Compose et Material 3, avec Gradle Kotlin DSL. Compatible à partir d'Android 8.0 (API 26).

## Démarrer

Prérequis : Android Studio, qui fournit le SDK et le JDK.

```powershell
# Sous Windows, si JAVA_HOME n'est pas défini
$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"

.\gradlew.bat assembleDebug      # compile l'APK de debug
.\gradlew.bat testDebugUnitTest  # lance les tests unitaires
.\gradlew.bat installDebug       # installe l'app sur le téléphone connecté
```

## Documentation

Les choix d'architecture et d'outillage sont expliqués dans [docs/adr/](docs/adr/).

## Licence

[MIT](LICENSE)
