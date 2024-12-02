public class _15_lowest_common_ancestor_BST {
    //keeping this class as static is importnt or else i cant access later 
    static  class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode( int val){
            this.val=val;
            this.left=null;
            this.right=null;
        }
        
    }

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        while(root!=null){
            if(p.val<root.val && q.val<root.val){root=root.left;}
            else if (p.val>root.val && q.val>root.val){root=root.right;}
            else{return root;}
        }
        return null;
    }

    public static void main(String[] args) {
        //Consruct BST
        TreeNode root= new TreeNode(6);
        root.left= new TreeNode(2);
        root.right= new TreeNode(8);
        root.left.left=new TreeNode(0);
        root.left.right= new TreeNode(4);
        root.right.left= new TreeNode(7);
        root.right.right = new TreeNode(9);


        TreeNode p = root.left.right;
        TreeNode q= root.right.left;


        System.out.println(lowestCommonAncestor(root, p, q).val);


    }

}