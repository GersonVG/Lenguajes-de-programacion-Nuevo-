% Gerson Vargas Gamboa 2020234629

% Define personas con sus características
persona("Elena", "García", [1,0,1,1,0,0,1,0,1,0]).
persona("Luis", "Rodríguez", [0,1,0,1,1,0,1,1,0,1]).
persona("Sofía", "Martínez", [1,0,0,0,0,1,0,0,1,1]).
persona("Miguel", "Fernández", [1,1,0,0,1,0,1,0,0,1]).
persona("Laura", "López", [0,1,1,0,1,1,0,0,1,0]).
persona("Carlos", "Pérez", [0,0,1,1,0,1,1,1,0,0]).
persona("Ana", "Hernández", [1,0,1,1,0,0,0,1,0,1]).
persona("Javier", "Díaz", [0,0,0,1,0,1,0,0,1,1]).

% Calcular la similitud entre dos listas
similitud([], [], 0).
similitud([H1|T1], [H2|T2], N) :-
    similitud(T1, T2, N1),
    N is N1 + (H1 * H2).

% Encontrar la persona más similar a una muestra
encontrar_persona_similar(Muestra, Nombre, Apellido) :-
    persona(Nombre, Apellido, Caracteristicas),
    similitud(Muestra, Caracteristicas, Similitud),
    not((persona(_, _, OtrasCaracteristicas), similitud(Muestra, OtrasCaracteristicas, OtraSimilitud), OtraSimilitud > Similitud)).

% Caso de prueba: encontrar_persona_similar([0,1,1,0,1,1,0,0,1,0], Nombre, Apellido).

