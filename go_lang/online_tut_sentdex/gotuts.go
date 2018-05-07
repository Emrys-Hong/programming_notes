package main 

import "fmt"



package main 
import ("fmt"
        "math/rand") // this is how we import using slashes

func  main() {
	fmt.Println("The square root of 4 is",math.Sqrt(4))
}
// only the main package will run
// and if the function is capitalized it is the function will be imported
func foo() {
	fmt.Println("a number from ",rand.Intn(100)) // a random int from 1 to 100
	
}

// how to check functions in terminals
// godoc fmt Println
// godoc math/rand Intn # the seed is not changed

func add(x float64,y float64) float64 {
	return x+y
}

func main() {
	var num1 float64 = 5.6
	var num2 float64 = 9.5
	// or you can say
	var num1,num2 float64 = 5.6,9.5
	// or you can say
	var num1,num2 := 5.6,9.5
	fmt.Println(add(num1,num2))
}

const x int = 5
func multiple() {a, b string) (string,string){


	return a,b
}

func main() {
	num1,num2 := 5.6, 9.5
	w1, w2 := "Hey","there"
	fmt.Println(multiple(w1,w2))
}