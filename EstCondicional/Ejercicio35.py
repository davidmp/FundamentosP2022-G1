#Declarar Variables
nombre1:str
nombre2:str
nombre3:str
edad1:int
edad2:int
edad3:int
menorpersona:str
menoredad:int
#Datos de entrada
nombre1=str(input("Ingrese nombre 1:"))
edad1=str(input("Ingrese edad de persona 1:"))
nombre2=str(input("Ingrese nombre 2:"))
edad2=str(input("Ingrese edad de persona 2:"))
nombre3=str(input("Ingrese nombre 3:"))
edad3=str(input("Ingrese edad de persona 3:"))
#Proceso
if edad1<edad2 and edad1<edad3:
  menoredad=edad1
  menorpersona=nombre1
elif edad2<edad1 and edad2<edad3:
  menoredad=edad2
  menorpersona=nombre2
else:
  menoredad=edad3
  menorpersona=nombre3
#Datos de Salida
print(f"La persona con menor edad es: {menoredad} y se llama {menorpersona}")