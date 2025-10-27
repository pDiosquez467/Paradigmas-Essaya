/**
 * listaDuplicada(L)
 *
 * Indica si una lista está compuesta por dos bloques consecutivos
 * de los mismos elementos.
 *
 * @param L: la lista a verificar.
 *
 * @example
 * % listaDuplicada([a, b, c, a, b, c])
 * 	   true
 */
listaDuplicada(L) :- append(X, X, L).