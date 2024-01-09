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

    
    public static void main(String[] args) {
       
    }
}
