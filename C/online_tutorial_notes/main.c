#include <stdio.h>
#include <stdlib.h>
// this is the first lesson about print
/*
// can have only and must have one main function and the program will execute this.
int main() // can put in arguement here
{ // int function
    // you can use any indentations, but let it have structure can make it good looking
    printf("Hello world!\n"); // need to write in the double quote
    // \n help you print in the next line or the c program will not know that you want to print in the next line
    printf("%d \n",32); // "%d means the a place holder.
    // the integer place holder is d and float holder is f
    printf("%f \n",32.2);
    printf("the number you want to print is %d \n", 32);
    printf("the number you want to print is %d %d %d \n",32, 32, 32); // must have the space between %d and %d
    // if you want a large value can print in ld or lf

    printf("%c \n",'a'); // if you want to print in imple character, and use ' instead of "
    printf("%s \n", "hello world"); // s for string, must use the double quote here
    printf("%x \n",16); // x for hex
    return 0; // every line need to have a ;
} // must have a {}
// compiler can convert it to computer language
// build will give you some error if you have some error
//scanf and puts function can also be in the value of the input
*/

// this is the second lesson which is about storing the data type

/*
int main()
{
int age;
/* the variable cannot start with a number, but it can contains number
cannot contains space
cannot contains special character but can use _
and cannnot contains keywords
*/
/*
age=21;
int age=21;
float pi = 3.14;
char mychar='a';
double big_pi = 3.1415926;

printf("the age is %d", age);
return 0;
}
*/


// math operators
/*
int main()
{// same as python
int a=11, b=2;
float modulus;
modulus=a%b
printf("product",modulus));
return 0;
}
*/


// if condition
/*
int main()
{
int age;
printf("please enter the age");
scanf("%d",&age); // enter the variable here
if (age < 18){
    printf("the age is smaller than 18");
    }
if (age == 18){
    printf("the age is equal to 18");
    }
if (age > 18){
    printf("the age is bigger than 18");
    }
}
*/

// else condition
/*
int main()
{
int age;
printf("please enter the age");
scanf("%d",&age); // enter the variable here
if (age < 18){
    printf("the age is smaller than 18");
    }else if(age == 18)
    {
        printf("the age is equal to 18");
    }else
    {
    printf("the age is not greater than or equal to 18");
    }
}
*/

// the ternary operator in C
/*
int main()
{
int a=20,b=20;
int c;
c = (a > b) ? b : a; // if something ? b : a // this way you can write your program in two ways // this gives the minimum values of the two
printf("the answer is %d", c);
}
*/

// how to use the switch statement in c
/*
int main()
{
    int marks=95;
    switch (marks)
    {
    case 95:
    case 90:
        // no need the curly bracker here since it does not have any value
        printf("excellent");
        break; // the break helps you to jump out of the case

    case 75:

        printf("good");
        break;

    case 65:

        printf("ok");
        break;

    default: // the condition that is not defined will be executed here
        printf("the grade is not determined");
        // there is no need the break here
    }
}
*/

// how to use loops in c
/*
int main()
{
    int i = 0;
    while (i < 10){
        printf("the value of i is %d \n",i);
        i ++; // add 1 at each time step i = i + 1
    }
}
*/

// how to use the do while loop
// the difference between the do while loop and the while loop is that the do while loop first do the case at least once and then check the condition fufils
/*
int main()
{
    int i = 0;
    do {
    printf("Value of i = %d",i);
    i++;
    } while(i<10);
}
*/


// how to use for loop in c
/*int main()
{
    // for loop shoule be used like this for (init;condition;increment){statement}

    for (int i=0; i<10 ; i++){
        printf("the value of the i = %d \n",i);
    }

}
*/

// how to use function in c

/*
void MyFunctionName(); // if you put your function behind the main function then you need to declare the function in front of the main
int main()
{
// not returning anything is type void
    MyFunctionName();
    MyFunctionName();

}
void MyFunctionName()
{
     printf("the sum is %d",32);
}
*/

// how to have a variable with args
/*
void Sum(int a, int b)
{
    int sum = a + b;
    printf("the sum of the function is %d \n",sum);
}

int main()
{
    int x,y;
    printf("Please enter two numbers \n");
    printf("please enter number 1 \n");
    scanf("%d",&x); // cannot have anything over here, cause if you do, the whole thing will be x

    printf("number 2 \n");
    scanf("%d",&y);
    Sum(x, y);
}
*/


// for the function that return something type int
/*
int Product(int a, int b)
{
    return (a * b);
}

int main()
{
    int x,y;
    printf("Please enter two numbers \n");
    printf("please enter number 1 \n");
    scanf("%d",&x); // cannot have anything over here, cause if you do, the whole thing will be x

    printf("number 2 \n");
    scanf("%d",&y);

    int prod;
    prod = Product(x, y);

    printf("product = %d",prod);
    // or we can just directly use printf("result: %d",Product(x, y) );
}
*/

