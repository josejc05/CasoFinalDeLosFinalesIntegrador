package tweet;

import user.UserAccount;
import java.time.LocalDate;

public class Retweet extends Tweet {
    private Tweet retweetedTweet;

    public Retweet(UserAccount sender, String message, LocalDate time, Tweet retweetedTweet) {
        super(sender, message, time);
        this.retweetedTweet = retweetedTweet;
    }

    public Tweet getRetweetedTweet() {
        return retweetedTweet;
    }

    @Override
    public String toString() {
        return super.toString() + ", Retweeted: " + retweetedTweet;
    }
}