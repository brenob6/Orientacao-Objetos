package model;

public class CupSticker extends Sticker{

    private String selecao;
    private String posicao;
    

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + " selecao " + this.selecao + " posicao " + this.posicao;
    }
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


    public CupSticker(String name, String UrlImage, String selecao, String posicao) {
        super(name, UrlImage);
        // TODO Auto-generated constructor stub
        this.selecao = selecao;
        this.posicao = posicao;

    }

    public CupSticker(){}

}
