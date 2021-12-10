package edu.upc.dsa;

import edu.upc.dsa.util.ObjectHelper;
import edu.upc.dsa.util.QueryHelper;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


public class SessionImpl implements edu.upc.dsa.Session {
    private final Connection conn;

    public SessionImpl(Connection conn) {
        this.conn = conn;
    }

    public void save(Object entity) {

        String insertQuery = QueryHelper.createQueryINSERT(entity);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);
            //pstm.setObject(1, 3);
            int i = 1;

            for (String field: ObjectHelper.getFields(entity)) {
                pstm.setObject(i++, ObjectHelper.getter(entity, field));
            }

            pstm.executeQuery();
            close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void close() {
        try {
            this.conn.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Object get(Class theClass, String name) {
        String selectQuery = QueryHelper.createQuerySELECT(theClass);
        PreparedStatement pstm = null;
        Object o = null;

        try {
            pstm = conn.prepareStatement(selectQuery);
            pstm.setObject(1, name);
            ResultSet rs = pstm.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                int i=1;
                o = theClass.newInstance();
                while (i<columnsNumber+1) {
                    Object e = rs.getObject(i);
                    if (e!=null)
                        ObjectHelper.setter(o,rsmd.getColumnLabel(i),e);
                    i++;
                }
            }
            close();
            return o;

        } catch (SQLException e) {
            e.printStackTrace();
            return e;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return e;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return e;
        }
    }

    public void update(Object object) {
        String insertQuery = QueryHelper.createQueryUPDATE(object);

        PreparedStatement pstm = null;
        String name=null;
        try {
            pstm = conn.prepareStatement(insertQuery);
            int i = 1;

            for (String field: ObjectHelper.getFields(object)) {
                if (field=="name")
                    name=(String)ObjectHelper.getter(object, field);
                pstm.setObject(i++, ObjectHelper.getter(object, field));
            }
            pstm.setObject(i, name);

            pstm.executeQuery();
            close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(Object object, String name) {
        String insertQuery = QueryHelper.createQueryDELETE(object);

        PreparedStatement pstm = null;

        try {
            pstm = conn.prepareStatement(insertQuery);

            pstm.setObject(1, name);

            pstm.executeQuery();
            close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<Object> findAll(Class theClass) {
        String selectQuery = QueryHelper.createQuerySELECTALL(theClass);
        Statement pstm = null;
        LinkedList<Object> objects = new LinkedList<Object>();
        Object o;

        try {
            pstm = conn.createStatement();
            ResultSet rs = pstm.executeQuery(selectQuery);
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            while (rs.next()) {
                o = theClass.newInstance();
                int i=1;
                while (i<columnsNumber+1) {
                    Object e = rs.getObject(i);
                    if (e!=null)
                        ObjectHelper.setter(o,rsmd.getColumnLabel(i),e);
                    i++;
                }
                objects.add(o);
            }
            close();
            return objects;

        } catch (SQLException e) {
            e.printStackTrace();
            return objects;
        } catch (InstantiationException e) {
            e.printStackTrace();
            return objects;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return objects;
        }
    }

    public List<Object> findAll(Class theClass, HashMap params) {
        return null;
    }

    public List<Object> query(String query, Class theClass, HashMap params) {
        return null;
    }
}
