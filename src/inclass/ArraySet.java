package inclass;

public class ArraySet<K> implements Set<K> {

    private K[] items;
    private int size;

    public ArraySet() {
        items = (K[]) new Object[1];
        size = 0;
    }

    @Override
    public void add(K key) {
        if (contains(key)) return;
        if (size == items.length) resize(2*size);
        items[size] = key;
        ++size;
    }

    @Override
    public boolean contains(K key) {
        if (size == 0) return false;
        for(int c = 0; c < size; c++) {
            if (items[c] == key) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void remove(K key) {
        if(!contains(key)) return;
        else {
            for(int c = 0; c < size; c++) {
                if (items[c] == key) {
                    int i;
                    for(i=c; i < size-1; i++) {
                        items[i] = items[i+1];
                    }
                    items[i] = null;
                    --size;
                    break;
                }
            }
        }
    }

    public void resize(int newSize) {
        K[] neo = (K[]) new Object[newSize];
        for(int c = 0; c<size; c++) {
            neo[c] = items[c];
        }
        items = neo;
    }
}
