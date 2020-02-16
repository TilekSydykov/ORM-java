package ORM.helpers;

import ORM.ParseException;

public class Functions {
    public static String normalizeName(String name){
        String nName = "";
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if(64 < c && c < 91){
                nName = nName+'_'+Character.toLowerCase(c);
            }else {
                nName = nName+c;
            }
        }
        return nName;
    }

    public static String normalizeType(String type) throws ParseException{
        String nType = "";
        switch (type){
            case "int":
            case "date":
            case "Date":
                nType = "int(11)";
                break;
            case "String":
            case "string":
                nType = "varchar(1024)";
                break;
            case "longstring":
            case "longString":
                nType = "varchar(65536)";
                break;
            case "boolean":
                nType = "tinyint(1)";
                break;
            default:
                throw new ParseException("type not found in schema");
        }
        return nType;
    }
}
