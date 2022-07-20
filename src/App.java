import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        // fazer a conexao HTTPs e buscar o top250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD";

        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // exibir e manipular dados
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDaNasa();
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoDaIMDB();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        
        var geradora = new GeradoraDeFigurinhas();

        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream InputStream = new URL(conteudo.getUrlImagem()).openStream();
            
            // String nomeArquivo = "saida/" + conteudo.getTitulo();
            String nomeArquivo = conteudo.getTitulo().replace(":","-");
            geradora.cria(InputStream, nomeArquivo);

            // System.out.println(conteudo.getTitulo());
            System.out.println(nomeArquivo);
            
            
        }

    }
}
