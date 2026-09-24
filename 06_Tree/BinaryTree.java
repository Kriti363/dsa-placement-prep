class BinaryTree
{
    class Node
    {
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    Node root;

    void insert(int data)
    {
        root = insertRec(root, data);
    }

    Node insertRec(Node node, int data)
    {
        if (node == null)
        {
            return new Node(data);
        }

        if (data < node.data)
        {
            node.left = insertRec(node.left, data);
        }
        else if (data > node.data)
        {
            node.right = insertRec(node.right, data);
        }
        // if data == node.data, do nothing (no duplicates)

        return node;
    }

    void delete(int data)
    {
        root = deleteRec(root, data);
    }

    Node deleteRec(Node node, int data)
    {
        if (node == null)
        {
            return null;
        }

        if (data < node.data)
        {
            node.left = deleteRec(node.left, data);
        }
        else if (data > node.data)
        {
            node.right = deleteRec(node.right, data);
        }
        else
        {
            // node found - this is the one to delete

            // Case 1: no children (leaf node)
            if (node.left == null && node.right == null)
            {
                return null;
            }

            // Case 2: one child
            if (node.left == null)
            {
                return node.right;
            }
            if (node.right == null)
            {
                return node.left;
            }

            // Case 3: two children
            // find the smallest value in the right subtree (inorder successor)
            int successor = findMin(node.right);
            node.data = successor;
            node.right = deleteRec(node.right, successor);
        }

        return node;
    }

    int findMin(Node node)
    {
        while (node.left != null)
        {
            node = node.left;
        }
        return node.data;
    }

    void inorder()
    {
        inorderRec(root);
        System.out.println();
    }

    void inorderRec(Node node)
    {
        if (node == null)
        {
            return;
        }
        inorderRec(node.left);
        System.out.print(node.data + " ");
        inorderRec(node.right);
    }

    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Inorder before delete: ");
        tree.inorder();

        tree.delete(30);   // node with two children
        System.out.print("After deleting 30: ");
        tree.inorder();

        tree.delete(20);   // leaf node
        System.out.print("After deleting 20: ");
        tree.inorder();
    }
}

// Inorder before delete: 20 30 40 50 60 70 80 
// After deleting 30: 20 40 50 60 70 80 
// After deleting 20: 40 50 60 70 80 