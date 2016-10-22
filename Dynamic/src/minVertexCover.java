/**
 * Created by tecso on 21/10/16.
 */
public class minVertexCover {
    public static int getMinVertexCover(Node_ node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 0;
        if (node.vc != 0)
            return node.vc;

        //root included
        int size_incl = 1 + getMinVertexCover(node.left) + getMinVertexCover(node.right);

        //excluding root //include left of root //+1 // then left left, left right
        //include right of root //+1 // then right left, right right
        //not like liss, we dont skip one level
        //traverse adjacent level/nodes
        int size_excl = 0;
        if (node.left != null)
            size_excl += 1 + getMinVertexCover(node.left.left) + getMinVertexCover(node.left.right);
        if (node.right != null)
            size_excl += 1 + getMinVertexCover(node.right.left) + getMinVertexCover(node.right.right);

        node.vc = Math.min(size_incl, size_excl);
        return node.vc;

    }

    public static void main(String[] args) {
        Node_ root = new Node_(20);
        root.left = new Node_(8);
        root.left.left = new Node_(4);
        root.left.right = new Node_(12);
        root.left.right.left = new Node_(10);
        root.left.right.right = new Node_(14);
        root.right = new Node_(22);
        root.right.right = new Node_(25);
        getMinVertexCover(root);
        System.out.println(root.vc);


    }
}

class Node_ {
    int data;
    Node_ left, right;
    int vc;

    Node_(int data) {
        this.data = data;
    }
}
