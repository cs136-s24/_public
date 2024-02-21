package ourarray; 

public interface OurListInterface<T>{

	public abstract int size();

	public abstract void set(int index, T element);

	public abstract void remove(T element); 

	public abstract void add(T element); 

	public abstract T get(int index); 
}