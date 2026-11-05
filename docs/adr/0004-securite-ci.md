# ADR 0004 : sécurité de la CI

**Statut :** accepté

## Contexte

Le dépôt est public, et il produira plus tard des APK signés. Une action GitHub ou un wrapper Gradle compromis pourrait donc atteindre l'app installée sur le téléphone.

## Décision

- **Actions épinglées par SHA.** Un tag comme `v7` peut être déplacé par quiconque contrôle l'action, alors qu'un SHA ne change pas. La version reste en commentaire pour la lisibilité.
- **Permissions minimales.** `GITHUB_TOKEN` n'a que `contents: read` par défaut. Seul le job CodeQL ajoute `security-events: write`.
- **Validation du wrapper Gradle** à chaque PR, car `gradle-wrapper.jar` est un binaire exécuté en CI et difficile à relire.
- **Dependabot** propose chaque semaine les mises à jour de Gradle et des actions, SHA compris.
- **CodeQL** analyse le code Kotlin à chaque PR et chaque semaine.
- **Ruleset sur `main`** : PR et checks `build` et `analyze` verts obligatoires, squash merge uniquement, sans contournement possible. Une alerte CodeQL de sévérité élevée bloque aussi la fusion, car le job `analyze` reste vert même quand il trouve une faille.

## Conséquences

- Aucune approbation n'est exigée, car le projet n'a qu'un seul développeur et GitHub interdit d'approuver sa propre PR. Les checks automatiques restent le seul garde-fou.
- Le job de PR n'a accès à aucun secret. Les secrets de signature n'arriveront qu'à la phase 3, dans un environnement protégé.
