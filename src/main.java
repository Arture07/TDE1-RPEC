import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import servico.FloodFill;

public class Main {
    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();

        try {
            File arquivoEntrada = new File("entrada.png");
            if (!arquivoEntrada.exists()) {
                System.out.println("Arquivo 'entrada.png' nao encontrado. Gerando imagem de teste...");
                gerarImagemExemplo(arquivoEntrada);
            }

            int xInicial = 30;
            int yInicial = 70;
            int intervaloFrames = 50;

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

            System.out.println("\nProcessamento finalizado!");
            System.out.println("- Imagem de saida da Pilha: saida_pilha.png");
            System.out.println("- Imagem de saida da Fila: saida_fila.png");
            System.out.println("- Frames salvos nas pastas 'frames_pilha' e 'frames_fila'");

        } catch (Exception e) {
            System.out.println("Erro ao executar: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void gerarImagemExemplo(File arquivoDestino) {
        try {
            int largura = 120;
            int altura = 120;
            BufferedImage img = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = img.createGraphics();

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, largura, altura);

            g.setColor(Color.BLACK);
            g.drawRect(10, 10, 100, 100);
            g.drawLine(10, 10, 110, 110);

            g.dispose();
            ImageIO.write(img, "png", arquivoDestino);
            System.out.println("Imagem de teste criada: entrada.png (120x120)");
        } catch (Exception e) {
            System.out.println("Erro ao gerar imagem de teste: " + e.getMessage());
        }
    }
}