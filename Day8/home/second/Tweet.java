package Day8.home.second;

import java.time.LocalDateTime;
import java.util.HashSet;

public class Tweet {
    String subject;
    String body;
    LocalDateTime date;
    int views;
    HashSet<String> hashtags;

    public Tweet(String subject, String body, LocalDateTime date, int views, HashSet<String> hashtags) {
        this.subject = subject;
        this.body = body;
        this.date = date;
        this.views = views;
        this.hashtags = hashtags;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public HashSet<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(HashSet<String> hashtags) {
        this.hashtags = hashtags;
    }

    @Override
    public String toString() {
        return "Tweet{" +
                "subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", date=" + date +
                ", views=" + views +
                ", hashtags=" + hashtags +
                '}';
    }
}
