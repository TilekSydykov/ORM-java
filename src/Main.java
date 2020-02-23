import ORM.Driver;
import ORM.FileReader;

public class Main extends Driver {
    public static void main(String[] args) throws Exception{
        FileReader f = new FileReader();

        System.out.println(f.getConfig());
        System.out.println(f.getSchema().getCreateQuery());
    }
}
