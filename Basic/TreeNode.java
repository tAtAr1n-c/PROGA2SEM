package Basic;

public class TreeNode<T>{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;
    public TreeNode<T> parent;

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    public TreeNode<T> getParent() {
        return parent;
    }

    public void setParent(TreeNode<T> parent) {
        this.parent = parent;
    }



    public TreeNode(T data){
        this.data = data;
    }
    public TreeNode(T data, TreeNode<T> left, TreeNode<T> right){
        this.data = data;
    }

    public T getValue() {
        return data;
    }
    public void setValue(T data) {
        this.data = data;
    }
    public boolean isLeaf() {
        return left == null && right == null;
    }
    public boolean isRoot() {
        return parent == null;
    }
}
