package cashregister;

public class FakePurchase extends Purchase {
    public String getPurchaseString() {
        return purchaseString;
    }

    private String purchaseString;

    public FakePurchase(Item[] items) {
        super(items);
    }

    @Override
    public String asString() {
        return super.asString();
    }

    public void setPurchaseString(String purchaseString){
        this.purchaseString = purchaseString;
    }


}
