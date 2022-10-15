package ua.happycash.database.entity.transaction.expense;

public enum ExpenseType {
    SPORT_AND_ENTERTAINMENT("Sport & Entertainment"),
    MUSIC_AND_VIDEO("Music & Video"),
    TRANSLATION("Translation"),
    FOOD_AND_DRINKS("Food & Drinks"),
    DONATIONS("Donations");

    private final String value;

    ExpenseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
