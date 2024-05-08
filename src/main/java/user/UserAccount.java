package user;

import tweet.Tweet;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public int compareTo(UserAccount other) {
        return this.email.compareTo(other.email);
    }

    @Override
    public String toString() {
        return "Alias: " + alias + ", Email: " + email;
    }
}