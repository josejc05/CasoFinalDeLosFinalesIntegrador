package tweet;

import user.UserAccount;
import java.time.LocalDate;

public class Tweet {
    private int id;
    private static int nextId = 0;
    private UserAccount sender;
    private String message;
    private LocalDate time;

    public Tweet(UserAccount sender, String message, LocalDate time) {
        if (message.length() > 140) {
            throw new IllegalArgumentException("Message cannot be longer than 140 characters");
        }
        this.id = nextId++;
        this.sender = sender;
        this.message = message;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public UserAccount getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Sender: " + sender + ", Message: " + message + ", Time: " + time;
    }
}