
/*InOrder , PreOrder , PostOrder and TopView */

import java.util.*;
class Node
{
    int data;
    Node left,right;
    public Node (int val)
    {
        data = val;
        left = right= null;
    }
}
class BStree
{
    Node create(int data)
    {
        return new Node(data);
    }
    Node insert(Node root,int val)
    {
        if(root == null)
        {
            return create(val);
        }
        if(val < root.data)
        {                                                          
            root.left = insert(root.left, val);
        }
        else
        {
            root.right = insert(root.right, val);
        }
        return root;
    }
    public void preorder(Node root)
    {
        if(root != null)
        {
            System.out.print(root.data+ " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    public void inorder(Node root)
    {
        if(root != null)
        {
            preorder(root.left);
            System.out.print(root.data+ " ");
            preorder(root.right);
        }
    }
    public void postorder(Node root)
    {
        if(root != null)
        {
            preorder(root.left);
            preorder(root.right);
            System.out.print(root.data+ " ");
        }

    }
    public void topview(Node root)
    {
        System.out.print(root.data+" ");
        Node temp=root;
        while(root.left!=null)
        {
            System.out.print(root.left.data+" ");
            root=root.left;
        }
        while(temp.right!=null)
        {
            System.out.print(temp.right.data+" ");
            temp=temp.right;
        }
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        BStree t1 = new BStree();

        int k = sc.nextInt();
        Node root = t1.create(k);

        while (true)
        {
            int val = sc.nextInt();
            if(val == -1)
            {
                break;
            }
            t1.insert(root,val);
        }
       System.out.println("prerorder");
        t1.preorder(root);
        System.out.println();
        System.out.println("inorder");
        t1.inorder(root);
        System.out.println();
        System.out.println("postorder");
        t1.postorder(root); 
        System.out.println("TopView");
        t1.topview(root);
    }
}
