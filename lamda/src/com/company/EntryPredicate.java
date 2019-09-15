package com.company;

@FunctionalInterface
public interface EntryPredicate<T> {
    boolean theBestEntry(T first, T second);
}