// global variable and the local variable is the same as in python, and local variable have a priority over global variable

// how to use an array
// array is like a list in python
/*
int main()
{
    int MyNumberArray [3] = {20, 30, 40}; // here because it is static arrays unlike in python so we need to name the size
    int second = MyNumberArray[1]; // how to access in an array, same as python

    char charArray[1] = {'s'}; // the array is in the curly braces and we need to define the type for the array

    MyNumberArray[1] = 70; // can change the number

    for (int i=0; i<3; i++)
    {
        printf("element [%d] = %d \n", i, MyNumberArray[i]); // here the element is representing the MyNumberArray
    }
}
*/

// here we take multidiemnsional array
/*
int main()
{
    int MyArray [2] [3] = {
        {1,3,2}, // row 1
        {5,6,8}, // row 2
    };

    for (int i=0; i<2; i++){
        for (int j=0;j<3;j++){
            printf("MyArray[%d][%d] = %d \n",i,j,MyArray[i][j]);
        }
    }
}
*/

// how to pass array as an args of a function
/*
int ArraySum(int Array[], int size) // this is to pass the different size
{
    int sum = 0;
    for (int i=0; i<size; size++){
        sum += Array[i];
    return sum;
    }
}
int main()
{
    int MyArray [6] = {20, 30, 40, 50, 60, 70};
    int sum_of_array = ArraySum(MyArray, 6);

    printf("Arra Sum = %d", sum_of_array);
}
*/

// how to use the pointers
// pointers are the variables of another variable
/*
int main()
{
    int val=30;
    int *pointer_p;
    pointer_p = &val; // & get the address * convert the address to the actual value

    printf("the address of val: %x \n", &val); // the address are hex value
    printf("value of the pointer variable = %x \n", pointer_p);
    printf("value of the pointer = %d \n", *pointer_p);
}
*/


// how to assign the array of a pointer
// by access the each entry in an array and assign an value to the array
/*
int main()
{
    int value_array[3] = {1, 2, 3};
    int *pointer_array[3];

    for (int i=0;i<3;i++)
    {
        pointer_array[i] = &value_array[i];
    }

    for (int j=0;j<3;j++)
    {
        printf("%d \n",*pointer_array[j]);
        printf("%x \n",pointer_array[j]);
    }
}
*/

// how to pass pointers as arg of a function
// the whole function set variable some value by using address
/*
void getvalue(int *mypointer) // this means that it only passed in the pointer as a game
{
    *mypointer = 10000; // &get_the_value=1000
    return; // here is return nothing, this means break the loop
}

int main()
{
    int get_the_value;
    getvalue(&get_the_value);

    printf("the value of the get_the_value = %d",get_the_value);
}
*/

// pointer array
/*
int getsum(int *array_val, int size)
{
    int sum = 0;
    for (int i=0;i<size;i++)
    {
        sum += array_val[i];
    }
    return sum;
}

int main()
{
    int my_array[4] = {1,2,3,4};
    int sum = getsum(my_array,4);

    printf("the value of the sum is: %d",sum);
}
*/

#include <string.h> // this lib is useful for strings

// how string works
// string is a list of characters that is null dominanted
/*
int main()
{
    char mystring[6] = {'H','e','l','l','o','\0'}; //'\0' this means null, and a string is null dominanted
    char myotherstring = "Hello"; // you can also do it like this

    char string1[12] = "Hello";
    char string2[12] = "World";
    char string3[12];

    strcpy(string3, string1); // str(dest, source)
    strcat(string1,string2); // add string2 to string1
    int string1_lenghth = strlen(string3);

    int value = strcmp(string1, string2); // cmp the value is the same or not if it is the same then it will give 0
    printf("strcmp = %d", value);
}
*/

// what are structures
// structures are like classes in python
/*
struct student {
    int id;
    char name[20];
    float percentage;
} /* can also put the name here if you want* -- record1/; // do not forget about the ; for the structure at the end

int main()
{
        struct student record1;
        record1.id = 1;
        strcpy(record1.name,"john");
        record1.percentage = 70.20;

        printf("id = %d name = %s percentage = %f ",record1.id, record1.name, record1.percentage);

        return 0;
}
*/

// the union
// union is like the struct but it allocates the same memory for the variable and the max memory space for the union depends on the biggest variable
struct student {
    int id;
    char name[20];
    float percentage;
};

union myunion {
    int myint;
    char mychar;
};

int main()
{
        struct student record1;
        record1.id = 1;
        strcpy(record1.name,"john");
        record1.percentage = 70.20;

        union myunion uni;
        uni.myint = 4;
        uni.mychar = 9;

        printf("size of the struct %d \n", sizeof(record1) );
        printf("size of the uni %d \n", sizeof(uni) );

        return 0;
}
