import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;




public class SistemaAcademia {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/academia";
        String user = "root";
        String password = "200824";

        int opcao;

        do {
            System.out.println("\n1 - Cadastrar aluno");
            System.out.println("2 - Deletar aluno");
            System.out.println("3 - atualizar aluno");
            System.out.println("4 - Sair");
            opcao = in.nextInt();
            in.nextLine(); // limpar buffer

            if (opcao == 1) {

                System.out.println("Nome:");
                String nome = in.nextLine();

                System.out.println("Idade:");
                int idade = in.nextInt();
                in.nextLine();

                System.out.println("Cpf");
                String cpf = in.nextLine();

                try {
                    Connection conn = DriverManager.getConnection(url, user, password);

                    String sql = "INSERT INTO alunos (nome, idade , cpf) VALUES (?, ? , ?)";
                    PreparedStatement stmt = conn.prepareStatement(sql);

                    stmt.setString(1, nome);
                    stmt.setInt(2, idade);
                    stmt.setString(3, cpf);

                    stmt.executeUpdate();

                    System.out.println("Aluno cadastrado no banco!");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (opcao == 2) {

                System.out.println("Digite o ID do aluno para deletar:");
                int id = in.nextInt();

                try {
                    Connection conn = DriverManager.getConnection(url, user, password);

                    String sql = "DELETE FROM alunos WHERE id = ?";
                    PreparedStatement stmt = conn.prepareStatement(sql);

                    stmt.setInt(1, id);

                    stmt.executeUpdate();

                    System.out.println("Aluno deletado com sucesso!");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (opcao == 3) {
                System.out.println("digite o id do aluno");
                int id = in.nextInt();
                in.nextLine();

                System.out.println("Novo nome");
                String nome = in.nextLine();

                System.out.println("Nova idade");
                int idade = in.nextInt();
                in.nextLine();

                System.out.println("Novo cpf");
                String cpf = in.nextLine();

                try {
                    Connection conn = DriverManager.getConnection(url, user, password);
                    String sql = "UPDATE alunos SET nome = ?, idade = ?, cpf = ? WHERE id = ?";
                    PreparedStatement stmt = conn .prepareStatement(sql);
                    stmt.setString(1, nome);
                    stmt.setInt(2, idade);
                    stmt.setString(3, cpf);
                    stmt.setInt(4, id);

                    stmt.executeUpdate();
                    System.out.println("aluno atualizado com sucesso");


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }



            } while (opcao != 4) ;

            System.out.println("Sistema encerrado.");
        }
    }








