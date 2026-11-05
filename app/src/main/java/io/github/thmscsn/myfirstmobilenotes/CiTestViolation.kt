package io.github.thmscsn.myfirstmobilenotes

import javax.crypto.Cipher

// Test de la CI, à retirer avant fusion : formatage invalide et algorithme faible.
fun ci_test_violation(): Cipher { return Cipher.getInstance("DES") }
