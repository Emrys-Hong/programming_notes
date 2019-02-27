#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>
#include <string.h>
#include <time.h>

// define global constant
#define BUFFERSIZE 1024

// implemenmt in the cclass.c file, if you dont do the other file cannot import
void* pointer_example(void* args);

void array_example(void);

void struct_example(void);