/**
 * Created by tecso on 22/9/16.
 */
public class LargestIndependentSet {
    //LISS LongestIndependentSetSize
    public static int getLiss(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null) {
            node.liss = 1;
            return 1;
        }
        if (node.liss != 0)
            return node.liss;

        //excluding current node
        int liss_excl = getLiss(node.left) + getLiss(node.right);

        //including current node
        int liss_incl = 1; //for current node
        if (node.left != null ) {
            liss_incl += getLiss(node.left.left) + getLiss(node.left.right);
        }
        if (node.right != null) {
            liss_incl += getLiss(node.right.left) + getLiss(node.right.right);
        }
        node.liss = Math.max(liss_excl, liss_incl);


//        //for printing
//        if (liss_incl > liss_excl) {
//            node.isChoosen = true;
//            node.isProcessed = true;
//
//            if (node.left != null && node.left.left != null && !node.left.left.isProcessed) {
//                node.left.left.isChoosen = true;
//                node.left.left.isProcessed =true;
//            }
//
//            if (node.left != null && node.left.right != null && !node.left.right.isProcessed) {
//                node.left.right.isChoosen = true;
//                node.left.right.isProcessed =true;
//            }
//
//            if (node.right != null && node.right.left != null && !node.right.left.isProcessed) {
//                node.right.left.isChoosen = true;
//                node.right.left.isProcessed = true;
//            }
//
//            if (node.right != null && node.right.right != null && !node.right.right.isProcessed) {
//                node.right.right.isChoosen = true;
//                node.right.right.isProcessed = true;
//            }
//        } else {
//            node.isChoosen = false;
//            node.isProcessed =true;
//            if (node.left != null && !node.left.isProcessed) {
//                node.left.isChoosen = true;
//                node.left.isProcessed = true;
//            }
//
//            if (node.right != null && !node.right.isProcessed) {
//                node.right.isChoosen = true;
//                node.right.isProcessed = true;
//            }
//        }

        return node.liss;
    }

    public static void print_liss(Node node) {
        if (node == null)
            return;
        if (node.isChoosen)
            System.out.print(node.data + " ");
        if (node.left != null)
            print_liss(node.left);
        if (node.right != null)
            print_liss(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);
        System.out.println(getLiss(root));
        print_liss(root);
    }
}

class Node {
    int data, liss;
    Boolean isChoosen = false;
    Boolean isProcessed = false;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

