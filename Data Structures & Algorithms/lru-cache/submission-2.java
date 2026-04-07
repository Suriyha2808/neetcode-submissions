class LRUCache {
    int[][] arr;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity][2];
        // Fix: Fill keys with -1 so they don't collide with key '0'
        for (int i = 0; i < capacity; i++) {
            arr[i][0] = -1; 
        }
    }

    public int get(int key) {
        for (int i = 0; i < capacity; i++) {
            if (arr[i][0] == key) {
                int val = arr[i][1];
                moveToFront(i, key, val);
                return val;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        int index = -1;
        // Check if key already exists
        for (int i = 0; i < capacity; i++) {
            if (arr[i][0] == key) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Key exists: Move existing to front with NEW value
            moveToFront(index, key, value);
        } else {
            // Key is new: Shift everything and put at index 0
            // This automatically evicts the last element at arr[capacity-1]
            for (int j = capacity - 1; j > 0; j--) {
                arr[j][0] = arr[j - 1][0];
                arr[j][1] = arr[j - 1][1];
            }
            arr[0][0] = key;
            arr[0][1] = value;
        }
    }

    // Helper method to handle the "Most Recently Used" shift
    private void moveToFront(int i, int key, int val) {
        for (int j = i; j > 0; j--) {
            arr[j][0] = arr[j - 1][0];
            arr[j][1] = arr[j - 1][1];
        }
        arr[0][0] = key;
        arr[0][1] = val;
    }
}