package main

import (
	"fmt"
  "runtime"
  "sync"
  "math/big"
  "time"
)


//(result uint64) 
func Factorial(n uint64) uint64{
	if (n > 1) {
		return n * Factorial(n-1)		
	}
	return 1
}


func FactorialBigRecur(n int64) *big.Int{ 
	if (n > 1) {
		return big.NewInt(n).Mul(FactorialBigRecur(n-1),big.NewInt(n))
	}else{
    return big.NewInt(1)
  }	
}

func FactorialBig(n int64) *big.Int{ 
  result:=big.NewInt(1)
	if (n > 1) {
		for i:= int64(1); i <= n; i++{
      result.Mul(result,big.NewInt(i))
    }   
	}
  return result
}

func fibonacci(n int64) *big.Int{ 
  numAnt:=big.NewInt(0)
  numNew:=big.NewInt(1)
  numAux:=big.NewInt(0)
  contador:=int64(1)
	if (n > 1) {
		for (contador < n) {
      numAux.Set(numNew)
      numNew.Add(numNew,numAnt)
      numAnt.Set(numAux)
      contador=(contador+1)
    }   
    return numNew
	}
  return big.NewInt(n)
}

func fibonacciRecur(numero int64) *big.Int{
    if(numero>1){       
      return big.NewInt(1).Add(fibonacciRecur(numero-1), fibonacciRecur(numero-2));
    }
    return big.NewInt(numero)
 }



func calcularTiempo(numero *big.Int, msg string){
  start := time.Now()
  fmt.Printf("Factorial %s for is : %d \n", msg, numero)
  end := time.Now()
  fmt.Printf("Calculation %s finished in %s \n", msg , end.Sub(start))  
}


func makeTimestamp() int64 {
    return time.Now().UnixNano() / int64(time.Millisecond)
}

func mainFibonacci(numero int64){
  ti := time.Now()
  runtime.GOMAXPROCS(4)
  var wg sync.WaitGroup
  wg.Add(3)  
  go func() {
    defer wg.Done()
    fmt.Println("-----Fibonacci iterativo-----")
    start := time.Now()
    fmt.Println("Resultado Fib iterativo:", (fibonacci(numero)))
    
    end := time.Now()
    fmt.Printf("Calculation finished in %s \n",  end.Sub(start))  
  }()
  /*go func() {
    defer wg.Done()
    start := time.Now()
    fmt.Println("-----Fibonacci recursivo-----")
    fmt.Println("Resultado Fib recursivo:", fibonacciRecur(numero))    
    end := time.Now()
    fmt.Printf("Calculation finished in %s \n",  end.Sub(start))     
  }()  */
  go func() {
    defer wg.Done()
    start := time.Now()
    fmt.Println("-----Factorial No recursivo-----")
    fmt.Println("Resultado Factorial No recursivo:", FactorialBig(numero))    
    end := time.Now()
    fmt.Printf("Calculation finished in %s \n",  end.Sub(start))     
  }()  
  go func() {
    defer wg.Done()
    start := time.Now()
    fmt.Println("-----Factorial recursivo-----")
    fmt.Println("Resultado Factorial recursivo:", FactorialBigRecur(numero))    
    end := time.Now()
    fmt.Printf("Calculation finished in %s \n",  end.Sub(start))     
  }()      
  fmt.Println("Waiting To Finish Operaciones")
  wg.Wait()
  tf := time.Now()
  fmt.Printf("Total tiempo %s \n",  tf.Sub(ti))     
}

func mainPruebaFibonaci(numero int64){
	//nproc --all
	//lscpu | grep 'CPU(s)'
  ti := time.Now()
 /* runtime.GOMAXPROCS(1)
  var wg sync.WaitGroup
  wg.Add(1)
  go func() {
    defer wg.Done()
    fmt.Println("-----Factorial recursivo-----")
    go fibonacciRecur(numero)
  }()  
  wg.Wait()  */
	for i := int64(1); i <= numero; i++ {
	 go fibonacciRecur(numero) //go fibonacciRecur(numero)
	}
  tf := time.Now()
  fmt.Printf("Total tiempo %s \n",  tf.Sub(ti))     
}


func mainFactorial1(numero int64){
  runtime.GOMAXPROCS(2)
  var wg sync.WaitGroup
  wg.Add(2)
  go func() {
    defer wg.Done()
    fmt.Println("-----Factorial recursivo-----")
    calcularTiempo(FactorialBigRecur(numero), "recursivo")
  }()
  go func() {
    defer wg.Done()
    fmt.Println("-----Factorial iterativo-----")
    calcularTiempo(FactorialBig(numero), "iterativo")
  }()
  fmt.Println("Waiting To Finish")
  wg.Wait()  
}

func mainFactorial2(numero int64){
    fmt.Println("-----Factorial recursivo-----")
    calcularTiempo(FactorialBigRecur(numero), "recursivo")  
    fmt.Println("-----Factorial iterativo-----")
    calcularTiempo(FactorialBig(numero), "iterativo")    
}

func main() {
  var numero int64
  fmt.Println("Ingrese un numero:")
  fmt.Scanln(&numero)
  //mainPruebaFibonaci(numero)
  mainFibonacci(numero)
}