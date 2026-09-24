import java.util.LinkedList;
import java.util.Queue;

class LevelOrderTraversal
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

    void levelOrder()
    {
        if (root == null)
        {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node curr = queue.poll();
            System.out.print(curr.data + " ");

            if (curr.left != null)
            {
                queue.add(curr.left);
            }
            if (curr.right != null)
            {
                queue.add(curr.right);
            }
        }
        System.out.println();
    }

    void levelOrderByLevel()
    {
        if (root == null)
        {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++)
            {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");

                if (curr.left != null)
                {
                    queue.add(curr.left);
                }
                if (curr.right != null)
                {
                    queue.add(curr.right);
                }
            }
            System.out.println();   // new line after each level
        }
    }

    public static void main(String[] args)
    {
        LevelOrderTraversal tree = new LevelOrderTraversal();

        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        System.out.print("Level order (flat): ");
        tree.levelOrder();

        System.out.println("Level order (by level):");
        tree.levelOrderByLevel();
    }
}

// Level order (flat): 50 30 70 20 40 60 80 
// Level order (by level):
// 50 
// 30 70 
// 20 40 60 80 