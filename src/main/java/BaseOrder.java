import com.mysql.jdbc.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

/**
 * Created by User on 13.11.2016.
 */
public class BaseOrder {
    private Connection conn;



    public BaseOrder() throws SQLException {
        conn =  DriverManager.getConnection("jdbc:mysql://10.35.1.248:3306/db_zakaz","root", "root");

    }


    public void addNewItem(String table)
    {
        System.out.println("Add new Item to :"+table);
        Statement st = null;
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM "+table);

            ResultSetMetaData rsmd = rs.getMetaData();



            String req = "INSERT INTO "+table+" (";
            String val = ") VALUE (";
            for (int i = 2; i <= rsmd.getColumnCount(); i++) {

                req+=rsmd.getColumnName(i);
                val+="?";
                if (i<rsmd.getColumnCount())
                {
                    req+=", ";
                    val+=", ";
                }
            }

            req+=val+")";
//            System.out.println(req);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            PreparedStatement ps = conn.prepareStatement(req);


            for (int i = 2; i <= rsmd.getColumnCount() ; i++) {

                    System.out.println("Enter "+rsmd.getColumnName(i));
                    String param = br.readLine();
                    ps.setString(i-1,param);



            }

            ps.execute();





        } catch (SQLException | IOException e) {
            System.out.println("Чтото пошло не так. Попробуйте еще разок");
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
