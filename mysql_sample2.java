import java.sql.*;

public class con2Mysql {
  public static void main(String[] args) {
        String msg = "";
        try {
            // ドライバロード
            Class.forName("org.gjt.mm.mysql.Driver");

            // MySQLに接続
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "root", "hoge");

            // ステートメント生成
            Statement stmt = con.createStatement();

            // SQLを実行
            String sqlStr = "SELECT * FROM test_table";
            ResultSet rs = stmt.executeQuery(sqlStr);

            // 結果行をループ
            while(rs.next()){
                // レコードの値
                int id = rs.getInt("user_id");
                String name = rs.getString("user_name");

                //表示
                System.out.println(id + "：" + name);
            }

            // 接続を閉じる
            rs.close();
            stmt.close();
            con.close();
        }catch (ClassNotFoundException e){
            msg = "ドライバのロードに失敗しました";
            System.out.println(msg);
        }catch (Exception e){
            msg = "ドライバのロードに失敗しました";
            System.out.println(msg);
        }
    }
}