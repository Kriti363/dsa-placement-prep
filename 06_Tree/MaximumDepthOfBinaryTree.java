class MaximumDepthOfBinaryTree
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

    int maxDepth(Node node)
    {
        if (node == null)
        {
            return 0;
        }

        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args)
    {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();

        tree.insert(3);
        tree.insert(9);
        tree.insert(20);
        tree.insert(15);
        tree.insert(7);

        System.out.println("Max depth: " + tree.maxDepth(tree.root));
    }
}

// Max depth: 4