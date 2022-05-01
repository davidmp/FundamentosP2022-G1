#Declarar Variables
n1:float
n2:float
n3:float
promFinal:float
#Datos de Entrada
n1=float(input("Ingrese Nota 01:"))
n2=float(input("Ingrese Nota 02:"))
n3=float(input("Ingrese Nota 03:"))
#Proceso
promFinal=n1*0.25+n2*0.25+n3*0.50
#Datos de Salida
print(f"El promedio de alumno es: {promFinal}")