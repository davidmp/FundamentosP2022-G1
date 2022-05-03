#Declarar Variables
edad:int
mensaje:str
#Datos de Entrada
edad=int(input("Ingrese su edad:"))
#Proceso y Datos de Salida
if edad>=18:
  mensaje=(f"Puede votar porque su edad es {edad}")
else:
  mensaje=(f"No puede votar porque su edad es {edad}")
#Datos de Salida
print(mensaje)