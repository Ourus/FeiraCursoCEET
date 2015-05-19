package bancoDeDados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author jonathan
 */
public class ConectarBanco {

    String driver = "com.mysql.jdbc.Driver";
    String caminho = "jdbc:mysql://localhost:3306/feira_de_curso";
    String usuario = "root";
    String senha = "root";
    Connection con;
    Statement stm;

    public void conectarBanco() {
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void desconetarBanco() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public void criarBase()
    {
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", usuario, senha);
            
            System.out.println("Conexao criada "+con);
            
            String sql = "create database if not exists feira_de_curso;";
            
            stm = con.createStatement();
            
            stm.execute(sql);
        }catch(Exception e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }finally
                {
                    desconetarBanco();
                }
    }
    
    public void criarTabelas()
    {
        try
        {
            con = DriverManager.getConnection(caminho, usuario, senha);
            
            System.out.println("Conexao criada "+con);
            
            String sql =  "create table if not exists feira_de_curso.aluno (" +
                        "codAluno int unsigned not null auto_increment," +
                        "nome varchar(80)," +
                        "curso varchar(50)," +
                        "primary key (codAluno)" +
                        ");" ;
                
            String sql2 =  "create table if not exists feira_de_curso.convidado (\n" +
                        "codAluno int unsigned not null,\n" +
                        "nome varchar(80) not null,\n" +
                        "cpf varchar (15) not null,\n" +
                        "email varchar(90),\n" +
                        "escolaridade varchar(20),\n" +
                        "telefone varchar(15),\n"
                      + "celular varchar(20)," +
                        "foreign key (codAluno) references feira_de_curso.aluno (codAluno),\n" +
                        "primary key (cpf)" +
                        ");";
            stm = con.createStatement();
            
            stm.execute(sql);
            stm.execute(sql2);
        }catch(Exception e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }finally
                {
                    desconetarBanco();
                }
    }

}
