import DB.Driver;
import DB.FileReader;
import DB.helpers.Functions;

public class Main extends Driver {
    public static void main(String[] args) throws Exception{
        FileReader f = new FileReader();
        System.out.println(f.getSchema().getCreateQuery());
    }
}
