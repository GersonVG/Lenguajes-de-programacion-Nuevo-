% Ejercicio 1
sumlist([], 0).
sumlist([X|Xs], S) :-
    sumlist(Xs, S1),
    S is X + S1.


% Ejercicio 2
subconj([], _).
subconj([X|Xs], S) :-
    member(X, S),
    subconj(Xs, S).


% Ejercicio 3
aplanar([], []).
aplanar([X|Xs], L2) :-
    aplanar(X, X1),
    aplanar(Xs, Xs1),
    append(X1, Xs1, L2).
aplanar(X, [X]) :- \+ is_list(X).
aplanar([], []).


% Ejercicio 4
partir([], _, [], []).
partir([X|Resto], Umbral, [X|Menores], Mayores) :-
    X =< Umbral,
    partir(Resto, Umbral, Menores, Mayores).
partir([X|Resto], Umbral, Menores, [X|Mayores]) :-
    X > Umbral,
    partir(Resto, Umbral, Menores, Mayores).


% Ejercicio 5
sub_cadenas(_, [], []).
sub_cadenas(Subcadena, [Cadena|Resto], Filtradas) :-
    sub_atom(Cadena, _, _, _, Subcadena),
    sub_cadenas(Subcadena, Resto, RestoFiltradas),
    Filtradas = [Cadena|RestoFiltradas].
sub_cadenas(Subcadena, [_|Resto], Filtradas) :-
    sub_cadenas(Subcadena, Resto, Filtradas).
% para probarlo sub_cadenas("la", ["la casa", "el perro", "pintando la cerca"], Filtradas).
