package model;
/**
 * Class responsible for simulating Cup sticker and is inherited from the class Sticker
 *
 */
public class CupSticker extends Sticker{

    private String selecao;
    private String posicao;
    

    /**
     * Method responsible for returning the identity of the object "selecao" and "posicao" 
     */
    public String toString() {
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

/**
 * Constructor responsible for instantiate the class CupSticker
 * @param name
 * @param UrlImage
 * @param selecao
 * @param posicao
 */
    public CupSticker(String name, String UrlImage, String selecao, String posicao) {
        super(name, UrlImage);
        // TODO Auto-generated constructor stub
        this.selecao = selecao;
        this.posicao = posicao;

    }

    public CupSticker(){}

}
