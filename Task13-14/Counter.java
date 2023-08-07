package hw_final2;

public class Counter  implements AutoCloseable {
    private int count;
    private boolean isOpen;

    public Counter() {
        this.isOpen = true;
    }

    public void add() {
        if (!isOpen) {
            throw new IllegalStateException("Counter is closed");
        }
        count++;
    }

    public int getCount() {
        if (!isOpen) {
            throw new IllegalStateException("Counter is closed");
        }
        return count;
    }

    @Override
    public void close() {
        isOpen = false;
    }

    @Override
    protected void finalize() throws Throwable {
        if (isOpen) {
            throw new IllegalStateException("Counter was not closed properly");
        }
        super.finalize();
    }

    
}
