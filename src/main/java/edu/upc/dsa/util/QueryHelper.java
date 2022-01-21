package edu.upc.dsa.util;

import java.util.Locale;

public class QueryHelper {

    public static String createQueryINSERT(Object entity) {

        StringBuffer sb = new StringBuffer("INSERT INTO ");
        sb.append("pokemon.");
        //String nametable = entity.getClass().getSimpleName().substring(0,1).toLowerCase() + entity.getClass().getSimpleName().substring(1);
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("(");

        String [] fields = ObjectHelper.getFields(entity);

        sb.append(fields[0]);
        int i=1;
        while (i<fields.length)
        {
            sb.append(", ").append(fields[i]);
            i++;
        }
        sb.append(") VALUES (?");
        i=1;
        while (i<fields.length)
        {
            sb.append(", ?");
            i++;
        }
        sb.append(")");
        return sb.toString();
    }

    public static String createQuerySELECT(Class theclass) {
        StringBuffer sb = new StringBuffer();
        //String nametable = theclass.getClass().getSimpleName().substring(0,1).toLowerCase() + theclass.getClass().getSimpleName().substring(1);
        sb.append("SELECT * FROM ").append("pokemon.").append(theclass.getSimpleName());
        sb.append(" WHERE name = ?");

        return sb.toString();
    }

    public static String createQuerySELECTALL(Class theclass) {
        StringBuffer sb = new StringBuffer();
        //String nametable = theclass.getSimpleName().substring(0,1).toLowerCase() + theclass.getClass().getSimpleName().substring(1);
        sb.append("SELECT * FROM ").append("pokemon.").append(theclass.getSimpleName());

        return sb.toString();
    }

    public static String createQueryDELETE(Object entity){
        StringBuffer sb = new StringBuffer();
        //String nametable = entity.getClass().getSimpleName().substring(0,1).toLowerCase() + entity.getClass().getSimpleName().substring(1);
        sb.append("DELETE FROM ").append("pokemon.").append(entity.getClass().getSimpleName());
        sb.append(" WHERE name = ?");

        return sb.toString();
    }

    public static String createQueryUPDATE(Object entity){
        StringBuffer sb = new StringBuffer("UPDATE ");
        //String nametable = entity.getClass().getSimpleName().substring(0,1).toLowerCase() + entity.getClass().getSimpleName().substring(1);
        sb.append("pokemon.");
        sb.append(entity.getClass().getSimpleName()).append(" ");
        sb.append("SET ");

        String [] fields = ObjectHelper.getFields(entity);
        int i =0;
        for (String field: fields) {
            if (i<fields.length-1){
                sb.append(field);
                sb.append(" = ?, " );
            }
            else{
                sb.append(field);
                sb.append(" = ? " );
            }
            i++;
        }
        sb.append("WHERE name = ?");
        return sb.toString();
    }
}
