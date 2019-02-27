// you should include the .h file
#include "cclass.h"

typedef struct mychild {
    int x;
}AD;

typedef struct arguments_data_structure {
    int arg1;
    int arg2;
    float arg3;

    // cannot create an object of itself.
    AD my_children[2];
    struct arguments_data_structure* my_children_pointers[2];
}AS; // AS is the datatype

void array_example(void) {
    // malloc will not free if you exit the function
    int myarray[10];
    char mychararray[BUFFERSIZE];

    AS myASarray[10];

    // so it will use part of the memory
    for (int i=0; i<10; i++) {
        myarray[i] = i;
    }

    for (int i=0; i<10; i++) {
        printf("element i is %d\n", myarray[i]);
    }

    printf("my array address starts at %p \n", myarray);
    printf("my array address starts at %p \n", &myarray[0]);

    // filling the array using address
    for (int i=0; i<10; i++) {
        *(myarray+i) = 100;
    }

    for (int i=0; i<10; i++) {
        printf("element i is changed to %d\n", myarray[i]);
    }


    for (int i=0; i<10; i++) {
        printf("element i address is to %p\n", &myarray[i]);
    }
    
    int* my_array_using_malloc = malloc(10*sizeof(int));
    for (int i=0; i<10; i++) {
        my_array_using_malloc[i] = i;
    }
    for (int i=0; i<10; i++) {
        printf("element i using malloc is %d\n", my_array_using_malloc[i]);
    }

    free(my_array_using_malloc);
}


void* pointer_example(void* args) {
    int number = 5;
    printf("The number is %d \n", number);


    int* number_address = &number;
    // it should be %p
    printf("The address of the number is %p \n", number_address);


    float myfloat = 2.5;
    float* myfloat_address = &myfloat;
    printf("The float is %f stored at %p \n", myfloat, myfloat_address);

    // int* args_input_ad = (int*) args;
    // int args_input_val = *args_input_ad;
    // printf("The input arg is %d \n", args_input_val);


    float** ad_of_ad_of_myfloat = &myfloat_address;
    printf("the address of the float address is stored at %p \n", ad_of_ad_of_myfloat);
    printf("The content that ad_of_ad_of_myfloat is %p \n", *ad_of_ad_of_myfloat);

    AS* args_input_ad = (AS*) args;
    AS args_val = *args_input_ad;
    printf("The input args are arg1: %d, arg2: %d, arg3: %f \n", args_val.arg1, args_val.arg2, args_val.arg3);
    printf("The input args are arg1: %d, arg2: %d, arg3: %f \n", args_input_ad->arg1, args_input_ad->arg2, args_input_ad->arg3);

    // It is dangerous for you to return a value like this
    // because this will be destroyed
    // return (void*)number_address;

    args_input_ad->arg1 = 15;
    return (void*)args_input_ad;
}

// first example
// int main() {
//     printf("Hello\n");
//     int x = 10;
//     int* x_ad = &x;
//     AS argument;
//     argument.arg1 = 1;
//     argument.arg2 = 2;
//     argument.arg3 = 100.1;
//     AS* argument_pointer = &argument;
//     pointer_example((void *)x_ad);
//     // pointer_example((void*) argument_pointer);
//     void* retVal = pointer_example(argument_pointer);
//     AS* return_value_AStype = (AS*) retVal;
//     printf("The arg1 value returned is %d \n", return_value_AStype->arg1);
//     return 0;
// }

// int main() {
//     array_example();
//     return 0;
// }

void struct_example(void) {
    // initialize memory location,
    // have not set any value within it
    AS AS_one;
    AS_one.arg1 = 1;
    AS AS_two;
    AS_two.arg1 = 2;
    AS AS_three;
    AS_three.arg1 = 3;

    AD AD_one;
    AD_one.x = 1;
    AD AD_two;
    AD_two.x = 2;

    AS_one.my_children_pointers[0] = &AS_two;
    AS_one.my_children_pointers[1] = &AS_three;
    
    printf("The first arg of AS_two is %d, The first arg of AS_three is %d \n", AS_one.my_children_pointers[0]->arg1, AS_one.my_children_pointers[1]->arg1);

    AS_one.my_children[0] = AD_one;
    AS_one.my_children[1] = AD_two;
    printf("The x-value of AD_one is %d, The x-value of AD_two is %d \n", AS_one.my_children[0].x, AS_one.my_children[1].x);
}

int main() {
    struct_example();
    return 0;
}