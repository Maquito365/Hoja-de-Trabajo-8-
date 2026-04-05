import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>{

    protected Vector<E> data;

    public VectorHeap() {
        data = new Vector <E>();
    }

    public VectorHeap(Vector<E> v){
        data = new Vector<E> (v.size());
        for (E element : v) {
            add(element);
        }
    }

    protected static int parent (int i){
        return (i-1)/2;
    }

    protected static int left(int i){
        return 2*i + 1;
    }

    protected static int right(int i){
        return (2*i+1) + 1;
    }

    protected void percolateUp(int leaf){
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent))< 0)){
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    public void add(E value){
        data.add(value);
        percolateUp(data.size() - 1);
    }

    protected void pushDownRoot(int root){
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize){
            int PosHijo = left(root);
            if(PosHijo < heapSize){
                if((right(root) < heapSize)&& ((data.get(PosHijo+1)).compareTo(data.get(PosHijo)) < 0)){
                    PosHijo++;
                }
                if((data.get(PosHijo)).compareTo(value) < 0){
                    data.set(root, data.get(PosHijo));
                    root = PosHijo;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    public E getFirst(){
        if (isEmpty()){
            throw new IllegalStateException("Priority queue is empty");
        }
        return data.get(0);
    }

    public E remove(){
        if (isEmpty()){
            throw new IllegalStateException("Priority queue is empty");
        }
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1){
            pushDownRoot(0);
        }
        return minVal;
    }

    public boolean isEmpty(){
        return data.size() == 0;
    }

    public int size(){
        return data.size();
    }

    public void clear(){
        data.setSize(0);
    }

}
