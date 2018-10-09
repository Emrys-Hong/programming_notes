## When to use this design pattern
When you want to add an extra function into the class, tryFly().
but it will be duplicate code to overwrite a lot of code.

## how to achieve it
Try to add it as a data field to a class type, and that class have the correponding function. ```FlyType```
the function calls the function corresponding data type. ```canFly``` or ```cantFly```.