#2.5 Constructoras Juliaca requiere determinar cuánto cobrar por trabajos de pintura. Considere que se cobra por m2 y realice un diagrama de flujo y pseudocódigo que represente el algoritmo que le permita ir generando presupuestos para cada cliente.
c:float=10
m2:float
presupuesto:float
c=int(input("¿cuanto cobra por m2?"))
m2=int(input("¿cuantos metros cuadrados tiene su casa?"))
presupuesto=c*m2
print(f"presupuesto: {presupuesto}")