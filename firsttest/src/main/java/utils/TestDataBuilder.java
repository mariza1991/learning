package utils;

public class TestDataBuilder {

    private String newName;
    private String newAddress;
    private String newCity;
    private String newState;
    private String newZipCode;
    private enum newCardType {visa, amex, dinersclub};
    private String newCardNumber;
    private String newCardMonth;
    private String newCardYear;
    private String newCardName;

    public TestDataBuilder setNewName(String newName) {
        this.newName = newName;
        return this;
    }

    public String getNewName(){
        return newName;
    }

    public TestDataBuilder setNewAddress(String newAddress) {
        this.newAddress = newAddress;
        return this;
    }

    public String getNewAddress(){
        return newAddress;
    }

    public TestDataBuilder setNewCity(String newCity) {
        this.newCity = newCity;
        return this;
    }

    public String getNewCity(){
        return newCity;
    }

    public TestDataBuilder setNewState(String newState) {
        this.newState = newState;
        return this;
    }

    public String getNewState(){
        return newState;
    }

    public TestDataBuilder setNewZipCode(String newZipCode) {
        this.newZipCode = newZipCode;
        return this;
    }

    public String getNewZipCode(){
        return newZipCode;
    }

    public TestDataBuilder setNewCardNumber(String newCardNumber) {
        this.newCardNumber = newCardNumber;
        return this;
    }

    public String getNewCardNumber(){
        return newCardNumber;
    }

    public TestDataBuilder setNewCardMonth(String newCardMonth) {
        this.newCardMonth = newCardMonth;
        return this;
    }

    public String getNewCardMonth(){
        return newCardMonth;
    }

    public TestDataBuilder setNewCardYear(String newCardYear) {
        this.newCardYear = newCardYear;
        return this;
    }

    public String getNewCardYear(){
        return newCardYear;
    }

    public TestDataBuilder setNewCardName(String newCardName) {
        this.newCardName = newCardName;
        return this;
    }

    public String getNewCardName(){
        return newCardName;
    }
}
