package examples.algorithms.binarySearchTree;

public class BinarySearchTree {
    private TreeNode root;

    public void insert(Integer data) {
        if (root == null)
            this.root = new TreeNode(data);
        else root.insert(data);
    }

    public TreeNode find(Integer data) {
        if (root != null)
            return root.find(data);
        return null;
    }

    public void delete(Integer data) {
        TreeNode toDel = find(data);
        toDel.delete();
    }

    public Integer smallest() {
        if (this.root != null)
            return root.smallest();
        return null;
    }

    public Integer largest() {
        if (this.root != null)
            return root.largest();
        return null;
    }

    /**
     Below is code for deletion of nodes that needs to include all possible cases:
     Case 1: node to be deleted is a leaf node
     Case 2: node to be deleted has one child node (either left or right)
     Case 3: node to be deleted has both child nodes
     This method is quite complicated thus it is easier to use soft deletion method
     According to this method nodes to be deleted are just marked as deleted with a boolean field isDeleted
     Then it needs to be considered in other methods like getData - getData shouldn't return data of deleted nodes
     */

    /*
    public void delete(Integer data) {
        TreeNode current = this.root;
        TreeNode parent = this.root;
        boolean isLeftChild = false;

        if (current == null) // empty tree
            return;

        while (current != null && current.getData() != data) { // when current will be null that's the end of a loop
            parent = current;

            if (data < current.getData()) {
                current = current.getLeftChild();
                isLeftChild = true;
            } else {
                current = current.getRightChild();
                isLeftChild = false;
            }
        }

        if (current == null)
            return;

        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                root = null;
            } else {
                if (isLeftChild)
                    parent.setLeftChild(null);
                else
                    parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) {
            if (current == root) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == root) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            // delete element having both left and right children
        }
    }
     */
}
