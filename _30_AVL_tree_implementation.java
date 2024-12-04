// some points still not understood

class _30_AVL_tree_implementation {

    // Node class representing each node in the AVL tree
    class Node {
        int key, height;
        Node left, right;

        Node(int key) {
            this.key = key;
            height = 1; // Initially, a new node is a leaf node
        }
    }

    private Node root;

    // Get the height of a node
    int height(Node node) {
        return (node == null) ? 0 : node.height;
    }

    // Get the balance factor of a node
    int getBalanceFactor(Node node) {
        return (node == null) ? 0 : height(node.left) - height(node.right);
    }

    // Right rotation (LL Case)
    Node rotateRight(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotation (RR Case)
    Node rotateLeft(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a key into the AVL tree
    Node insert(Node node, int key) {
        // Perform the normal BST insertion
        if (node == null) {
            return new Node(key);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            // Duplicates are not allowed in AVL tree
            return node;
        }

        // Update height of this ancestor node
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        // Get the balance factor
        int balance = getBalanceFactor(node);

        // If the node becomes unbalanced, perform rotations

        // Left Left Case
        if (balance > 1 && key < node.left.key) {
            return rotateRight(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.key) {
            return rotateLeft(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Find the node with the minimum key value
    Node getMinValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Delete a key from the AVL tree
    Node delete(Node root, int key) {
        // Perform the normal BST delete
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = delete(root.left, key);
        } else if (key > root.key) {
            root.right = delete(root.right, key);
        } else {
            // Node with only one child or no child
            if ((root.left == null) || (root.right == null)) {
                Node temp = (root.left != null) ? root.left : root.right;

                // No child case
                if (temp == null) {
                    temp = root;
                    root = null;
                } else {
                    // One child case
                    root = temp; // Copy the contents of the non-empty child
                }
            } else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node temp = getMinValueNode(root.right);

                // Copy the inorder successor's data to this node
                root.key = temp.key;

                // Delete the inorder successor
                root.right = delete(root.right, temp.key);
            }
        }

        // If the tree had only one node, return it
        if (root == null) {
            return root;
        }

        // Update height of the current node
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get the balance factor
        int balance = getBalanceFactor(root);

        // If the node becomes unbalanced, perform rotations

        // Left Left Case
        if (balance > 1 && getBalanceFactor(root.left) >= 0) {
            return rotateRight(root);
        }

        // Left Right Case
        if (balance > 1 && getBalanceFactor(root.left) < 0) {
            root.left = rotateLeft(root.left);
            return rotateRight(root);
        }

        // Right Right Case
        if (balance < -1 && getBalanceFactor(root.right) <= 0) {
            return rotateLeft(root);
        }

        // Right Left Case
        if (balance < -1 && getBalanceFactor(root.right) > 0) {
            root.right = rotateRight(root.right);
            return rotateLeft(root);
        }

        return root;
    }

    // Inorder traversal of the AVL tree
    void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.key + " ");
            inorderTraversal(node.right);
        }
    }

    // Wrapper methods
    public void insert(int key) {
        root = insert(root, key);
    }

    public void delete(int key) {
        root = delete(root, key);
    }

    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    // Main method to test the AVL tree
    public static void main(String[] args) {
        _30_AVL_tree_implementation tree = new _30_AVL_tree_implementation();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.println("Inorder traversal of the AVL tree:");
        tree.inorderTraversal();

        tree.delete(40);
        System.out.println("Inorder traversal after deleting 40:");
        tree.inorderTraversal();
    }
}