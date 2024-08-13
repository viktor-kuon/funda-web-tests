package nl.funda.helpers;

public class Home {

    private String postalCode;
    private int houseNumber;
    private String street;
    private String city;
    private int yearOfConstruction;
    private float livingArea;

    public Home(final String postalCode,
                final int houseNumber,
                final String street,
                final String city,
                final int yearOfConstruction,
                final float livingArea
    ) {
        this.postalCode = postalCode;
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.yearOfConstruction = yearOfConstruction;
        this.livingArea = livingArea;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getYearOfConstruction() {
        return yearOfConstruction;
    }

    public float getLivingArea() {
        return livingArea;
    }

    public String getFullAddress() {
        return String.format("%s %d, %s %s", street, houseNumber, postalCode, city);
    }
}
