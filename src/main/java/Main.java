import user.UserAccount;
import tweet.Tweet;
import utils.Utils;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame {
    private JButton createUserButton;
    private JButton postTweetButton;
    private JButton followUserButton;
    private JButton exitButton;
    private List<UserAccount> users;

    public Main() {
        setTitle("Twitter App");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 1));

        users = new ArrayList<>();

        createUserButton = new JButton("Crear una cuenta de usuario");
        postTweetButton = new JButton("Publicar un tweet");
        followUserButton = new JButton("Seguir a otro usuario");
        exitButton = new JButton("Salir");

        add(createUserButton);
        add(postTweetButton);
        add(followUserButton);
        add(exitButton);

        createUserButton.addActionListener(e -> {
            String alias = JOptionPane.showInputDialog("Introduzca un alias:");
            String email = JOptionPane.showInputDialog("Introduzca un email:");
            if (Utils.isValidEmail(email) && Utils.isValidAlias(alias)) {
                users.add(new UserAccount(alias, email));
                JOptionPane.showMessageDialog(null, "La cuenta de usuario ha sido creada.");
            } else {
                JOptionPane.showMessageDialog(null, "La cuenta de usuario no es válida.");
            }
        });

        postTweetButton.addActionListener(e -> {
            if (users.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No hay usuarios disponibles.");
                return;
            }
            String alias = JOptionPane.showInputDialog("Introduzca el alias del usuario que va a publicar el tweet:");
            UserAccount user = findUserByAlias(users, alias);
            if (user == null) {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                return;
            }
            String message = JOptionPane.showInputDialog("Introduzca el mensaje del tweet:");
            Tweet tweet = new Tweet(user, message, LocalDate.now());
            user.getTweets().add(tweet);
            JOptionPane.showMessageDialog(null, "El tweet ha sido publicado.");
        });

        followUserButton.addActionListener(e -> {
            if (users.size() < 2) {
                JOptionPane.showMessageDialog(null, "No hay suficientes usuarios para seguir.");
                return;
            }
            String alias = JOptionPane.showInputDialog("Introduzca el alias del usuario que va a seguir a otro:");
            UserAccount user = findUserByAlias(users, alias);
            if (user == null) {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
                return;
            }
            String aliasToFollow = JOptionPane.showInputDialog("Introduzca el alias del usuario a seguir:");
            UserAccount userToFollow = findUserByAlias(users, aliasToFollow);
            if (userToFollow == null) {
                JOptionPane.showMessageDialog(null, "Usuario a seguir no encontrado.");
                return;
            }
            user.getFollowing().add(userToFollow);
            userToFollow.getFollowers().add(user);
            JOptionPane.showMessageDialog(null, "El usuario " + alias + " ahora está siguiendo a " + aliasToFollow);
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    private UserAccount findUserByAlias(List<UserAccount> users, String alias) {
        for (UserAccount user : users) {
            if (user.getAlias().equals(alias)) {
                return user;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}