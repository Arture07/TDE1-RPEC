import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FloodFill {
    public void preencherPilha(BufferedImage img, int xInicial, int yInicial, Color cor, int salvarACada, String pasta) {
        int corFundo = img.getRGB(xInicial, yInicial);
        int corNova = cor.getRGB();

        if (corFundo == corNova) {
            return;
        }

        Pilha pilha = new Pilha();
        pilha.empilhar(new Pixel(xInicial, yInicial));

        int contador = 0;
        int frame = 0;

        while (!pilha.estaVazia()) {
            Pixel p = pilha.desempilhar();
            int x = p.getX();
            int y = p.getY();

            if (x < 0 || x >= img.getWidth() || y < 0 || y >= img.getHeight()) {
                continue;
            }
            if (img.getRGB(x, y) == corFundo) {
                img.setRGB(x, y, corNova);
                contador++;
                if (contador % salvarACada == 0) {
                    salvar(img, pasta + "/frame_" + frame + ".png");
                    frame++;
                }
                pilha.empilhar(new Pixel(x + 1, y));
                pilha.empilhar(new Pixel(x - 1, y));
                pilha.empilhar(new Pixel(x, y + 1));
                pilha.empilhar(new Pixel(x, y - 1));
            }
        }
        salvar(img, pasta + "/frame_" + frame + ".png");
    }

    public void preencherFila(BufferedImage img, int xInicial, int yInicial, Color cor, int salvarACada, String pasta) {
        int corFundo = img.getRGB(xInicial, yInicial);
        int corNova = cor.getRGB();

        if (corFundo == corNova) {
            return;
        }

        Fila fila = new Fila();
        fila.enfileirar(new Pixel(xInicial, yInicial));

        int contador = 0;
        int frame = 0;

        while (!fila.estaVazia()) {
            Pixel p = fila.desenfileirar();
            int x = p.getX();
            int y = p.getY();
            if (x < 0 || x >= img.getWidth() || y < 0 || y >= img.getHeight()) {
                continue;
            }
            if (img.getRGB(x, y) == corFundo) {
                img.setRGB(x, y, corNova);
                contador++;
                if (contador % salvarACada == 0) {
                    salvar(img, pasta + "/frame_" + frame + ".png");
                    frame++;
                }
                fila.enfileirar(new Pixel(x + 1, y));
                fila.enfileirar(new Pixel(x - 1, y));
                fila.enfileirar(new Pixel(x, y + 1));
                fila.enfileirar(new Pixel(x, y - 1));
            }
        }
        salvar(img, pasta + "/frame_" + frame + ".png");
    }

    private void salvar(BufferedImage img, String caminho) {
        try {
            ImageIO.write(img, "png", new File(caminho));
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }
}