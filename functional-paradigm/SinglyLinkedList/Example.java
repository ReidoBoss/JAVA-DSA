public class Example {
  public static void main(String[] args) {
    SinglyLinkedList<Integer> ll = SinglyLinkedList.empty();
    SinglyLinkedList<Integer> ll2 = ll.insert(1).insert(2).insert(3).insert(4);
    SinglyLinkedList<String> ll3 = ll2.<String>map(x -> x.toString());
    System.out.println(ll3);
  }
}
