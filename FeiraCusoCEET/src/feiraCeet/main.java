package feiraCeet;

import arquivo.ManipularArquivo;
import bancoDeDados.ConectarBanco;
import interfaces.CaminhoServidor;
import interfaces.inicial;

/**
 *
 * @author jonathan
 */
public class main {
    

    public static void main(String args[]) {
        ConectarBanco conexaoBanco = new ConectarBanco();
        ManipularArquivo arquivo = new ManipularArquivo();
        arquivo.moverAquivo();
        String caminho = arquivo.lerArquivo();
        String usuario = arquivo.lerArquivoUsurio();
        String senha = arquivo.lerArquivoSenha();

        if (arquivo.TestarArquivo("CaminhoServidor.txt")) {
            CaminhoServidor tela = new CaminhoServidor(null, true);
            tela.setVisible(true);

            caminho = arquivo.lerArquivo();
            usuario = arquivo.lerArquivoUsurio();
            senha = arquivo.lerArquivoSenha();

            inicial inicio = new inicial(caminho, usuario, senha);
                System.out.println(caminho);
            inicio.setVisible(true);

        } else {
            CaminhoServidor tela = new CaminhoServidor(null, true);
         
            tela.setVisible(true);

            caminho = arquivo.lerArquivo();
            usuario = arquivo.lerArquivoUsurio();
            senha = arquivo.lerArquivoSenha();

            conexaoBanco.criarBase();
            conexaoBanco.criarTabelas();
            inicial inicio = new inicial(caminho, usuario, senha);
            System.out.println(caminho);
            inicio.setVisible(true);
        }
    }

}
