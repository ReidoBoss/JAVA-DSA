import java.util.function.Function;
import java.util.function.Predicate;

public class SinglyLinkedList<T> {
  final T data;
  final SinglyLinkedList<T> next;
  private final boolean isDataNull;
  private final boolean isNextNull;

  private SinglyLinkedList(final T data, final SinglyLinkedList<T> next) {
    this.data = data;
    this.next = next;
    this.isDataNull = data == null;
    this.isNextNull = next == null;
  }

  public final static <T> SinglyLinkedList<T> empty() {
    return new SinglyLinkedList<T>(null, null);
  }

  final public SinglyLinkedList<T> insert(final T element) {
    if (element == null)
      throw new NullPointerException("nulls not allowed to be inserted");

    final SinglyLinkedList<T> newTail = new SinglyLinkedList<T>(element, null);

    if (isDataNull)
      return newTail;

    final SinglyLinkedList<T> appendedTail = isNextNull ? newTail : next.insert(element);

    return new SinglyLinkedList<T>(this.data, appendedTail);
  }
}
