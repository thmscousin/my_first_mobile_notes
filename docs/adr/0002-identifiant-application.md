# ADR 0002 : identifiant de l'application

**Statut :** accepté

## Contexte

L'`applicationId` identifie l'app sur le téléphone et sur Google Play. Il devient définitif après la première publication Play. La convention `io.github.<nom>` suppose en général que `<nom>` est le compte GitHub du propriétaire.

## Décision

L'identifiant est `io.github.thmscsn.myfirstmobilenotes`, sans underscores pour suivre la convention des packages Kotlin. Le dépôt reste sous le compte `thmscousin`.

## Conséquences

- Le préfixe ne correspond pas au compte GitHub qui héberge le code, et le compte `thmscsn` n'existe pas. Cela n'empêche ni le build ni la publication, mais un tiers pourrait créer ce compte.
- Une éventuelle publication sur Maven Central exigerait de prouver la propriété de ce nom. L'app n'est pas concernée, car seul un APK ou un AAB est distribué.
- Tout changement devra intervenir avant la première publication Play.
