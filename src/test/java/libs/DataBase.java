package libs;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataBase {
    private final String url = "jdbc:postgresql://pgdb/ninjaplus";
    private final String user = "postgres";
    private final String pass = "qaninja";

    private Connection connect() throws SQLException {
            return DriverManager.getConnection(url, user, pass);
    }

    public void deleteMovie(String title) {
        String SQL = "DELETE FROM public.movies WHERE title = ?;";

        try {
            PreparedStatement query = this.connect().prepareStatement(SQL);
            query.setString(1, title);
            query.executeQuery();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
        }
    }
}
