
package modelos;

import java.util.ArrayList;

/**
 *
 * @author jonathan
 */
public class Aluno 
{
    private int codAluno;
    private String nomeAluno;
    private String curso;
    private ArrayList<Convidado> convidado= new ArrayList();

    public int getCodAluno() {
        return codAluno;
    }

    public void setCodAluno(int codAluno) {
        this.codAluno = codAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public ArrayList<Convidado> getConvidado() {
        return convidado;
    }
    
    
    public void setConvidado(ArrayList<Convidado> convidado) {
        this.convidado = convidado;
    }
    public void setConvidado(Convidado convidado) {
        this.convidado.add(convidado);
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
    
}
