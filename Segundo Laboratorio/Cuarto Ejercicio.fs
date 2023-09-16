module RutaCorta

open Recipientes

// Grafo con pesos
let grafoConPesos = [
    ("i", [("a", 3); ("b", 6)]);
    ("a", [("i", 3); ("c", 6); ("d", 5)]);
    ("b", [("i", 6); ("c", 4); ("d", 2)]);
    ("c", [("a", 6); ("b", 4); ("x", 1)]);
    ("d", [("a", 5); ("b", 2); ("f", 7)]);
    ("f", [("d", 7)]);
    ("x", [("c", 1)]);
]

// Función para verificar si un elemento está en una lista
let rec miembro elemento lista =
    match lista with
    | [] -> false
    | cabeza::resto -> cabeza = elemento || miembro elemento resto

// Función para extender una ruta con pesos
let extender ruta grafo = 
    let nodoActual = List.head ruta
    let vecinosConPesos = List.assoc nodoActual grafo
    List.filter (fun (nodo, _) -> not (miembro nodo ruta))
                (List.map (fun (nodo, peso) -> (nodo::ruta, peso)) vecinosConPesos)

// Función principal de búsqueda en profundidad con pesos
let rec prof2 ini fin grafo =
    let rec prof_aux fin ruta acumulado grafo =
        if List.isEmpty ruta then
            None // No se encontró un camino
        elif List.head ruta = fin then
            Some (List.rev ruta, acumulado)
        else
            let vecinosExtendidos = extender ruta grafo
            match vecinosExtendidos with
            | [] -> None // No hay vecinos para extender la ruta
            | _ ->
                let rutasExtendidas = List.map (fun (rutaExt, peso) -> (rutaExt, acumulado + peso)) vecinosExtendidos
                let rutasOrdenadas = List.sortBy snd rutasExtendidas // Ordena por la suma de pesos
                let rutaCorta, acumuladoCorto = List.head rutasOrdenadas
                match prof_aux fin rutaCorta acumuladoCorto grafo with
                | Some (rutaEncontrada, acumuladoEncontrado) ->
                    Some (rutaEncontrada, acumuladoEncontrado)
                | None ->
                    prof_aux fin (List.tail rutaCorta) acumuladoCorto grafo

    match prof_aux fin [ini] 0 grafo with
    | Some (rutaEncontrada, acumuladoEncontrado) ->
        Some (List.rev rutaEncontrada, acumuladoEncontrado)
    | None -> None

// Ejemplo de uso para encontrar el camino más corto
let resultado = prof2 "i" "x" grafoConPesos

match resultado with
| Some (ruta, acumulado) ->
    printfn "Camino más corto: %A" ruta
    printfn "Suma de pesos: %d" acumulado
| None ->
    printfn "No se encontró un camino válido."

