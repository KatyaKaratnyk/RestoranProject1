package com.butterfly;

public interface DBManager<T,M> {
    boolean check(T t);
    M get(T t);
    void delete(T t);
}
