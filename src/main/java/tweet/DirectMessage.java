package tweet;

import user.UserAccount;
import java.time.LocalDate;

public class DirectMessage extends Tweet {
    private UserAccount receiver;

    public DirectMessage(UserAccount sender, String message, LocalDate time, UserAccount receiver) {
        super(sender, message, time);
        this.receiver = receiver;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    @Override
    public String toString() {
        return super.toString() + ", Receiver: " + receiver;
    }
}