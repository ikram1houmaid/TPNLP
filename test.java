public class Main {

    // =========================
    // Classe Voiture
    // =========================
    static class Voiture {

        private String marque;
        private String modele;
        private double vitesse;
        private int annee;

        // Constructeur par défaut
        public Voiture() {
            this.marque = "Inconnue";
            this.modele = "Standard";
            this.vitesse = 0.0;
            this.annee = 2024;
        }

        // Constructeur paramétré
        public Voiture(String marque, String modele, double vitesse, int annee) {
            this.marque = marque;
            this.modele = modele;
            this.vitesse = vitesse;
            this.annee = annee;
        }

        // Constructeur de copie
        public Voiture(Voiture autreVoiture) {
            this.marque = autreVoiture.marque;
            this.modele = autreVoiture.modele;
            this.vitesse = autreVoiture.vitesse;
            this.annee = autreVoiture.annee;
        }

        // Getters
        public String getMarque() {
            return marque;
        }

        public String getModele() {
            return modele;
        }

        public double getVitesse() {
            return vitesse;
        }

        public int getAnnee() {
            return annee;
        }

        // Setters
        public void setMarque(String marque) {
            if (marque != null && !marque.trim().isEmpty()) {
                this.marque = marque;
            } else {
                System.out.println("Erreur : La marque ne peut pas être vide.");
            }
        }

        public void setModele(String modele) {
            if (modele != null && !modele.trim().isEmpty()) {
                this.modele = modele;
            } else {
                System.out.println("Erreur : Le modele ne peut pas être vide.");
            }
        }

        public void setVitesse(double vitesse) {
            if (vitesse >= 0) {
                this.vitesse = vitesse;
            } else {
                System.out.println("Erreur : La vitesse ne peut pas être negative.");
            }
        }

        public void setAnnee(int annee) {
            int anneeCourante = java.time.Year.now().getValue();

            if (annee > 1885 && annee <= anneeCourante) {
                this.annee = annee;
            } else {
                System.out.println("Erreur : Annee invalide.");
            }
        }

        // Accelerer
        public void accelerer(double augmentation) {
            if (augmentation > 0) {
                this.vitesse += augmentation;

                System.out.println(
                    marque + " " + modele +
                    " accelere de " + augmentation +
                    " km/h. Nouvelle vitesse : " +
                    vitesse + " km/h."
                );
            } else {
                System.out.println(
                    "Erreur : L'augmentation doit etre positive."
                );
            }
        }

        // Freiner
        public void freiner(double reduction) {
            if (reduction > 0) {

                if (this.vitesse - reduction < 0) {
                    this.vitesse = 0;
                    System.out.println(
                        marque + " " + modele +
                        " s'arrete completement."
                    );
                } else {
                    this.vitesse -= reduction;

                    System.out.println(
                        marque + " " + modele +
                        " freine de " + reduction +
                        " km/h. Nouvelle vitesse : " +
                        vitesse + " km/h."
                    );
                }

            } else {
                System.out.println(
                    "Erreur : La reduction doit etre positive."
                );
            }
        }

        // Afficher les informations
        public void afficherInformations() {
            System.out.println("=== Informations de la voiture ===");
            System.out.println("Marque : " + marque);
            System.out.println("Modele : " + modele);
            System.out.println("Vitesse : " + vitesse + " km/h");
            System.out.println("Annee : " + annee);
            System.out.println("==================================");
        }
    }

    // =========================
    // Programme principal
    // =========================
    public static void main(String[] args) {

        System.out.println("===== CREATION DES VOITURES =====");

        // Constructeur par defaut
        Voiture voiture1 = new Voiture();

        // Constructeur parametre
        Voiture voiture2 =
            new Voiture("Toyota", "Corolla", 0.0, 2023);

        // Constructeur de copie
        Voiture voiture3 =
            new Voiture(voiture2);

        voiture1.afficherInformations();
        voiture2.afficherInformations();
        voiture3.afficherInformations();


        System.out.println("\n===== ACCELERATION =====");

        voiture2.accelerer(120);


        System.out.println("\n===== FREINAGE =====");

        voiture2.freiner(30);


        System.out.println("\n===== VOITURE 2 =====");

        voiture2.afficherInformations();


        System.out.println("\n===== VOITURE 3 =====");

        voiture3.accelerer(80);
        voiture3.afficherInformations();


        System.out.println("\n===== TEST DES VALIDATIONS =====");

        voiture2.setVitesse(-50);
        voiture2.setAnnee(1800);
        voiture2.setAnnee(2050);
        voiture2.setMarque("");
        voiture2.setMarque(null);
        voiture2.accelerer(-20);
        voiture2.freiner(-10);


        System.out.println("\n===== FREINAGE EXCESSIF =====");

        voiture2.setVitesse(20);
        voiture2.freiner(50);


        System.out.println("\n===== COMPARAISON =====");

        System.out.println(
            "voiture2 == voiture3 : " +
            (voiture2 == voiture3)
        );


        System.out.println("\n===== ETAT FINAL =====");

        voiture2.afficherInformations();
        voiture3.afficherInformations();
    }
}