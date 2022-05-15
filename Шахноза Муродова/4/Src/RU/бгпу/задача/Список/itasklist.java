package ru.bgpu.task.list;

import java.util.Collection;

public interface ITaskList<E> extends Iterable<E> {

    void add(E e);
    void addAll(Collection<? extends E> collection);
    void clear();
    E get(int index);
    boolean isEmpty();
    boolean contains(E value);
    E remove(int index);
    int size();
    ITaskList<E> subList(int fromIndex, int toIndex);
    Object[] toArray();
}
