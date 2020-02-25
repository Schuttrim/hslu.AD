package ch.hslu.memory;

import com.sun.source.tree.LiteralTree;
import com.sun.source.util.Trees;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

public final class MemorySimple implements  Memory {

    private final List<Allocation> allocations = new ArrayList<>();
    private final List<Allocation> unallocated = new ArrayList<>();

    public int getSize() {
        return size;
    }

    private final int size;

    public MemorySimple(int size){
        this.size = size;
        this.unallocated.add(new Allocation(0, this.size));
    }

    @Override
    public Allocation malloc(int size) {
        if (size < 1)
            return null;
        var unallocatedChunk = this.getUnallocatedMemory(size);
        var allocation = allocateInChunk(unallocatedChunk, size);
        this.allocations.add(allocation);
        return allocation;
    }

    private Allocation allocateInChunk(Allocation chunk, int size){
        Allocation newAllocation = new Allocation(chunk.getAdress(), size);
        int newSize = chunk.getSize() - size;
        Allocation newUnallocatedChunk = new Allocation(newAllocation.getLastAdress() + 1, newSize);
        this.unallocated.remove(chunk);
        this.unallocated.add(newUnallocatedChunk);
        this.sortUnallocated();
        return newAllocation;
    }
    private Allocation getUnallocatedMemory(int size){
        Iterator iterator = this.unallocated.iterator();
        while (iterator.hasNext()) {
            Allocation allocation = (Allocation)iterator.next();
            if (allocation.getSize() > size)
                return allocation;
        }
        throw new OutOfMemoryError();
    }

    @Override
    public void free(Allocation alloc) {
        if (!this.allocations.contains(alloc)){
            throw new Error("Allocation not contained in this memory.");
        }
        this.allocations.remove(alloc);
        this.unallocated.add(alloc);
    }

    private void sortUnallocated() {
        this.unallocated.sort(Comparator.comparingInt(Allocation::getSize));
    }

    @Override
    public void triggerGC() {

    }
}
