/**
 * traduccion(Aleman, Espanol)
 *
 * Base de datos de traducción de números del alemán al español.
 *
 * @param Aleman   El número en alemán (átomo, e.g., 'eins').
 * @param Espanol  El número en español (átomo, e.g., 'uno').
 *
 * @bug Actualmente, solo soporta números del 1 al 9.
 * @see traduccionLista/2
 */
traduccion(eins, uno).
traduccion(zwei, dos).
traduccion(drei, tres).
traduccion(vier, cuatro).
traduccion(fuenf, cinco).
traduccion(sechs, seis).
traduccion(sieben, siete).
traduccion(acht, ocho).
traduccion(neun, nueve).

/**
 * traduccionLista(ListaAleman, ListaEspanol)
 *
 * Produce la traducción de una lista de números entre alemán y español.
 * Este predicado traduce cada elemento de la primera lista usando traduccion/2
 * y unifica el resultado con la segunda lista.
 *
 * @param ListaAleman   Lista de átomos con números en alemán (Entrada).
 * @param ListaEspanol  Lista de átomos con números en español (Salida, o Entrada/Salida).
 *
 * @tbd  Considerar soporte para listas heterogéneas (números y otros términos).
 *
 * @example
 * ?- traduccionLista([eins, zwei, drei], L).
 * L = [uno, dos, tres].
 *
 * @example
 * ?- traduccionLista(L, [uno, dos]).
 * L = [eins, zwei].
 *
 * @license GPL
 */
traduccionLista([], []).
traduccionLista([N|Ns], [E|Es]) :-
    traduccion(N, E), traduccionLista(Ns, Es).