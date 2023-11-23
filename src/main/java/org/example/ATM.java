package org.example;

/**
 * Classe représentant un guichet automatique simple avec deux opérations: retrait et dépôt
 *
 * @author An Li
 */
public class ATM {
    private double solde;

    /**
     * Retourner le solde de l'instance du guichet automatique
     *
     * @return solde
     */
    public double getSolde() {
        return solde;
    }

    /**
     * Constructeur permettant de créer une instance d'un guichet automatique avec un solde initial donné
     *
     * @param soldeInitial - Solde initial
     */
    public ATM(double soldeInitial) {
        if (soldeInitial > 0) {
            this.solde = soldeInitial;
        } else {
            this.solde = 0.0;
        }
    }

    /**
     * Déposer un montant dans l'instance du guichet automatique.
     * Le montant doit être supérieur à 0.
     *
     * @param montant - Montant à déposer
     * @return <code>true</code> si la transaction a été complétée avec succès, sinon <code>false</code>
     */
    public boolean depot(double montant) {
        if (montant < 0) {
            return false;
        } else {
            this.solde += montant;
            return true;
        }
    }

    /**
     * Retirer un montant de l'instance du guichet automatique.
     * Le montant doit être supérieur à 0 et inférieur ou égal au solde.
     *
     * @param montant - Montant à déposer
     * @return <code>true</code> si la transaction a été complétée avec succès, sinon <code>false</code>
     */
    public boolean retrait(double montant) {
        if (this.solde < montant || montant <= 0) {
            return false;
        } else {
            this.solde -= montant;
            return true;
        }
    }
}