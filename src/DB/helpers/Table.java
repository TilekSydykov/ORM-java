package DB.helpers;

import DB.ParseException;

import java.util.ArrayList;

public class Table {
    String name;
    ArrayList<Column> columns = new ArrayList<>();

    public Table(String name, ArrayList<Column> columns) {
        this.name = name;
        this.columns = columns;
    }

    public Table() {}

    public String create() throws ParseException {
        String name = Functions.normalizeName(this.name);
        String query = String.format("CREATE TABLE %s{@columns}", name);
        String cols = "";

        for (Column c: columns) {
            cols += c.getQuery() + ",";
        }

        cols = cols.substring(0, cols.length() - 1);

        return query.replace("@column", cols);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addColumn(Column c){
        columns.add(c);
    }

    @Override
    public String toString() {
        return "\nTable{" +
                "name='" + name + '\'' +
                ", columns=" + columns +
                "}";
    }

    public String getName() {
        return name;
    }
}
