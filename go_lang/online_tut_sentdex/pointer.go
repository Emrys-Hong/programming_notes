package main 

import "fmt"


// this is pretty much like in c lang
func main() {
    x := 15
    a := &x //memory address
    fmt.Println(a)
    fmt.Println(*a) //if you want to see the address of a
    *a = 5
    fmt.Println(x)
    *a = *a**a
    fmt.Println(x)
    fmt.Println(*a)
}