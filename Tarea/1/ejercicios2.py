#2.2 Una empresa importadora desea determinar cuántos dólares puede adquirir con equis cantidad de dinero en soles realice un diagrama de flujo y pseudocódigo que represente un algoritmo para tal fin.
#definir variables
dinero:float
soles:float
dolar:float=3.77
#datos de entrada
soles=int(input("ingrese la cantidad de dinero en soles:"))
#proceso
dinero=soles/dolar
#datos de salida
print(f"cantidad de dinero en dolares es:{dinero}")