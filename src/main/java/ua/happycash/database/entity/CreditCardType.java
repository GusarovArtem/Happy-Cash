package ua.happycash.database.entity;

public enum CreditCardType {
    VISA("VISA"),
    MASTER_CARD("MasterCard"),
    WEB_MONEY("WebMoney"),
    PAY_PAL("PayPal");

    private final String value;

    CreditCardType(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
