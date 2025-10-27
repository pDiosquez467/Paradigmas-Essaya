/**
 * palindromo/1
 *
 * Indica si una lista es palindrómica (sic).
 *
 * @example
 * % palindromo([n, e, u, q, u, e, n]).
 * 	   true
 */
palindromo([]).
palindromo([_]).
palindromo([H|T]) :-
    append(Medio, [X], T),
    X = H,
    palindromo(Medio).