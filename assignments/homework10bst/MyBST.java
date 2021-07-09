package homework10bst;

import java.util.*;

// Demo code for the user implementation of Binary search tree
public class MyBST {
    /** The tree root. */
    private BinaryNode root;

    public MyBST() {
        root = null;
    }

    /**
     * Prints the values in the nodes of the tree
     * in sorted order. Inorder Traversal
     */
    public void printTree() {
        if( root == null )
            System.out.println( "Empty tree" );
        else
            printTree(root);
    }
    // Inorder Traversal to print the nodes in Ascending order
    private void printTree( BinaryNode t ){
        if( t != null ){
            printTree( t.left );
            System.out.print(t.element+", ");
            printTree( t.right );
        }
    }

    public void insertRecursive(Integer x){
        if (root == null) {
            root = new BinaryNode(x); return;
        }
        insertRecursive(root, x);
    }

    public void insertRecursive(BinaryNode bN, Integer el){
        if(el.compareTo(bN.element) < 0){
            if(bN.left == null){
                bN.left = new BinaryNode(el,null,null);
            }
            else
                insertRecursive(bN.left, el);

        }
        else if(el.compareTo(bN.element) > 0){
            if(bN.right == null){
                bN.right = new BinaryNode(el,null,null);
            }
            else
                insertRecursive(bN.right, el);
        }
        else
            return;
    }

    //Assume the data in the Node is an Integer.
    public void insert(Integer x) {
        if (root == null) {
            root = new BinaryNode(x);
            return;
        }
        else {
            BinaryNode n = root;
            boolean inserted = false;

            while(!inserted)//true
            {
                if(x.compareTo(n.element)<0) {
                    //space found on the left
                    if(n.left == null){
                        n.left = new BinaryNode(x,null,null);
                        inserted = true;
                    }
                    //keep looking for a place to insert (a null)
                    else {
                        n = n.left;
                    }
                }
                else if(x.compareTo(n.element)>0){
                    //space found on the right
                    if(n.right==null){
                        n.right = new BinaryNode(x,null,null);
                        inserted = true;
                    }
                    //keep looking for a place to insert (a null)
                    else {
                        n = n.right;
                    }

                }
                // if a node already exists
                else {
                    inserted = true;
                }

            }

        }
    }

    public void preOrder(){ // pre order binary tree traversal display
        if(root == null) System.out.println("Empty tree");
        else preOrder(root);
    }
    public void preOrder(BinaryNode t){ // pre order binary tree traversal display - recursive
        if( t != null ){
            System.out.print(t.element+", ");
            preOrder( t.left );
            preOrder( t.right );
        }
    }

    public void postOrder(){ // post order binary tree traversal display
        if(root == null) System.out.println("Empty tree");
        else postOrder(root);
    }
    public void postOrder(BinaryNode t){ // post order binary tree traversal display - recursive
        if( t != null ){
            postOrder( t.left );
            postOrder( t.right );
            System.out.print(t.element+", ");
        }
    }

    public boolean contains(Integer key){ // check whether an integer is present in binary tree or not
        if(root == null) return false;
        boolean found = false;
        BinaryNode n = root;
        while(found == false && n != null){
            if(key.compareTo(n.element) == 0){
                found = true;
            }
            else if(key.compareTo(n.element) < 0){
                n = n.left;
            }
            else{
                n = n.right;
            }
        }
        return found;
    }

    public Integer getRoot(){ // return the root element of binary tree
        if(isEmpty()) return null;
        return root.element;
    }

    public Integer leafNodes(){ // calculates and returns total number of leaf nodes of binary tree
        if(isEmpty()) return 0;
        return leafNodes(root);
    }
    private int leafNodes(BinaryNode t){ // calculates and returns total number of leaf nodes of binary tree -  recursive
        if(t == null) return 0;
        if(t.left == null && t.right == null)
            return 1;
        else{
            return leafNodes(t.left) + leafNodes(t.right);
        }
    }

    public int size(){ // calculates number of elements present in binary tree
        if(isEmpty()) return 0;
        return size(root);
    }

    public int size(BinaryNode t){ // calculates number of elements present in binary tree - recursive
        if(t == null) return 0;
        return 1 + size(t.left) + size(t.right);
    }

    public boolean isEmpty() { // check the tree is empty or not
        if(root == null) return true;
        else return false;
    }

    public Integer findMin(){ // calculates minimum integer in binary tree
        if(isEmpty()) return 0;
        return findMin(root);
    }

    private Integer findMin(BinaryNode t){ // calculates minimum integer in binary tree - recursive
        if(t.left == null) return t.element;
        return findMin(t.left);
    }

    public Integer findMax(){ // calculates maximum integer in binary tree - recursive
        if(isEmpty()) return 0;
        return findMax(root);
    }
    public Integer findMax(BinaryNode t){ // // calculates maximum integer in binary tree - recursive
        if(t.right == null) return t.element;
        return findMax(t.right);
    }

    private class BinaryNode {
        private Integer element;// The data in the node
        private BinaryNode left;      // Left child
        private BinaryNode right;     // Right child
        // Constructors

        BinaryNode( Integer theElement ){
            this( theElement, null, null );
        }

        BinaryNode( Integer element, BinaryNode left, BinaryNode right ){
            this.element = element;
            this.left = left;
            this.right = right;
        }

    }


    public static void main(String[] args) {

        MyBST mybst = new MyBST();

        int [] a = {15, 12, 9, 56, 1, 16, 19, 22, 3, 100, 2, 25}; // elements to be inserted to binary tree
        for (int j = 0; j < a.length; j++ ) { // insert 12 integers into binary tree
            mybst.insert(a[j]);

        }
        System.out.print("Binary search tree : ");
        mybst.printTree();

        System.out.println();
        System.out.print("Pre order traversal : ");
        mybst.preOrder();

        System.out.println();
        System.out.print("Post order traversal : ");
        mybst.postOrder();

        int element = 16;
        System.out.println();
        System.out.println("Does BST contain " + element + " ? : " + mybst.contains(element));
        System.out.println("Root of BST : " + mybst.getRoot());
        System.out.println("Number of leaf nodes of BST : " + mybst.leafNodes());
        System.out.println("Total number of elements in BST : " + mybst.size());
        System.out.println("Smallest element in BST : " + mybst.findMin());
        System.out.println("Largest Number of element in BST : " + mybst.findMax());

        //        TreeSet<Integer> ts = new TreeSet<Integer>();
        //        for (int j = 0; j < a.length; j++ ) {
        //            ts.add(a[j]);
        //            System.out.println("\nAfter inserting " + j + "th item " + a[j]);
        //            Iterator<Integer> it = ts.iterator();
        //            Integer nextItem = null;
        //            while(it.hasNext()) {
        //                nextItem = it.next();
        //                System.out.print(nextItem + " ");
        //            }
        //            System.out.println();
        //        }
        //
        //        TreeMap<Integer, String> map = new TreeMap<Integer, String>();
        //        map.put(8, "Hello");
        //        map.put(10, "World!");
        //        map.put(11, "Welcome");
        //        map.remove(8);
        //        String str = map.get(11)+", "+ map.get(10);
        //        System.out.println(str);

//        List<Integer> l = new LinkedList<>();
//        l.add(6);
//        l.add(7);
//        for (Integer i : l){
//            System.out.println(i);
//        }

    }
}
