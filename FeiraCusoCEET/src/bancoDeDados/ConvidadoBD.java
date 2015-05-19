/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoDeDados;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.Aluno;
import modelos.Convidado;

/**
 *
 * @author jonathan
 */
public class ConvidadoBD extends ConectarBanco {

    public void cadastrarConvidado(int aluno, Convidado convidado) {
        try {
            conectarBanco();
            String sql = "insert into convidado (codAluno,nome,cpf,email,escolaridade,telefone,celular) values (?,?,"
                    + "?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, aluno);
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

    public ArrayList<Convidado> listarConvidadosAlunos() {
        ArrayList<Convidado> listaAlunos = new ArrayList();
        Convidado convidado;

        try {
            conectarBanco();
            String sql = "select * from aluno order by codAluno;";
            stm = con.createStatement();
            ResultSet lista = stm.executeQuery(sql);
            while (lista.next()) {
                convidado = new Convidado();
                convidado.setNome(lista.getString("nome"));
                convidado.setCpf(lista.getString("cpf"));
                convidado.setEmail(lista.getString("email"));
                convidado.setEscolaridade(lista.getString("escolarida"));
                convidado.setTelefone(lista.getString("telefone"));
                listaAlunos.add(convidado);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            desconetarBanco();
            return listaAlunos;
        }

    }

}
