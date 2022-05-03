#Declarar Variables
pagohora:float
cantidadhora:int
sueldomensual:float
#Datos de Entrada
pagohora=int(input("Ingrese el costo por hora:"))
cantidadhora=int(input("Ingrese cantidad horas trabajadas en la semana:"))
#Proceso y Datos de Salida
if cantidadhora>40:
  sueldomensual=40*pagohora+2*((cantidadhora-40)*pagohora)
else:
  sueldomensual=cantidadhora*pagohora
#Datos de Salida
print(f"El sueldo del trabajador es {sueldomensual}")