// Define una función llamada n_esimo que toma un valor n y una lista como parámetros.
let n_esimo n lista =
    // Crea una lista de índices [0, 1, 2, ...] con la misma longitud que la lista de entrada.
    let indices = [0..List.length lista - 1]

    // Utiliza List.map para mapear los índices a los elementos correspondientes en la lista de entrada.
    let elementos = List.map (fun i -> List.nth lista i) indices

    // Comprueba si el valor n está contenido en la lista resultante y devuelve un valor booleano.
    List.contains n elementos

// Ejemplos de uso
let resultado1 = n_esimo 2 [1; 2; 3; 4; 5]
let resultado2 = n_esimo 3 [1; 2; 3; 4; 5]
let resultado3 = n_esimo 6 [1; 2; 3; 4; 5]

// Imprime los resultados
printfn "n_esimo 2: %b" resultado1
printfn "n_esimo 3: %b" resultado2
printfn "n_esimo 6: %b" resultado3

