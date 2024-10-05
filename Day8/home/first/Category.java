package Day8.home.first;

public enum Category {
    EDUCATIONAL("Educational"),
    GAMES("Games"),
    HOME("Home"),
    BATTERYOPERATED("Battery Operated");

    String category;

    Category(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
