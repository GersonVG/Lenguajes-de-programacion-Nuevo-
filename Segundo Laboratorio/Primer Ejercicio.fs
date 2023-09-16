
let desplazar (direccion:string) (posiciones:int) (lista:'a list) =
    let longitud = List.length lista
    match direccion with
    | "izq" ->
        let cantidad = min posiciones longitud
        let primeraParte = List.take (longitud - cantidad) lista
        let segundaParte = List.replicate cantidad 0
        segundaParte @ primeraParte
    | "der" ->
        let cantidad = min posiciones longitud
        let primeraParte = List.replicate cantidad 0
        let segundaParte = List.drop cantidad lista
        primeraParte @ segundaParte
    | _ -> failwith "Dirección no válida"

let resultadoIzq = desplazar "izq" 3 [1;2;3;4;5]
let resultadoDer = desplazar "der" 2 [1;2;3;4;5]
let resultadoIzqExceso = desplazar "izq" 6 [1;2;3;4;5]

printfn "Resultado Izquierda: %A" resultadoIzq
printfn "Resultado Derecha: %A" resultadoDer
printfn "Resultado Izquierda con exceso: %A" resultadoIzqExceso
