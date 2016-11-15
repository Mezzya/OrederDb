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
        BaseOrder bo = null;

        try {
            bo = new BaseOrder();
        } catch (SQLException e) {
            System.out.println("Cannot connect to MySQL. Terminate program...");
            return;
        }

        while (true) {
            System.out.println();
            System.out.println("1 List of users");
            System.out.println("2 Add new user");
            System.out.println("3 List of products");
            System.out.println("4 Add new product");
            System.out.println("5 List of orders");
            System.out.println("6 New Order");
            System.out.println("7 Exit");
            System.out.print(":");



            try {
                switch (br.readLine()){

                    case ("1"):
                        bo.viewTable("clients");
                        break;
                    case ("3"):
                        bo.viewTable("product");
                        break;
                    case ("5"):
                        bo.viewTable("orders");
                        break;
                    case ("6"):
                        bo.addNewItem("orders");
                        break;
                    case ("2"):
                        bo.addNewItem("clients");
                        break;
                    case ("4"):
                        bo.addNewItem("product");
                        break;



                    case ("7"):
                        return;

                    default:
                        System.out.println("Must be int from 1 to 7");

                    }
            } catch (IOException e) {
                System.out.println(e);
            }



        }


    }


}
