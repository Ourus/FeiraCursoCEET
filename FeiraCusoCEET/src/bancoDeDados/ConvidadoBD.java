
package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Turma;
import modelos.Convidado;
import modelos.Resultado;

/**
 *
 * @author jonathan
 */
public class ConvidadoBD extends ConectarBanco {

    public void cadastrarConvidado(Turma turma, Convidado convidado,String cami,String usuario,String senha) {
        try {
            conectarBanco(cami, usuario, senha);
            String sql = "insert into convidado (codCurso,nome,cpf,email,escolaridade,telefone,celular) values (?,?,"
                    + "?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, turma.getCodCurso());
            stm.setString(2, convidado.getNome());
            stm.setString(3, convidado.getCpf());
            stm.setString(4, convidado.getEmail());
            stm.setString(5, convidado.getEscolaridade());
            stm.setString(6, convidado.getTelefone());
             stm.setString(7, convidado.getCelular());

            stm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Convidado: " + convidado.getNome() + "");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconetarBanco();
        }
    }
    
    public ArrayList<Convidado> listarConvidadosAlunos(String cami,String usuario,String senha) {
        ArrayList<Convidado> listaAlunos = new ArrayList();
        Convidado convidado;

        try {
            conectarBanco(cami, usuario, senha);
            String sql = "select * from feira_de_curso.convidado;";
            stm = con.createStatement();
            ResultSet lista = stm.executeQuery(sql);
            while (lista.next()) {
                convidado = new Convidado();
                convidado.setNome(lista.getString("nome"));
                convidado.setCpf(lista.getString("cpf"));
                convidado.setEmail(lista.getString("email"));
                convidado.setEscolaridade(lista.getString("escolaridade"));
                convidado.setTelefone(lista.getString("telefone"));
                convidado.setCelular(lista.getString("celular"));
                listaAlunos.add(convidado);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconetarBanco();
            return listaAlunos;
        }

    }
    
   public ArrayList<Resultado> listarResultado(String cami,String usuario,String senha)
   {
        ArrayList<Resultado> listaConvidadosResultados = new ArrayList();
        Resultado resultado;

        try {
            conectarBanco(cami, usuario, senha);
            String sql = " select  cu.nome, cu.turno, count(co.cpf) cpf from  feira_de_curso.curso cu,feira_de_curso.convidado co\n" +
" where cu.codCurso = co.codCurso group by cu.nome,cu.turno order by cpf desc;";
            stm = con.createStatement();
            ResultSet lista = stm.executeQuery(sql);
            while (lista.next()) {
                resultado = new Resultado();
                
                resultado.setNomeCurso(lista.getString("nome"));
                resultado.setTurno(lista.getString("turno"));
                resultado.setNumeroConviado(lista.getInt("cpf"));
               
                
                listaConvidadosResultados.add(resultado);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconetarBanco();
            return listaConvidadosResultados;
        }

       
   }
}
