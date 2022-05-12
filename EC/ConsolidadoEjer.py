def ejerciounoDMP():
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

def ejercicodosDMP():
  #Declarar Variables
  pagohora:float
  cantidadhora:int
  sueldomensual:float
  #Datos de Entrada
  pagohora=float(input("Ingrese el costo por hora:"))
  cantidadhora=int(input("Ingrese cantidad horas trabajadas en la semana:"))
  #Proceso y Datos de Salida
  if cantidadhora>40:
    sueldomensual=40*pagohora+2*((cantidadhora-40)*pagohora)
  else:
    sueldomensual=cantidadhora*pagohora
  #Datos de Salida
  print(f"El sueldo del trabajador es {sueldomensual}")


pregunta=int(input("Ingrese la pregunta que desea probar: "))

if pregunta==1:
  ejerciounoDMP()
elif pregunta==2:
  ejercicodosDMP()
