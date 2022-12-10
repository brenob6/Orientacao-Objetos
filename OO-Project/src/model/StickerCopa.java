package model;

public class StickerCopa extends Sticker{

    private String selecao;
    private String posicao;
    

    public String getSelecao() {
        return selecao;
    }


    public void setSelecao(String selecao) {
        this.selecao = selecao;
    }


    public String getPosicao() {
        return posicao;
    }


    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }


    public StickerCopa(String name, String raridade, int quant, String UrlImage,
            String selecao, String posicao) {
        super(name, raridade, quant, UrlImage);
        // TODO Auto-generated constructor stub
        this.selecao = selecao;
        this.posicao = posicao;

    }

}
