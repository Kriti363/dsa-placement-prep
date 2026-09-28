class SameTree
{
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
        }
    }

    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
        {
            return true;
        }

        if (p == null || q == null)
        {
            return false;
        }

        if (p.val != q.val)
        {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args)
    {
        SameTree solver = new SameTree();

        // Tree 1: [1, 2, 3]
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        // Tree 2: [1, 2, 3]
        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(solver.isSameTree(p, q));   // true

        // Tree 3: [1, 2]
        TreeNode r = new TreeNode(1);
        r.left = new TreeNode(2);

        // Tree 4: [1, null, 2]
        TreeNode s = new TreeNode(1);
        s.right = new TreeNode(2);

        System.out.println(solver.isSameTree(r, s));   // false (same values, different structure)
    }
}