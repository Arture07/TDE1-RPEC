public class No {
    private Pixel pixel;
    private No proximo;

    public No(Pixel pixel) {
        this.pixel = pixel;
        this.proximo = null;
    }

    public Pixel getPixel() {
        return pixel;
    }

    public void setPixel(Pixel pixel) {
        this.pixel = pixel;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }
}