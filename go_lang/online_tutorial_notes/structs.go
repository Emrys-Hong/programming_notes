package main 
import "fmt"


const usixteembitmax float64 = 65535
const kmh_multiple float64 = 1.69

type car struct{
	gas_pedal uint16 // min 0 max 65535
	brake_pedal uint16
	steering_wheel int16
	top_speed_kmh float64
}
// this is something like class function for the go lang
func (c car) kmh()float64{
	return float64(c.gas_pedal)*(c.top_speed_kmh/usixteembitmax)
}

func (c car) mph() float64{
	return float64(c.gas_pedal) * (c.top_speed_kmh/usixteembitmax/kmh_multiple)
}
func main() {
	a_car := car{gas_pedal: 22341, 
		brake_pedal: 0, 
		steering_wheel: 12561, 
		top_speed_kmh:225.0}
	// or you can do this 
	//a_car := car{22341,0,12562,255.0}
	fmt.Println(a_car.gas_pedal) // you can access the name of the attribute by this
    fmt.Println(a_car.kmh()) // this is how to call a function 
    fmt.Println(a_car.mph())
}