package Day08.home.second;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Stream;

public class Tweeter {


    public static LocalDateTime generateRandomDateTime() {
        // Generate date range between 5 years ago and now
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime fiveYearsAgo = now.minus(5, ChronoUnit.YEARS);
        long startEpoch = fiveYearsAgo.toEpochSecond(ZoneOffset.UTC);
        long endEpoch = now.toEpochSecond(ZoneOffset.UTC);
        long randomEpoch = ThreadLocalRandom.current().nextLong(startEpoch, endEpoch);
        return LocalDateTime.ofEpochSecond(randomEpoch, 0, ZoneOffset.UTC);
    }

    public static HashSet<String> getHashtags(int numOfHashtags) {
        Random random = new Random();
        HashSet<String> hashtags = new HashSet<>();
        for (int i = 0; i < numOfHashtags; i++) {
            hashtags.add("#Hashtag-" + random.nextInt(20));
        }
        return hashtags;
    }

    public static Tweet getTweet() {
        Random random = new Random();
        String subject = "Tweet-" + random.nextInt(100);
        String body = "Tweet body-" + random.nextInt(100);
        LocalDateTime date = generateRandomDateTime();
        int views = random.nextInt(12000);
        HashSet<String> hashtags = getHashtags(1 + random.nextInt(5));
        return new Tweet(subject, body, date, views, hashtags);
    }

    public static ArrayList<Tweet> getTweets(int numOfTweets) {
        ArrayList<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < numOfTweets; i++) {
            tweets.add(getTweet());
        }
        return tweets;
    }


    public static ArrayList<Tweet> getTweetsBySubject(ArrayList<Tweet> tweets, String subject) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getSubject().equals(subject)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTweetsByHashtag(ArrayList<Tweet> tweets, String hashtag) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getHashtags().contains(hashtag)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTweetsByViews(ArrayList<Tweet> tweets, int views) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getViews() > views).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTweetsByDate(ArrayList<Tweet> tweets, LocalDateTime date) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getDate().isAfter(date)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTweetsByDateRange(ArrayList<Tweet> tweets, LocalDateTime fromDate, LocalDateTime toDate) {
        Stream<Tweet> stream = tweets.stream();
        return stream.filter(tweet -> tweet.getDate().isAfter(fromDate) && tweet.getDate().isBefore(toDate)).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static ArrayList<Tweet> getTrendingTweets(ArrayList<Tweet> tweets) {
        ArrayList<Tweet> recentOneMonthTweets = getTweetsByDateRange(tweets, LocalDateTime.now().minusMonths(1), LocalDateTime.now());
        Stream<Tweet> stream = recentOneMonthTweets.stream();
        return stream.sorted((t1, t2) -> Integer.compare(t2.getViews(), t1.getViews())).limit(5).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public static void printTweets(ArrayList<Tweet> tweets) {
        tweets.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ArrayList<Tweet> tweets = getTweets(200);

        printTweets(tweets);

        // 3. Count the tweets by Subject
        System.out.println("\nTweets by Subject");
        ArrayList<Tweet> tweetsBySubject = getTweetsBySubject(tweets, "Tweet-1");
        printTweets(tweetsBySubject);

        // 2. List all the tweets for a hashtag
        System.out.println("\nTweets by Hashtag");
        ArrayList<Tweet> tweetsByHashtag = getTweetsByHashtag(tweets, "#Hashtag-1");
        printTweets(tweetsByHashtag);

        // 5. List the tweets that got more than 10k views
        System.out.println("\nTweets by Views");
        ArrayList<Tweet> tweetsByViews = getTweetsByViews(tweets, 10000);
        printTweets(tweetsByViews);

        // 1. List all the tweets that are posted in current month
        System.out.println("\nTweets of Current Month");
        ArrayList<Tweet> tweetsByDate = getTweetsByDate(tweets,
                LocalDateTime.now().minusDays(LocalDateTime.now().getDayOfMonth()));
        printTweets(tweetsByDate);

        // 6. Print the top 5 trending tweets
        System.out.println("\nTrending Tweets");
        ArrayList<Tweet> trendingTweets = getTrendingTweets(tweets);
        printTweets(trendingTweets);
    }
}
