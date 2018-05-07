class BinarySearchTree{

    class Node{
        int key;
        Node left, right;

        public Node(int _key){
            key = _key;
            left = right = null;
        }
    };

    // Root of a BST
    Node root;

    // Constructor
    BinarySearchTree(){
        root = null;
    }

    void insert(int key){
        Node node = new Node(key);
        insert(node, root);
    }

    void insert(Node node, Node parent){
        if(parent != null){
            if(parent.key <= node.key){
                if(parent.right == null){
                    parent.right = node;
                    System.out.printf("Inserted key %d to the right of node %d\n", node.key, parent.key);
                    return;
                }
                else
                    insert(node, parent.right);
            }
            else{
                if(parent.left == null){
                    parent.left = node;
                    System.out.printf("Inserted key %d to the left of node %d\n", node.key, parent.key);
                    return;
                }
                else
                    insert(node, parent.left);
            }
        }
        else{
            System.out.printf("Inserted key %d as a root node \n", node.key);
            root = node;
        }
    }

    public static void main(String args[]){
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(19);
        tree.insert(10);
        tree.insert(19);
        tree.insert(5);
        tree.insert(20);
        tree.insert(26);
        tree.insert(6);
    }
}
