package homework;

public class ArrayDictionary<K, V> implements Dictionary<K, V> {

    private Object[] keys;
    private Object[] values;
    private int size;

    public ArrayDictionary() {
        this.size = 0;
        this.keys = new Object[12];
        this.values = new Object[12];
    }

    public void resize(int newSize, Object[] a) {
        Object[] neo = (K[]) new Object[newSize];
        for(int c = 0; c<size; c++) {
            neo[c] = a[c];
        }
        a = neo;
    }

    @Override
    public V get(K key) {
        for(int i = 0; i<this.size; i++) {
            if (key == keys[i]) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) return;
        else {
            if (size == keys.length) resize(2*size, keys);
            if (size == values.length) resize(2*size, values);
            int i;
            for(i = 0; i<this.size; i++) {
                if(keys[i] == key) {
                    if (value != null) {
                        values[i] = value;
                    } else {
                        remove(i);
                    }
                    return;
                }
            }
            if (value == null) return;

            keys[i] = key;
            values[i] = value;
            size++;
        }
    }

    private void remove(int i) {
        i = i+1;
        for(; i < size; i++) {
            values[i-1] = values[i];
            keys[i-1] = keys[i];
        }
        size--;
        keys[size] = null;
        values[size] = null;
    }
}

