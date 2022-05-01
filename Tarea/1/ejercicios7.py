#2.7 Una compañía de autobuses requiere determinar el costo que tendrá el boleto de un viaje, esto basado en los kilómetros por recorrer y el costo es por kilómetro. Realice un diagrama de flujo y pseudocódigo que representen el algoritmo para tal fin.
ck:float
c:float
km:float
ck=float(input("introduzca el costo por kilómetros: "))
km=float(input("introduzca cuántos kilómetros tiene su viaje: "))
c=ck*km
print(f"el costo del boleto de su viaje es de: {c}")