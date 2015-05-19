
package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Aluno;

/**
 *
 * @author jonathan
 */
public class AlunoBD extends ConectarBanco
{
    public int cadastrarAluno (Aluno aluno)
    {
        int key=0;
        try 
        {
            conectarBanco();
            String sql="insert into aluno (nome,curso) values (?,?)";
            PreparedStatement stm = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,aluno.getNomeAluno());
            stm.setString(2, aluno.getCurso());
            stm.executeUpdate();
              ResultSet codPessoa = stm.getGeneratedKeys();
            while (codPessoa.next()) 
            {
                key = codPessoa.getInt(1);
            }
            JOptionPane.showMessageDialog(null, "Aluno: "+aluno.getNomeAluno()+"");
            
        } catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconetarBanco();
            return key;
        }
    }
    
    public ArrayList <Aluno> listarAlunosCadastrados()
    {
        ArrayList <Aluno> listaAlunos = new ArrayList();
        Aluno aluno;
        
        try 
        {
            conectarBanco();
            String sql= "select * from aluno order by nome;";
            stm = con.createStatement();
            ResultSet lista = stm.executeQuery(sql);
            while (lista.next())
            {
                aluno = new Aluno();
                aluno.setCodAluno(lista.getInt("codAluno"));
                aluno.setNomeAluno(lista.getString("nome"));
                listaAlunos.add(aluno);
                           
            }
            
        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        finally
        {
            desconetarBanco();
            return listaAlunos;
        }
        
        
    }
    
   
}
