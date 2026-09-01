import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();

        try {
            int xInicial = 50;
            int yInicial = 50;

            int intervaloFrames = 100;

            System.out.println("Iniciando preenchimento com Pilha...");
            BufferedImage imgPilha = ImageIO.read(new File("entrada.png"));
            
            floodFill.preencherPilha(imgPilha, xInicial, yInicial, Color.RED, intervaloFrames, "frames_pilha");
            ImageIO.write(imgPilha, "png", new File("saida_pilha.png"));
            System.out.println("Concluido com Pilha! Salvo em saida_pilha.png");

            System.out.println("Iniciando preenchimento com Fila...");
            BufferedImage imgFila = ImageIO.read(new File("entrada.png"));
            
            floodFill.preencherFila(imgFila, xInicial, yInicial, Color.BLUE, intervaloFrames, "frames_fila");
            ImageIO.write(imgFila, "png", new File("saida_fila.png"));
            System.out.println("Concluido com Fila! Salvo em saida_fila.png");

        } catch (Exception e) {
            System.out.println("Erro ao executar: " + e.getMessage());
        }
    }
}