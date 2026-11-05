# my_first_mobile_notes

App de notes Android (Kotlin, Compose, Material 3). L'objectif premier est pédagogique : suivre les standards de l'écosystème Android et expliquer les choix.

## Environnement

- Le code est côté Windows. Sous PowerShell, `git` et `gh` sont absents : ils tournent dans WSL (`wsl.exe -d Ubuntu`, dépôt vu en `/mnt/c/Users/thmsc/AndroidStudioProjects/my_first_mobile_notes`).
- Gradle tourne côté Windows avec le JDK d'Android Studio : `$env:JAVA_HOME = "C:\Program Files\Android\Android Studio\jbr"`, puis `.\gradlew.bat <tâche>`.
- `adb` : `$env:LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe`.

Vérifications à lancer avant une PR : `.\gradlew.bat ktlintCheck detekt lintDebug testDebugUnitTest assembleDebug`. `ktlintFormat` corrige le formatage. Si ktlint signale un fichier supprimé, c'est son cache incrémental : lancer `clean`.

## Identifiants

- La variante debug s'installe sous `io.github.thmscsn.myfirstmobilenotes.debug`, séparée de la variante release.

- `applicationId` et package : `io.github.thmscsn.myfirstmobilenotes`.
- Compte et dépôt GitHub : `thmscousin/my_first_mobile_notes`. Ce n'est pas le même nom que le package, et c'est voulu (voir `docs/adr/0002`).

## Conventions

- Tout passe par une PR de petite taille, fusionnée en squash. Pas de commit direct sur `main`.
- Messages en Conventional Commits, avec l'adresse GitHub `noreply` (configurée localement dans le dépôt).
- Les choix importants sont notés dans `docs/adr/`.
- Les actions GitHub sont épinglées par SHA, avec la version en commentaire.
- Ne jamais désinstaller ni écraser la variante release du téléphone sans demander : elle contiendra les vraies notes.
