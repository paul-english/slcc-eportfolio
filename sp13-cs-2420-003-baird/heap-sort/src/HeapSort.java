import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

public class HeapSort {

  public static<T> List<T> heapSort( Collection<? extends T> collection,
                                     Comparator<? super T>comparator ) {
    if ( collection == null || comparator == null ) {
      return null;
    }
    Heap<T> heap = new ArrayMinHeap<T> ( collection, comparator );
    List<T> list = new ArrayList<T> ();
    while ( !heap.isEmpty() ) {
      T e = heap.top();
      list.add( e );
    }
    return list;
  }

}
