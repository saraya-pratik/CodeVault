/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class FindElements {
    private Set<Integer> hashSet;

    public FindElements(TreeNode root) {
        hashSet = new HashSet<>();
        if (root != null){
            bfs(root);
        }
    }
    private void bfs(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        root.val = 0;
        queue.add(root);
        
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            int x = node.val;
            hashSet.add(x);
            
            if (node.left != null){
                node.left.val = 2 * x + 1;
                queue.add(node.left);
            }
            if (node.right != null){
                node.right.val = 2 * x + 2;
                queue.add(node.right);
            }
        }
    }
    
    public boolean find(int target) {
        return hashSet.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */