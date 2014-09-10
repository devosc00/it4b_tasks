package com.task;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by rafa on 09.09.14.
 */
public class T1 {
   public T1 () {
    }

public static Connection connectToDatabase(List<int[]> v, String sekcja, List<Integer> pozycje) {

        Connection conn = null;

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost/it4b";
            conn = DriverManager.getConnection(url, "postuser1", "postpass1");
            Statement st = conn.createStatement();
            String clean = "delete from tab";
            st.executeUpdate(clean);
            String cleanInfo = "delete from info";
            st.executeUpdate(cleanInfo);


            for (int[] s : v){
                String ins;
                for (int i : s) {
                    ins = "insert into tab values" + "(" + s[i] + ")";
                    st.executeUpdate(ins);
//                    System.out.println(ins);
                }
            }
            for(int i = 0; i < pozycje.size(); i++) {
                String ins1 = "insert into info values(" + sekcja.replaceAll("\\D", "") + " , " + pozycje.get(i) + ")";
                st.executeUpdate(ins1);
//              System.out.println(ins1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        }
        return conn;

}

}