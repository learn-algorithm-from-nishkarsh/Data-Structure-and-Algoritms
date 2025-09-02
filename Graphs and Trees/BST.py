'''
 * Code Written By: Nishkarsh Makhija
 * Code Written for: Learn Algorithm
 * Insta Handle : learn_algorithm  
'''

class Node:
    def __init__(self, data):
        self.data = data
        self.leftChild = None
        self.rightChild = None

def search(root, val):
    # Base Cases: root is null or
    # val is present at root
    if(root == None or root.data == val):
        return root

    # val is greater than root's data
    if(root.data > val):
        return search(root.leftChild, val)

    # val is smaller than root's data
    else:
        return search(root.rightChild, val)     

def insert(root, val):
    # Base Cases: root is null
    if(root == None):
        return new Node(val);

    # val is smaller or equal than root's data
    if(val <= root.data):
        root.leftChild = insert(root.leftChild, val)
    # val is greater than root's data
    else:
        root.rightChild = insert(root.rightChild, val)
    return root

def delNode(root, val) :
    # Base case
    if (root == None):
        return root

    # If key to be searched is in a subtree
    if (root.data > val):
        root.leftChild = delNode(root.leftChild, val)
    
    elif (root.data < val):
        root.rightChild = delNode(root.rightChild, val)
    else:
        # If root matches with the given key
        # Cases when root has 0 children or
        # only right child
        if (root.leftChild == None):
            return root.rightChild

        # When root has only left child
        if (root.rightChild == null):
            return root.leftChild

        # When both children are present
        # Find successor node
        Node successorNode = root.rightChild
        while (successorNode.leftChild != None):
            successorNode = successorNode.leftChild

        # Swap data
        root.data = successorNode.data
        # Delete successor node
        root.rightChild = delNode(root.rightChild, successorNode.data)
    return root


def main:
    root = Node(15)
    root.left = Node(10)
    root.right = Node(20)
    root.right.left = Node(18)
    root.right.right = Node(25)