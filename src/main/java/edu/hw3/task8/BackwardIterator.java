package edu.hw3.task8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<T> {
    private final List<T> collection;
    private int index;

    public BackwardIterator(Collection<T> collection) {
        this.collection = new ArrayList<>(collection);
        index = collection.size() - 1;
    }

    @Override public boolean hasNext() {
        return index >= 0;
    }

    @Override public T next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements");

        }
        return collection.get(index--);
    }
}
