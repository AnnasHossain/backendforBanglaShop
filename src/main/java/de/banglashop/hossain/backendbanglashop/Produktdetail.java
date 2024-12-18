package de.banglashop.hossain.backendbanglashop;

import java.util.List;

public class Produktdetail {
        /*
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)*/
        private Long id;
        private String name;
        private double preis;
        private String farbe;
        private String groesse;
        private int rating;
        private String beschreibung;
        private String pflegeanleitung;

        private List<Bild> bilder;

        public Produktdetail(){}

        public Produktdetail(String name, double preis, String farbe, String groesse) {
            this.name = name;
            this.preis = preis;
            this.farbe = farbe;
            this.groesse = groesse;

        }

        public Produktdetail(Long id, String name, double preis, String farbe, String groesse, int rating, String beschreibung, String pflegeanleitung, List<Bild> bilder) {
            this.id = id;
            this.name = name;
            this.preis = preis;
            this.farbe = farbe;
            this.groesse = groesse;
            this.rating = rating;
            this.beschreibung = beschreibung;
            this.pflegeanleitung = pflegeanleitung;
            this.bilder = bilder;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPreis() {
            return preis;
        }

        public void setPreis(double preis) {
            this.preis = preis;
        }

        public String getFarbe() {
            return farbe;
        }

        public void setFarbe(String farbe) {
            this.farbe = farbe;
        }

        public String getGroesse() {
            return groesse;
        }

        public void setGroesse(String groesse) {
            this.groesse = groesse;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getBeschreibung() {
            return beschreibung;
        }

        public void setBeschreibung(String beschreibung) {
            this.beschreibung = beschreibung;
        }

        public String getPflegeanleitung() {
            return pflegeanleitung;
        }

        public void setPflegeanleitung(String pflegeanleitung) {
            this.pflegeanleitung = pflegeanleitung;
        }

        public List<Bild> getBilder() {
            return bilder;
        }

        public void setBilder(List<Bild> bilder) {
            this.bilder = bilder;
        }

        //TODO hier noch hashcode und toString





    }



}
