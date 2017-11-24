import Connection.DBConnection;
import View.MyFrame;

import java.awt.*;

public class Main {
    public static void main(String []args) {

        DBConnection connect = new DBConnection("root","root","base");
        connect.initProperties();
        connect.init();

        MyFrame m = new MyFrame("Таблица студентов",new Dimension(600,400), connect);
        m.init();
    }
}
