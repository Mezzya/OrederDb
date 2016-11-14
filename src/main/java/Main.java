import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by User on 13.11.2016.
 */
public class Main {



    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_zakaz","root", "root");

        BaseOrder bo = new BaseOrder(connection);

        while (true) {
            System.out.println();
            System.out.println("1 List of users");
            System.out.println("2 List of products");
            System.out.println("3 List of orders");
            System.out.println("4 New Order");
            System.out.println("5 Exit");
            System.out.print(":");
            String str="1";


            try {
                switch (br.readLine()){

                    case ("1"):
                        bo.viewTable("clients");
                        break;
                    case ("2"):
                        bo.viewTable("product");
                        break;
                    case ("3"):
                        bo.viewTable("orders");
                        break;



                    case ("5"):
                        return;

                    default:
                        System.out.println("Must be int from 1 to 5");

                    }
            } catch (IOException e) {
                System.out.println(e);
            }



        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
