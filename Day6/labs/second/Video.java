package Day6.labs.second;

public class Video extends Media {
    private int videoId;
    private String title;

    public Video() {
        this.title = "";
    }

    Video(int videoId, String title) {
        this.videoId = videoId;
        this.title = title;
    }

    public int getVideoId() {
        return videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void play() {
        System.out.println("Playing Video: " + title);
    }


    @Override
    public String toString() {
        return "Id: " + videoId + " | Title: " + title;
    }

}
