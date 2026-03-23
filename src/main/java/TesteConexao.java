
import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexao {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/academia";
        String user = "root";
        String password = "200824";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao conectar");
            e.printStackTrace();
        }
    }
}