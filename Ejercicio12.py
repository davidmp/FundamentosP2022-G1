#Definir variables
descuento:float=0.20
igv:float
pbase:float
pcd:float
pf:float
#Datos de entrada
pbase=float(input("Ingrese el precio base del articulo:"))
#Proceso
pcd=pbase-(pbase*descuento)
igv=pcd*0.18
pf=pcd+igv
#Datos de salida
print(f"El precio con descuento es: {pcd}")
print(f"El precio final es: {pf}")