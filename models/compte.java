package models;

public class compte {
    private int compteId; 
    private int utilisateurId; 
    private utilisateur utilisateur; 
    private String accountType; 


    public int getCompteId() {
        return compteId;
    }

    public void setCompteId(int compteId) {
        this.compteId = compteId;
    }

    public int getUtilisateurId() {
        return utilisateurId;
    }

    public void setUtilisateurId(int utilisateurId) {
        this.utilisateurId = utilisateurId;
    }

    public utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}
