/***
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
**/

#include <bits/stdc++.h>
using namespace std;

class Node {
public:
    int data;
    Node* leftChild;
    Node* rightChild;
    
    Node(int data){
        this->data = data;
        leftChild = rightChild = NULL;
    }   
};


Node* search(Node* root, int val){
    // Base Cases: root is null or
    // val is present at root
    if(root == NULL || root->data == val){
        return root;
    }

    // val is greater than root's data
    if(root->data > val){
        return search(root->leftChild, val);
    }   
    // val is smaller than root's data
    else{
        return search(root->rightChild, val);    
    }
}

Node* insert(Node* root, int val){
    // Base Cases: root is null
    if(root == NULL){
        return new Node(val);
    }

    // val is smaller or equal than root's data
    if(val <= root->data){
        root->leftChild = insert(root->leftChild, val);
    }   
    // val is greater than root's data
    else{
        root->rightChild = insert(root->rightChild, val);    
    }
    return root;
}


Node* delNode(Node* root, int val) {      
    // Base case
    if (root == NULL) {
        return root;
    }

    // If key to be searched is in a subtree
    if (root->data > val) {
        root->leftChild = delNode(root->leftChild, val);
    } else if (root.data < val) {
        root->rightChild = delNode(root->rightChild, val);
    } else {
        // If root matches with the given key
        // Cases when root has 0 children or
        // only right child
        if (root->leftChild == null) {
            return root->rightChild;
        }

        // When root has only left child
        if (root->rightChild == null) {
            return root->leftChild;
        }

        // When both children are present
        // Find successor node
        Node* successorNode = root->rightChild;
        while (successorNode->leftChild != null) {
            successorNode = successorNode->leftChild;
        }

        // Swap data
        root->data = successorNode->data;
        // Delete Successor node
        root->rightChild = delNode(root->rightChild, successorNode->data);
    }
    return root;
}






int main(){

    Node* root = new Node(15);
    root->left = new Node(10);
    root->right = new Node(20);
    root->right->left = new Node(18);
    root->right->right = new Node(25);

    return 0;
}