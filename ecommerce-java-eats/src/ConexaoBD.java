import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexaoBD {
    // Logger para registrar mensagens de erro e informações
    private static final Logger logger = Logger.getLogger(ConexaoBD.class.getName());
    // Constantes para URL, usuário e senha do banco de dados
    private static final String URL = "jdbc:sqlite:src/bancoDados/EcommerceDataBase.db"; // URL do banco
    private static final String USER = "root@localhost"; // Usuário do banco
    private static final String SENHA = "root@localhost"; // Senha do banco
    // Objeto Connection para gerenciar a conexão com o banco
    private static Connection conexao;

    /**
     * Obtém uma conexão com o banco de dados.
     *
     * @return A conexão com o banco de dados.
     */
    public static Connection obterConexao() {
        try {
            // Verifica se a conexão é nula ou está fechada antes de tentar estabelecer uma nova conexão
            if (conexao == null || conexao.isClosed()) {
                conexao = DriverManager.getConnection(URL, USER, SENHA);
            }
        } catch (SQLException e) {
            // Loga o erro e exibe uma mensagem detalhada
            logger.log(Level.SEVERE, "Não foi possível estabelecer uma conexão com o banco de dados.", e);
            // Opcional: lançar uma exceção ou retornar null
            return null;
        }
        return conexao;
    }

    /**
     * Fecha a conexão com o banco de dados.
     */
    public static void fecharConexao() {
        try {
            // Verifica se a conexão não é nula e não está fechada antes de tentar fechá-la
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch (SQLException e) {
            // Loga o erro ao tentar fechar a conexão
            logger.log(Level.SEVERE, "Não foi possível fechar a conexão com o banco de dados.", e);
        }
    }
}
