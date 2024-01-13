package homework;

public class ArrayDictionaryF<K,V> implements Dictionary<K,V>{

    // Static objects
    private Object[] keys;
    private Object[] values;
    private int arraySize; // number of elements in the array
    private int capacity; // number of elements that should fit in the array

    // Constructor
    public ArrayDictionaryF(){
        this.arraySize = 0;
        this.capacity = 10;
        this.keys = new Object[this.capacity];
        this.values = new Object[this.capacity];
    }

    // Helper Function: Resize
    public void resize(Object[] array){
        Object[] temp = new Object[2*capacity];
        for (int i = 0; i < array.length; i++){
            temp[i] = array[i];
        }
        array = temp;
        this.capacity *= 2;
    }

    // Helper remove
    public void remove(int index){
        for(int i = index + 1; i < this.arraySize; i++){
            this.keys[i-1] = this.keys[i];
            this.values[i-1] = this.values[i];
        }
        arraySize--;
        keys[arraySize] = null;
        values[arraySize] = null;
    }


    @Override
    public V get(K key) {
        V value = null;
        if (arraySize == 0) return null;
        for (int i = 0; i < this.arraySize; i++){
            if (key == keys[i]){
                value = (V) this.values[i];
                break;
            }
        }
        return value;
    }

    @Override
    public boolean isEmpty() {
        if (this.arraySize == 0 || this.capacity == 0) return true;
        else return false;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) return;
        else {
            int i = 0;
            while (i < this.arraySize) {
                if (keys[i].equals(key)) {
                    if (value != null) {
                        values[i] = value; // if value is not null assign value and return
                        return;
                    }
                    else { remove(i); ; return; }
                }
                i++;
            }
            if (value == null) return;
            this.arraySize += 1; keys[i] = key; values[i] = value;
            resize(keys); resize(values); return;
        }
    }

}