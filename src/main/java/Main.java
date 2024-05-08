package main;

import user.UserAccount;
import tweet.Tweet;
import tweet.DirectMessage;
import tweet.Retweet;
import utils.Utils;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UserAccount> users = new ArrayList<>();

        while (true) {
            System.out.println("1. Crear una cuenta de usuario");
            System.out.println("2. Publicar un tweet");
            System.out.println("3. Seguir a otro usuario");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (option) {
                case 1:
                    System.out.print("Introduzca un alias: ");
                    String alias = scanner.nextLine();
                    System.out.print("Introduzca un email: ");
                    String email = scanner.nextLine();
                    if (Utils.isValidEmail(email) && Utils.isValidAlias(alias)) {
                        users.add(new UserAccount(alias, email));
                        System.out.println("La cuenta de usuario ha sido creada.");
                    } else {
                        System.out.println("La cuenta de usuario no es válida.");
                    }
                    break;
                case 2:
                    if (users.isEmpty()) {
                        System.out.println("No hay usuarios disponibles.");
                        break;
                    }
                    System.out.print("Introduzca el alias del usuario que va a publicar el tweet: ");
                    alias = scanner.nextLine();
                    UserAccount user = findUserByAlias(users, alias);
                    if (user == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }
                    System.out.print("Introduzca el mensaje del tweet: ");
                    String message = scanner.nextLine();
                    Tweet tweet = new Tweet(user, message, LocalDate.now());
                    user.getTweets().add(tweet);
                    System.out.println("El tweet ha sido publicado.");
                    break;
                case 3:
                    if (users.size() < 2) {
                        System.out.println("No hay suficientes usuarios para seguir.");
                        break;
                    }
                    System.out.print("Introduzca el alias del usuario que va a seguir a otro: ");
                    alias = scanner.nextLine();
                    user = findUserByAlias(users, alias);
                    if (user == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }
                    System.out.print("Introduzca el alias del usuario a seguir: ");
                    String aliasToFollow = scanner.nextLine();
                    UserAccount userToFollow = findUserByAlias(users, aliasToFollow);
                    if (userToFollow == null) {
                        System.out.println("Usuario a seguir no encontrado.");
                        break;
                    }
                    user.getFollowing().add(userToFollow);
                    userToFollow.getFollowers().add(user);
                    System.out.println("El usuario " + alias + " ahora está siguiendo a " + aliasToFollow);
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static UserAccount findUserByAlias(List<UserAccount> users, String alias) {
        for (UserAccount user : users) {
            if (user.getAlias().equals(alias)) {
                return user;
            }
        }
        return null;
    }
}