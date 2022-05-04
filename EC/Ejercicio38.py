#Declarar Variables
anhoAnti:int
sueldo:float
bonoAnti:float=0
bonoSueldo:float
bonoMayor:float
#Datos de Entrada
anhoAnti=int(input("Ingrese anho de antiguedad:"))
sueldo=float(input("Ingrese el sueldo reciente:"))
#Proceso y Datos de Salida
if anhoAnti>2 and anhoAnti<5:
  bonoAnti=sueldo*0.20
elif anhoAnti>=5:
  bonoAnti=sueldo*0.30

if sueldo>3500:
  bonoSueldo=sueldo*0.10
elif sueldo>=1000 and sueldo<=3500:
  bonoSueldo=sueldo*0.15
else:
  bonoSueldo=sueldo*0.25

if bonoAnti>bonoSueldo:
  bonoMayor=bonoAnti
else:
  bonoMayor=bonoSueldo
#Datos de Salida  
print(f"El Bono que corresponde es: {bonoMayor}")