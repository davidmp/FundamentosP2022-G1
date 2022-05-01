#2.6 Se requiere determinar la hipotenusa de un triángulo rectángulo ¿cómo sería el diagrama de flujo y el pseudocódigo que represente el algoritmo para obtenerla? Recuerde que por Pitágoras c^{2} =a^ {2} +b^ {2}
import math
a:float
b:float
c:float
a=float(input("introduzca el cateto del triángulo: "))
b=float(input("introduzca el otro cateto del triángulo: "))
c=a*a+b*b
x=math.sqrt(c)
print(f"la hipotenusa del triángulo es: {x}")