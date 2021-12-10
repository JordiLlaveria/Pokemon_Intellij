package edu.upc.dsa;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public interface Session<E> {
    void save(Object entity);
    void close();
    Object get(Class theClass, String name);
    void update(Object object);
    void delete(Object object, String name);
    LinkedList<Object> findAll(Class theClass);
    List<Object> findAll(Class theClass, HashMap params);
    List<Object> query(String query, Class theClass, HashMap params);
}
