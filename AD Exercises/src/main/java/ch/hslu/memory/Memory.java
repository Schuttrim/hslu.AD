package ch.hslu.memory;

public interface Memory {
    public Allocation malloc(int size);
    public void free(Allocation alloc);
}
