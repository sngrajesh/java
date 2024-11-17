package Day06.labs.second;

public class Songs extends Media {
    private int songId;
    private String title;

    public Songs() {
        this.title = "";
    }

    Songs(int songId, String title) {
        this.songId = songId;
        this.title = title;
    }

    public int getSongId() {
        return songId;
    }

    public String getTitle() {
        return title;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing Song: " + title);
    }


    @Override
    public String toString() {
        return "Id: " + songId + " | Title: " + title;
    }
}
