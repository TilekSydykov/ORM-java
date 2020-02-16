package ORM.helpers;

import java.util.ArrayList;

public class QueryBuilder {
    static  private String create = "CREATE";
    static  private String select = "SELECT";
    static  private String from = "FROM";
    static  private String database = "DATABASE";
    static  private String table = "TABLE";
    static  private String insert = "INSERT";

    String query = "";

    public static QueryBuilder select(String columns){
        QueryBuilder q = new QueryBuilder();
        q.query += select + " " + columns;
        return q;
    }

    public QueryBuilder from(String tableName){
        this.query += " " + from + " `" + tableName+"`";
        return this;
    }

    public ArrayList<?> execute() throws QueryBuilderException{
        normalize();
        return new ArrayList<>();
    }

    private void normalize() throws QueryBuilderException{
        if(query.isEmpty()){
            throw new QueryBuilderException("Query is not constructed");
        }
        this.query += ";";
    }


}
