// Define una función llamada sub_cadenas que toma una subcadena y una lista de cadenas como parámetros.
let sub_cadenas (subcadena:string) (lista:string list) =
    // Utiliza la función List.filter para filtrar las cadenas en la lista.
    // La función lambda verifica si cada cadena en la lista contiene la subcadena.
    lista |> List.filter (fun cadena -> String.contains subcadena cadena)

// Ejemplo de uso de la función sub_cadenas.
let resultado = sub_cadenas "la" ["la casa"; "el perro"; "pintando la cerca"]

// Imprime las cadenas filtradas.
printfn "Cadenas filtradas: %A" resultado

