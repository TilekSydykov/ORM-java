package ORM.models;

import ORM.ParseException;

import java.util.ArrayList;

public class Database {
    String name;
    ArrayList<Table> tables = new ArrayList<>();

    public Database(String name, ArrayList<Table> tables) {
        this.name = name;
        this.tables = tables;
    }

    public Database() { }

    public void setName(String name) {
        this.name = name;
    }

    public void addTable(Table t){
        tables.add(t);
    }

    public String getCreateQuery() throws ParseException {
        ArrayList<String> names = new ArrayList<>();
        String query = "";
        for (Table t: tables) {
            if(names.contains(t.getName())){
                throw new ParseException("Can't create two table with same names : Table name -> " + t.getName() );
            }
            names.add(t.getName());
            query = query.concat(t.create()).concat(";\n");
        }

        return query;
    }

    @Override
    public String toString() {
        return "Database{" +
                "name='" + name + '\'' +
                ", tables=" + tables +
                '}';
    }
}
