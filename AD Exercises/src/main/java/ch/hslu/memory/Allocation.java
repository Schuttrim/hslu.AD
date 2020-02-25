package ch.hslu.memory;

import java.lang.reflect.Type;

public final class Allocation {
    private final int startAdress;

    public int getStartAdress() {
        return startAdress;
    }

    public int getSize() {
        return size;
    }

    private final int size;

    public Allocation(int startAdress, int size){
        this.startAdress = startAdress;
        this.size = size;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode (this.startAdress + this.size + 31);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Allocation)){
            return false;
        }
        Allocation alloc = (Allocation) obj;
        return this.size == alloc.size && this.startAdress == alloc.size;
    }
}
