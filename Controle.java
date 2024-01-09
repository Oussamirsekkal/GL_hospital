import models.utilisateur;

public class Controle {
   
    public static boolean authenticate(String utilisateur, char[] motDePasse) {
        utilisateur utilisateur1 = new utilisateur();
        utilisateur1.setUtilisateurId(1);
        utilisateur1.setUsername("makhlouf");
        utilisateur1.setPasswordHash("1234");
        utilisateur1.setEmail("utilisateur1@example.com");
        utilisateur1.setFullName("Nom Complet 1");
        utilisateur1.setDateOfBirth("01/01/1990");

        utilisateur utilisateur2 = new utilisateur();
        utilisateur2.setUtilisateurId(2);
        utilisateur2.setUsername("sekkal");
        utilisateur2.setPasswordHash("1234");
        utilisateur2.setEmail("utilisateur2@example.com");
        utilisateur2.setFullName("Nom Complet 2");
        utilisateur2.setDateOfBirth("02/02/1995");
        String motDePasseString = new String(motDePasse);
        if (utilisateur1.getUsername().equals(utilisateur) && utilisateur1.getPassword().equals(motDePasseString)) {
            return true;
        } else if (utilisateur2.getUsername().equals(utilisateur) && utilisateur2.getPassword().equals(motDePasseString)) {
            return true;
        } else {
            return false;
        }
    }

    
    public static void main(String[] args) {
       
    }
}
