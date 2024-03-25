# Binary trees

## Tree traversal

You can use multiple ways to describe a tree:

- *Preorder*: root followed by the preorder representation of the left sub-tree, followed by the preorder representation of the right sub-tree;

- *Inorder*: inoder representation of left sub-tree, followed by inorder representation of right sub-tree;

- *Postorder*: postorder representation of left sub-tree, followed by postorder representation of right sub-tree, followed by root;

- *Level order*: nodes by ascending order of their level.

![Example of a tree.](https://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/praticas/arvore.png)

- preorder: 5 1 8 6 7 2

- inorder: 8 1 6 5 2 7

- postorder: 8 6 1 2 7 5 

- level order: 5 1 7 8 6 2

For instance, the following tree can be traverse in the following ways:

![Second example of a tree.](https://www.dcc.fc.up.pt/~pribeiro/aulas/edados1920/praticas/arvore2.png)

- preorder: 6 8 4 3 5 1 7

- inorder: 8 4 6 1 5 3 7

- postorder: 4 8 1 5 7 3 6

- level order: 6 8 3 4 5 7 1

## Implementation of binary tree


