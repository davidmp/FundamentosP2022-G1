#2.4 Un estacionamiento requiere determinar el cobro que debe aplicar a las personas que lo utilizan. Considere que el cobro es con base en las horas que lo disponen y que las fracciones de hora se toman como completas y realice un diagrama de flujo y pseudocódigo que represente el algoritmo que permita determinar el cobro.
c:float
horas:float
total1:float
total2:float
c=int(input("¿cuanto cobra por hora?"))
horas=int(input("¿cuantas horas uso el estacionamiento en minutos?"))
total1=horas/60
round(total1)
total2=c*total1
print(f"cobro del estacionamiento {total2}")