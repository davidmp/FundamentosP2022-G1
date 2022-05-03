#Declarar Variables
puntos:int
bono:float=0
sueldoMin:float
#Datos de Entrada
puntos=int(input("Ingrese la puntuacion del docente:"))
sueldoMin=float(input("Ingrese el sueldo minimo:"))
#Proceso y Datos de Salida
if puntos>=0 and puntos<=100:
  bono=sueldoMin
elif puntos>=101 and puntos<=150:
  bono=2*sueldoMin
elif puntos>=151:
  bono=3*sueldoMin
#Datos de Salida  
print(f"El Bono que obtendra el profesor es: {bono}")