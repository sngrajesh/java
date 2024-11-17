package Day06.labs.second;

import java.util.ArrayList;
import java.util.List;

public class MediaPlayer {


    public void playMedia(List<? extends Media> mediaList) {
        /*
        After adding wild card, the compiler will not allow to modify the list
        mediaList.add(new Songs(1, "Song 1"));      // Error
        mediaList.add(new Video(1, "Video 1"));     // Error
        */
        for (Media media : mediaList) {
            media.play();
        }
    }

    public static void main(String[] args) {
        MediaPlayer mediaPlayer = new MediaPlayer();


        List<Songs> mediaList = new ArrayList<>();
        mediaList.add(new Songs(589, "W2Bx5tYn"));
        mediaList.add(new Songs(430, "WSvHozrD"));
        mediaList.add(new Songs(659, "Onsi1Trv"));

        mediaPlayer.playMedia(mediaList);

        List<Video> mediaList1 = new ArrayList<>();
        mediaList1.add(new Video(578, "HmqOOq1RQP"));
        mediaList1.add(new Video(763, "U8ozdWHv"));
        mediaList1.add(new Video(664, "5S4NfX1"));

        mediaPlayer.playMedia(mediaList1);
    }
}
