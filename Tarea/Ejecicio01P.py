from datetime import datetime
#Declarar Variebles
aNacimiento:int
edad:int
aActual:int
#Datos de Entrada
aNacimiento=int(input("Ingrese Año de Nacimiento:"))
#Proceso
aActual=datetime.now().year
edad=aActual-aNacimiento
#Datos de Salida
print(f"La edad de la persona es: {edad}")