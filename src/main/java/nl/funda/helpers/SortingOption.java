package nl.funda.helpers;

public enum SortingOption {

    PRICE_LOW_TO_HIGH("price_up"),
    PRICE_HIGH_TO_LOW("price_down"),
    RELEVANCY("relevancy");

    private final String value;

    SortingOption(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
