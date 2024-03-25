public interface MyDeque<T>{
    
    public void addFirst(T v);
    public void addLast(T v);
    public T removeFirst();
    public T removeLast();

    public T first();
    public T last();
    public int size();
    public boolean isEmpty();
}
