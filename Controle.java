public class Controle {
    public static boolean authenticate(String utilisateur, char[] motDePasse) {
        String motDePasseString = new String(motDePasse);
        if ("makhlouf".equals(utilisateur) && "1234".equals(motDePasseString)) {
            return true;
        } else if ("sekkal".equals(utilisateur) && "1234".equals(motDePasseString)) {
            return true;
        } else {
            return false;
        }
    }

    // Exemple d'utilisation
    public static void main(String[] args) {
        // Simulation d'une interface utilisateur
        String username = "makhlouf";
        char[] password = "1234".toCharArray();

        // Appel de la méthode d'authentification
        boolean authentificationReussie = authenticate(username, password);

        // Affichage du résultat
        if (authentificationReussie) {
            System.out.println("Authentification réussie !");
        } else {
            System.out.println("Échec de l'authentification. Veuillez vérifier vos informations.");
        }
    }
}
