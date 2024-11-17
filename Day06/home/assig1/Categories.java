package Day06.home.assig1;

public enum Categories {
    EDUCATIONAL("Educational"),
    GAMES("Games"),
    HOME("Home"),
    BATTERYOPERATED("Battery Operated");

    String category;

    Categories(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
