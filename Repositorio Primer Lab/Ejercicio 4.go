package main

import "fmt"

type calzado struct {
	Modelo string
	Precio float64
	Talla  int
	Stock  int
}

func (c *calzado) Vender(cantidad int) bool {
	if c.Stock >= cantidad {
		c.Stock -= cantidad
		return true
	}
	return false
}

func main() {
	inventario := []calzado{
		{Modelo: "Nike Air", Precio: 50000, Talla: 42, Stock: 5},
		{Modelo: "Adidas Boost", Precio: 60000, Talla: 40, Stock: 10},
		{Modelo: "Puma Classic", Precio: 45000, Talla: 38, Stock: 3},
		{Modelo: "Reebok Runner", Precio: 55000, Talla: 41, Stock: 7},
		{Modelo: "Converse All Star", Precio: 40000, Talla: 37, Stock: 2},
		{Modelo: "Vans Old Skool", Precio: 48000, Talla: 39, Stock: 8},
		{Modelo: "New Balance 990", Precio: 70000, Talla: 43, Stock: 4},
		{Modelo: "Nike Limited Edition", Precio: 58000, Talla: 44, Stock: 6},
		{Modelo: "Speedcross", Precio: 75000, Talla: 42, Stock: 9},
		{Modelo: "Jordan", Precio: 52000, Talla: 40, Stock: 5},
	}

	fmt.Println("Bienvenido a la Tienda de Calzados!")
	fmt.Println("===================================")

	for i, calzado := range inventario {
		fmt.Printf("[%d] Modelo: %s, Precio: %.2f, Talla: %d, Stock: %d\n", i+1, calzado.Modelo, calzado.Precio, calzado.Talla, calzado.Stock)
	}

	fmt.Println("===================================")

	// Simular algunas ventas
	fmt.Println("Intentando vender calzados...")
	venderCalzado(&inventario[0], 2)
	venderCalzado(&inventario[1], 5)
	venderCalzado(&inventario[2], 1)
}

func venderCalzado(calzado *calzado, cantidad int) {
	fmt.Printf("Vendiendo %d pares de %s...\n", cantidad, calzado.Modelo)
	if calzado.Vender(cantidad) {
		fmt.Println("Venta exitosa!")
		fmt.Printf("Stock restante de %s: %d\n", calzado.Modelo, calzado.Stock)
	} else {
		fmt.Println("Venta fallida: Stock insuficiente.")
	}
	fmt.Println("===================================")
}

