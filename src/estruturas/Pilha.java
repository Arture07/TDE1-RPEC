package estruturas;

import model.Pixel;

public class Pilha {
    private No topo;

    public Pilha() {
        this.topo = null;
    }

    public void empilhar(Pixel pixel) {
        No novoNo = new No(pixel);
        novoNo.setProximo(topo);
        topo = novoNo;
    }

    public Pixel desempilhar() {
        if (estaVazia()) {
            return null;
        }
        Pixel pixelRemovido = topo.getPixel();
        topo = topo.getProximo();
        return pixelRemovido;
    }

    public boolean estaVazia() {
        return topo == null;
    }
}
