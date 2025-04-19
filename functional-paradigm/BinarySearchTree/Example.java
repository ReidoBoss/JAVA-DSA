package BinarySearchTree;

public class Example {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree()
        .insert(100)
        .insert(20)
        .insert(200)
        .insert(10)
        .insert(30)
        .insert(150)
        .insert(300);

    bst.traverse.inorder((x) -> System.out.print(x + " "));
    System.out.println("");
    bst.traverse.preorder((x) -> System.out.print(x + " "));
    System.out.println("");
    bst.traverse.postorder((x) -> System.out.print(x + " "));
    System.out.println("");

  }

}
