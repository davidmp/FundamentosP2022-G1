#2.1 Realice un diagrama de flujo y pseudocódigo que representen el algoritmo para obtener el área de un triángulo.
base:float
altura:float
area:float
base=int(input("ingrese la base: "))
altura=int(input("ingrese la altura: "))
area=base*altura
print(f"el area del triangulo es:{area}")