#2.9 Se requiere determinar el costo que tendrá, el realizar una llamada telefónica con base en el tiempo que dura la llamada y el costo es por minuto. realice un diagrama de flujo y pseudocódigo que representen el algoritmo para tal fin.
x:float
c:float
s: float
m:float
s=float(input("introduzca el tiempo de la llamada en segundos: "))
c=float(input("introduzca el costo por cada minuto: "))
m=s/60
x=c*m
print(f"el costo total de la llamada es: {x}")