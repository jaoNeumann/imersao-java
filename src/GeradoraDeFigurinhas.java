import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
    

    /** @throws IOException */

    public void cria(InputStream InputStream ,String nomeArquivo ) throws Exception {

        // ler a imagem
        // InputStream InputStream = new FileInputStream( new File("entrada/filme.jpg"));
        // InputStream InputStream = new URL("https://br.web.img2.acsta.net/medias/nmedia/18/91/54/04/20150812.jpg").openStream();
        BufferedImage imagemOriginal = ImageIO.read(InputStream);
        
        // cria nova imagem com transparencia e redimensionada
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        
        // copiar imagem original pra novo imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);
        
        // *config fonte
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 72);
        graphics.setFont(fonte);
        graphics.setColor(Color.YELLOW);
        
        // *escrever uma frase na nova imagem
        graphics.drawString("ÓTIMO !!!", largura / 3 , novaAltura - 100);

        String path = "../saida/";
        // ImageIO.write(novaImagem, "png", new File(path+nomeArquivo + ".png"));

        // *salvar no caminho
        ImageIO.write(novaImagem, "png", new File(path + nomeArquivo + ".png"));
    }
    public static void main(String[] args) throws Exception {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria(null, null);
    }
}