package proje2;

import java.util.Objects;

public class Randevu {
    private Hastane hastane;
    private Hasta hasta;
    private Klinik klinik;
    private Doktor doktor;
    private int ayin_gunu; //içinde bulunulan ayın günleri 1 den 30 a kadar
    private String randevu_saati;

    public Randevu() {
    }


    public Randevu(Hastane hastane, Hasta hasta, Klinik klinik, Doktor doktor, int randevu_tarihi, String randevu_saati) {

        this.hastane = hastane;
        this.hasta = hasta;
        this.klinik = klinik;
        this.doktor = doktor;
        this.ayin_gunu = randevu_tarihi;
        this.randevu_saati = randevu_saati;
    }

    public int getRandevu_tarihi() {
        return ayin_gunu;
    }


    public String getRandevu_saati() {
        return randevu_saati;
    }

    public Hasta getHasta() {
        if (hasta == null)
            hasta = new Hasta();
        return hasta;
    }

    public Hastane getHastane() {
        if (hastane == null)
            hastane = new Hastane();
        return hastane;
    }

    public Klinik getClinic() {
        if (klinik == null)
            klinik = new Klinik();
        return klinik;
    }

    public Doktor getDoktor() {
        if (doktor == null)
            doktor = new Doktor();
        return doktor;
    }

    public void setDoktor(Doktor doktor) {
        this.doktor = doktor;
    }

    public void setClinic(Klinik klinik) {
        this.klinik = klinik;
    }

    public void setHasta(Hasta hasta) {
        this.hasta = hasta;
    }

    public void setHastane(Hastane hastane) {
        this.hastane = hastane;
    }

    public void setRandevu_tarihi(int randevu_tarihi) {
        this.ayin_gunu = randevu_tarihi;
    }

    public void setRandevu_saati(String randevu_saati) {
        this.randevu_saati = randevu_saati;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Randevu other = (Randevu) obj;
        if (!Objects.equals(this.hastane, other.hastane)) {
            return false;
        }

        if (!Objects.equals(this.klinik, other.klinik)) {
            return false;
        }
        if (!Objects.equals(this.doktor, other.doktor)) {
            return false;
        }
        if (!Objects.equals(this.ayin_gunu, other.ayin_gunu)) {
            return false;
        }
        if (!Objects.equals(this.randevu_saati, other.randevu_saati)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + hastane + " " + klinik + " kliniği, Dr bilg:(" + doktor + ") hasta bilg:(" + hasta + ")" + ayin_gunu + "," + randevu_saati;
    }


    public String toString2() {
        return "\nHastane     : " + hastane.getHastane_adi()
                + "\nHasta       : " + hasta.getAd_soyad()
                + "\nKlinik      : " + klinik.getKlinik_adi()
                + "\nDoktor      : " + doktor.getAd_soyad()
                + "\nRandevu Tar.: " + ayin_gunu
                + "\nRandevu Saat: " + randevu_saati + "\n";
    }

}
