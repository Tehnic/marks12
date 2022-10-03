import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        String str = "";
        Scanner scS = new Scanner(System.in);
        Scanner scI = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option: (1) Encrypt, (2) Decrypt, (3) Exit");
            String option = scS.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Enter a string to encrypt:");
                    str = scS.nextLine();
                    System.out.println("Enter a key:");
                    int key = scI.nextInt();
                    System.out.println("Encrypted string: " + encrypt(str, key));
                    break;
                case "2":
                    System.out.println("Enter a string to decrypt:");
                    str = scS.nextLine();
                    System.out.println("Enter a key:");
                    key = scI.nextInt();
                    System.out.println("Decrypted string: " + decrypt(str, key));
                    break;
                case "3":
                    System.out.println("Exiting...");
                    scS.close();
                    scI.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static String encrypt(String str, int key) {
        String encrypted = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char c = (char) (ch + key);
                    if (c > 'Z') {
                        encrypted += (char) (ch - (26 - key));
                    } else {
                        encrypted += c;
                    }
                } else if (Character.isLowerCase(ch)) {
                    char c = (char) (ch + key);
                    if (c > 'z') {
                        encrypted += (char) (ch - (26 - key));
                    } else {
                        encrypted += c;
                    }
                }
            } else {
                encrypted += ch;
            }
        }
        return encrypted;
    }

    public static String decrypt(String str, int key) {
        String decrypted = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                if (Character.isUpperCase(ch)) {
                    char c = (char) (ch - key);
                    if (c < 'A') {
                        decrypted += (char) (ch + (26 - key));
                    } else {
                        decrypted += c;
                    }
                } else if (Character.isLowerCase(ch)) {
                    char c = (char) (ch - key);
                    if (c < 'a') {
                        decrypted += (char) (ch + (26 - key));
                    } else {
                        decrypted += c;
                    }
                }
            } else {
                decrypted += ch;
            }
        }
        return decrypted;
    }
}