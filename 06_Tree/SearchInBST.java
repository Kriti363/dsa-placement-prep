class SearchInBST
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

        return node;
    }

    Node searchBST(Node node, int val)
    {
        if (node == null || node.data == val)
        {
            return node;
        }

        if (val < node.data)
        {
            return searchBST(node.left, val);
        }
        else
        {
            return searchBST(node.right, val);
        }
    }

    void inorder(Node node)
    {
        if (node == null)
        {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    public static void main(String[] args)
    {
        SearchInBST tree = new SearchInBST();

        tree.insert(4);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);

        Node result = tree.searchBST(tree.root, 2);

        if (result != null)
        {
            System.out.print("Found subtree rooted at 2: ");
            tree.inorder(result);
            System.out.println();
        }
        else
        {
            System.out.println("Value not found");
        }
    }
}

// Found subtree rooted at 2: 1 2 3 