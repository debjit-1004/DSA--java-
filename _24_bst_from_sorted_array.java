public class _24_bst_from_sorted_array {
    static class TreeNode{
        int val;
        TreeNode right,left;

        TreeNode(int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    
    public static TreeNode sortedArrayToBST(int []nums){
        return helper(nums,0,nums.length-1);
    }

    public static TreeNode helper(int nums [], int left,int right){
        if (left>right){return null;}
        int mid = left + (right-left)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums,left,mid-1);
        root.right = helper(nums, mid+1, right);
        return root ;
    }

    public static void inOrderTraversal(TreeNode root){
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val+ " ");
        inOrderTraversal(root.right);
    }

    public static void main(String args[]){
        int [] array = {1,2,3,4,5,6,7,8,9};
        TreeNode root = sortedArrayToBST(array);
        inOrderTraversal(root);
    }
}
