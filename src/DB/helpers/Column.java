package DB.helpers;

import DB.ParseException;

public class Column {
    String name;
    String type;
    boolean isAutoIncrement = false;
    boolean isNull = true;
    boolean isPrimary = false;
    String defaultValue;

    public Column(String name, String type, boolean isAutoIncrement, boolean isNull, boolean isPrimary, String defaultValue) {
        this.name = name;
        this.type = type;
        this.isAutoIncrement = isAutoIncrement;
        this.isNull = isNull;
        this.isPrimary = isPrimary;
        this.defaultValue = defaultValue;
    }

    public Column() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        isAutoIncrement = autoIncrement;
    }

    public void setNull(boolean aNull) {
        isNull = aNull;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getQuery() throws ParseException{
        String name = Functions.normalizeName(this.name);
        String type = Functions.normalizeType(this.type);
        String n = (isNull ? "NULL ": "");
        String primary = (isPrimary ? "PRIMARY KEY ": "");
        String def = (defaultValue.isEmpty() ? "": "DEFAULT \""+defaultValue+"\"" );
        return String.format(" %s %s %s%s%s", name, type, n, primary, def);
    }

    @Override
    public String toString() {
        return "\n\tColumn{" +
                "name=" + name +
                ", type=" + type +
                ", isAutoIncrement=" + isAutoIncrement +
                ", isNull=" + isNull +
                ", isPrimary=" + isPrimary +
                ", defaultValue='" + defaultValue + "'"+
                '}';
    }
}
