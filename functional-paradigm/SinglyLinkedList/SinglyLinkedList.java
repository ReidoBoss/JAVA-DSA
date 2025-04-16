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
}
