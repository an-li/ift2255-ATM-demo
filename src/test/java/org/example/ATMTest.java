package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {
    private ATM a;
    private double soldeInitial;

    @BeforeEach
    void setUp() {
        a = new ATM(200.0);
        soldeInitial = a.getSolde();
    }

    @Test
    void testDepot() {
        double montantDepot = 100;
        a.depot(montantDepot);
        assertEquals(soldeInitial + montantDepot, a.getSolde(), 0, "Le montant à déposer est persisté");
    }

    @Test
    void testDepotEchec() {
        double montantDepot = -100;
        assertFalse(a.depot(montantDepot), "Impossible de déposer un montant négatif");
    }

    @Test
    void testRetrait() {
        double montantRetrait = 100;
        a.retrait(montantRetrait);
        assertEquals(soldeInitial - montantRetrait, a.getSolde(), 0, "Le montant à retirer est persisté");
    }

    @Test
    void testRetraitEchec() {
        double montantRetrait = 300;
        assertFalse(a.retrait(montantRetrait), "Impossible de retirer un montant plus élevé que le solde");
    }

    @Test
    void verificationSanitaire() {
        double montant = 100;
        a.depot(montant);
        a.retrait(montant);
        assertEquals(soldeInitial, a.getSolde(), 0, "Le solde est préservé");
    }
}