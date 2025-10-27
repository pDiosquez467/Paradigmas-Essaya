% predicado espejo/2
espejo(hoja(X), hoja(X)).
espejo(arbol(A, B), arbol(C, D)) :-
    espejo(A, D), espejo(B, C).

% Consulta: ?- espejo(arbol(arbol(hoja(1), hoja(2)), hoja(4)), T).
% T = arbol(hoja(4), arbol(hoja(2), hoja(1))).