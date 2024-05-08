package user;

import tweet.Tweet;
import tweet.DirectMessage;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class UserAccount implements Comparable<UserAccount> {
    private String alias;
    private String email;
    private List<Tweet> tweets;
    private List<Tweet> timeline;
    private List<UserAccount> followers;
    private List<UserAccount> following;

    public UserAccount(String alias, String email) {
        if (!email.contains("@")) {
            throw new IllegalArgumentException("Invalid email");
        }
        this.alias = alias;
        this.email = email;
        this.tweets = new ArrayList<>();
        this.timeline = new ArrayList<>();
        this.followers = new ArrayList<>();
        this.following = new ArrayList<>();
    }

    public String getAlias() {
        return alias;
    }

    public String getEmail() {
        return email;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public List<Tweet> getTimeline() {
        return timeline;
    }

    public List<UserAccount> getFollowers() {
        return followers;
    }

    public List<UserAccount> getFollowing() {
        return following;
    }

    public void follow(UserAccount userToFollow) {
        if (!following.contains(userToFollow)) {
            following.add(userToFollow);
            userToFollow.getFollowers().add(this);
        } else {
            System.out.println("Ya estás siguiendo a este usuario.");
        }
    }

    public void tweet(Tweet tweet) {
        tweets.add(tweet);
        for (UserAccount follower : followers) {
            follower.getTimeline().add(tweet);
        }
    }

    public void sendDirectMessage(UserAccount receiver, String message) {
        DirectMessage dm = new DirectMessage(this, message, LocalDate.now(), receiver);
        tweets.add(dm);
    }

    @Override
    public int compareTo(UserAccount other) {
        return this.email.compareTo(other.email);
    }

    @Override
    public String toString() {
        return "Alias: " + alias + ", Email: " + email;
    }

    public String getUserInfo() {
        return "Alias: " + alias + ", Email: " + email + ", Siguiendo a: " + following.size() + ", Seguidores: " + followers.size() + ", Tweets: " + tweets.size();
    }

    public String getTweetsInfo() {
        StringBuilder tweetsInfo = new StringBuilder();
        for (Tweet tweet : tweets) {
            tweetsInfo.append(tweet.toString()).append("\n");
        }
        return tweetsInfo.toString();
    }
}