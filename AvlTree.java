/* AVL Tree insertion in preorder */

import java.util.*;
class Node 
{
    int data, height;
    Node left, right;
    public Node(int val) 
    {
        data = val;
        height = 1;
        left = right = null;
    }
}
class AvlTree 
{
    Node create(int data)
    {
        return new Node(data);
    }
    int height(Node node) 
    {
        if (node == null) 
        {
            return 0;
        }
        return node.height;
    }
    int BalanceFactor(Node node) 
    {
        if (node == null)
        {
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    Node rightRotate(Node root)
     {
        Node x = root.left;
        Node y = x.right;
        x.right = root;
        root.left = y;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    Node leftRotate(Node root) 
    {
        Node x = root.right;
        Node y = x.left;
        x.left = root;
        root.right = y;
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }
    Node insert(Node root, int val)
     {
        if (root == null) 
        {
            return create(val);
        }
        if (val < root.data)
        {
            root.left = insert(root.left, val);
        }
        else if (val > root.data)
        {
            root.right = insert(root.right, val);
        }
        else
        {
            return root;
        }
        root.height = Math.max(height(root.left), height(root.right)) + 1;
        int balance = BalanceFactor(root);
        if (balance > 1 && val < root.left.data) 
        {
            return rightRotate(root);
        }
        if (balance < -1 && val > root.right.data)
        {
            return leftRotate(root);
        }
        if (balance > 1 && val > root.left.data) 
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        if (balance < -1 && val < root.right.data) 
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    public void preorder(Node root)
     {
        if (root != null) 
        {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        AvlTree t1 = new AvlTree();
        int k = sc.nextInt();
        Node root = t1.create(k);
        while (true)
         {
            int val = sc.nextInt();
            if (val == -1)  break;
            root = t1.insert(root, val);
        }
        t1.preorder(root);
    }
}
