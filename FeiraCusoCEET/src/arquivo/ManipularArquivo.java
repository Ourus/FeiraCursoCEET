package arquivo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ManipularArquivo {

    String caminho = System.getProperty("user.home") + "\\" + "banco.txt";

    File servidor = new File("CaminhoServidor.txt");
    File usuario = new File("UsuarioServidor.txt");
    File senha = new File("SenhaServidor.txt");
 
    File arquivoGeral = new File(caminho);
// metodo usado para gravar Texto no arquivo 

    public void moverAquivo() {
        try {
            File arqIn = new File("banco.txt");
            File arqOut = new File(caminho);
            if (arqIn.renameTo(arqOut)) {
                System.out.println("SUCESSO");
            } else {
                System.err.println("FALHOU");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public boolean TestarArquivo(String nome) {
        File arq = new File(nome);
        if (arq.exists()) {
            return true;
        } else {
            return false;
        }

    }

    public void gravarArquivoServidor(String tex) {

        try {

            if (servidor.exists()) {
                servidor.createNewFile();
            }

            PrintWriter guardar = new PrintWriter(servidor);

            guardar.println(tex.trim());
            guardar.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gravarArquivoUsuario(String tex) {

        try {

            if (usuario.exists()) {
                usuario.createNewFile();
            }

            PrintWriter guardar = new PrintWriter(usuario);

            guardar.println(tex.trim());
            guardar.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gravarArquivoSenha(String tex) {

        try {

            if (senha.exists()) {
                senha.createNewFile();
            }

            PrintWriter guardar = new PrintWriter(senha);

            guardar.println(tex.trim());
            guardar.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String lerArquivo() {
        
        String linha = "", texto = "";
        BufferedReader bf= null;
        try
        {
            FileReader leitor = new FileReader(servidor); // Criando um leitor para o arquivo
            bf = new BufferedReader(leitor);    // Armazenando o conteúdo obtido pelo leitor em um buffer
            
            while((linha = bf.readLine())!= null) // Enquanto houverem linhas a serem lidas no buffer...
                {
                   texto+=linha;
                }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
            {
                return texto;
            }
        
        
        
      /*  String texto = "";

        try {

            Scanner leitor = new Scanner(new FileReader(servidor)).useDelimiter("\\n");

            while (leitor.hasNext()) {
                texto += leitor.next();
            }
            System.out.println("Manipular Arquivo: " + texto );

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            return texto.trim();
        }*/
    }

    public String lerArquivoUsurio() {
        
        
    String linha = "", texto = "";
        BufferedReader bf= null;
        try
        {
            FileReader leitor = new FileReader(usuario); // Criando um leitor para o arquivo
            bf = new BufferedReader(leitor);    // Armazenando o conteúdo obtido pelo leitor em um buffer
            
            while((linha = bf.readLine())!= null) // Enquanto houverem linhas a serem lidas no buffer...
                {
                   texto+=linha;
                }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
            {
                return texto;
            }    
        
    
      /*  String textoUsurio = "";
        
        try 
        {
              Scanner leitor = new Scanner(new FileReader(usuario)).useDelimiter("\\n");
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Ocorreu um Problema: \n"+ e.getMessage());
        }
        finally
        {
            return textoUsurio.trim();
        }
*/
    }

    public String lerArquivoSenha() {
        
        
     BufferedReader bf= null;
          String linha = "", texto = "";
      try
        {
            FileReader leitor = new FileReader(senha); // Criando um leitor para o arquivo
            bf = new BufferedReader(leitor);    // Armazenando o conteúdo obtido pelo leitor em um buffer
            
            while((linha = bf.readLine())!= null) // Enquanto houverem linhas a serem lidas no buffer...
                {
                   texto+=linha;
                }
        }catch(IOException e)
        {
            e.printStackTrace();
        }finally
            {
                return texto;
            }      
        
    
       /* String textoSenha = "";

        try {

            Scanner leitor = new Scanner(new FileReader(senha)).useDelimiter("\\n");

            while (leitor.hasNext()) {
                textoSenha += leitor.next();
            }

        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            return textoSenha.trim();
        }*/
    }

}
