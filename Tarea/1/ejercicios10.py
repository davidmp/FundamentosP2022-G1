#2.10 Seda Juliaca requiere determinar el pago que debe realizar una persona por el total de metros cúbicos de consumo de agua. Realice un diagrama de flujo y pseudocódigo que represente el algoritmo que permita determinar ese pago.
p:float
ca:float
t:float
ca=float(input("¿cuántos litros de agua consumió? "))
p=float(input("¿cuanto es el pago por metro cubico de agua? "))
mc=ca/1000
t=p*mc
print(f"El pago que se debe realizar a una persona por el total de metros cubicos de consumo de agua es: {t}")