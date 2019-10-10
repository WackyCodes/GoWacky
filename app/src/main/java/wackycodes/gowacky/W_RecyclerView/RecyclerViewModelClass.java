package wackycodes.gowacky.W_RecyclerView;



public class RecyclerViewModelClass {

    private int xOfferItemImage;
    private String xOfferItemPrice, xOfferItemName;

    public RecyclerViewModelClass(int xOfferItemImage, String xOfferItemPrice, String xOfferItemName) {
        this.xOfferItemImage = xOfferItemImage;
        this.xOfferItemPrice = xOfferItemPrice;
        this.xOfferItemName = xOfferItemName;
    }

    public int getxOfferItemImage() {
        return xOfferItemImage;
    }

    public void setxOfferItemImage(int xOfferItemImage) {
        this.xOfferItemImage = xOfferItemImage;
    }

    public String getxOfferItemPrice() {
        return xOfferItemPrice;
    }

    public void setxOfferItemPrice(String xOfferItemPrice) {
        this.xOfferItemPrice = xOfferItemPrice;
    }

    public String getxOfferItemName() {
        return xOfferItemName;
    }

    public void setxOfferItemName(String xOfferItemName) {
        this.xOfferItemName = xOfferItemName;
    }
}