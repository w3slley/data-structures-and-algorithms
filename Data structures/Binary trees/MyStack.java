public interface MyStack<T> {
    //methods that modify the Stack
    public void push(T value);
    public T pop();
    //Methods that get information
    public T top();
    public boolean isEmpty();
    public int size();   
}
