palabra(astante, [a,s,t,a,n,t,e]).
palabra(astoria, [a,s,t,o,r,i,a]).
palabra(baratto, [b,a,r,a,t,t,o]).
palabra(cobalto, [c,o,b,a,l,t,o]).
palabra(pistola, [p,i,s,t,o,l,a]).
palabra(statale, [s,t,a,t,a,l,e]).

crucigrama(H1, H2, H3, V1, V2, V3) :-
    % Restricciones sobre las palabras
    palabra(H1, [H11, H12, H13, H14, H15, H16, H17]),
    palabra(H2, [H21, H22, H23, H24, H25, H26, H27]),
    palabra(H3, [H31, H32, H33, H34, H35, H36, H37]),
    palabra(V1, [V11, V12, V13, V14, V15, V16, V17]),
    palabra(V2, [V21, V22, V23, V24, V25, V26, V27]),
    palabra(V3, [V31, V32, V33, V34, V35, V36, V37]),

    % Restricciones sobre las letras
    H12 = V12, H14 = V22, H16 = V32,
    H22 = V14, H24 = V24, H26 = V34,
    H32 = V16, H34 = V26, H36 = V36,

    % Las palabras deben ser distintas!
    H1 \= H2,
    H1 \= H3,
    H2 \= H3,
    V1 \= H1.