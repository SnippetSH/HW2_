#include <stdio.h>
#include <stdlib.h>

typedef struct Tree* tree;

struct Tree {
    int data;
    tree right;
    tree left;
    int height;
};

int main() {
    printf("Hello world");
}