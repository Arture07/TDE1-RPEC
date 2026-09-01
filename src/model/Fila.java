public class Fila {
    private No inicio;
    private No fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public void enfileirar(Pixel pixel) {
        No novoNo = new No(pixel);
        if (estaVazia()) {
            inicio = novoNo;
        } else {
            fim.setProximo(novoNo);
        }
        fim = novoNo;
    }

    public Pixel desenfileirar() {
        if (estaVazia()) {
            return null;
        }
        Pixel pixelRemovido = inicio.getPixel();
        inicio = inicio.getProximo();
        
        if (inicio == null) {
            fim = null;
        }
        return pixelRemovido;
    }

    public boolean estaVazia() {
        return inicio == null;
    }
}