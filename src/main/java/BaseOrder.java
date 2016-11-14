import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

/**
 * Created by User on 13.11.2016.
 */
public class BaseOrder {
    Connection conn;



    public BaseOrder(Connection connection) {
        conn = connection;
    }



    public void addOrder()
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in);
        System.out.println("NEW ORDER PREPARE");
        System.out.println("Enter user id:");
        try {
            String user_id = br.readLine();
            System.out.println("Enter product id");
            String product_id = br.readLine();
            PreparedStatement st = conn.prepareStatement("INSERT INTO orders user_id, product_id, col VALUE (?,?,?)");
            st.setInt(1, Integer.parseInt(user_id));
            st.setString(1,"1");




        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }


    public void viewTable(String table)
    {
        try {
            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM "+table);

            ResultSetMetaData rsmd = rs.getMetaData();

            for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                System.out.print(rsmd.getColumnName(i)+"\t\t");
            }
            System.out.println();

            while (rs.next())
            {
                for (int i = 1; i <= rsmd.getColumnCount() ; i++) {
                    System.out.print(rs.getString(i)+"\t\t");
                }
                System.out.println("");

            }


            System.out.println("");


        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
}
