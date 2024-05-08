#include <stdio.h>
#include <stdlib.h>
#define INT_MAX 9876543210
#define nullptr NULL

typedef struct Tree* tree;

typedef struct Tree {
    int data;
    tree right;
    tree left;
    tree parent;
    int height;
} Tree;

void leftRotation(tree head);
void rightRotation(tree head);

int heightDecision(tree cur) {
    if(cur == nullptr) {
        return 0;
    }
    return cur->height;
}

int find(int v, tree node) {
    if(v == node->data) return 1;
    else if(v < node->data && node->left != nullptr) return find(v, node->left);
    else if(v > node->data && node->right != nullptr) return find(v, node->right);
    return 0;
}

void insert(int v, tree head) {
    Tree* newNode = malloc(sizeof(Tree));
    newNode->data = v;
    newNode->right = nullptr;
    newNode->left = nullptr;
    newNode->parent = nullptr;
    newNode->height = 0;

    if(head == nullptr) {
        head = newNode;
        return;
    }

    if(find(v, head)) {
        printf("%d is already exist!\n", v);
        free(newNode);
        return;
    }

    tree current = head;
    tree parent = nullptr;
    while(current != nullptr) {
        parent = current;
        if(current->data > v) current = current->left;
        else current = current->right;
    }

    if(parent->data > v) parent->left = newNode;
    else if(parent->data < v) parent->right = newNode;
    newNode->parent = parent;

}

int main() {

}