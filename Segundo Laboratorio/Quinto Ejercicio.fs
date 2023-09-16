// Representación del laberinto como una matriz de caracteres
let laberinto = [|
    "X X X X X X X X X";
    "X   X     X     X";
    "X   X X X X X   X";
    "X     X   X   X X";
    "X X X X X X X X X";
|]

// Función para verificar si una coordenada está dentro de los límites del laberinto y es un espacio libre
let esEspacioLibre (x, y) =
    if x >= 0 && x < Array.length laberinto && y >= 0 && y < String.length laberinto.[x] then
        laberinto.[x].[y] = ' '
    else
        false

// Función de búsqueda en profundidad (DFS) para encontrar todas las rutas posibles en el laberinto
let buscarRutas (inicioX, inicioY) (finX, finY) =
    let rec dfs (x, y) ruta =
        if x = finX && y = finY then
            yield ruta
        else
            let posiblesMovimientos = [(x+1, y); (x-1, y); (x, y+1); (x, y-1)]
            for (nx, ny) in posiblesMovimientos do
                if esEspacioLibre (nx, ny) && not (List.exists (fun (px, py) -> px = nx && py = ny) ruta) then
                    yield! dfs (nx, ny) ((nx, ny)::ruta)

    dfs (inicioX, inicioY) []

// Ejemplo de uso para encontrar rutas en el laberinto
let rutas = buscarRutas (1, 1) (3, 7)

// Función para encontrar la ruta más corta (menos pasos) de una lista de rutas
let encontrarRutaMasCorta rutas =
    Seq.minBy (fun ruta -> List.length ruta) rutas

// Imprimir todas las rutas encontradas
printfn "Rutas encontradas:"
for ruta in rutas do
    printfn "%A" ruta

// Encontrar y imprimir la ruta más corta
let rutaMasCorta = encontrarRutaMasCorta rutas
printfn "Ruta más corta:"
printfn "%A" rutaMasCorta

