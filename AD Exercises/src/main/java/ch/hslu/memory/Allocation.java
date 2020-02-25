package ch.hslu.memory;

public final class Allocation implements Comparable<Allocation>{
    private final int adress;

    public int getLastAdress() {
        return this.adress + this.size;
    }
    public int getAdress() {
        return adress;
    }

    public int getSize() {
        return size;
    }

    private final int size;

    public Allocation(int adress, int size){
        this.adress = adress;
        this.size = size;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode (this.adress + this.size + 31);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Allocation)){
            return false;
        }
        Allocation alloc = (Allocation) obj;
        return this.size == alloc.size && this.adress == alloc.adress;
    }

    @Override
    public int compareTo(Allocation o) {
        return this.adress - o.adress;
    }
}
