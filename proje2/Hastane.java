package proje2;

import java.util.Objects;

public class Hastane {
    private String hastane_adi;
    private String kurulus_yili;
    private String bulundugu_il;
    private Klinik[] mevcut_klinikler;

    public Hastane() {
        this.mevcut_klinikler = new Klinik[100];
    }


    public Hastane(String hastane_adi, String kurulus_yili, String bulundugu_il) {
        this.hastane_adi = hastane_adi;
        this.kurulus_yili = kurulus_yili;
        this.bulundugu_il = bulundugu_il;
        this.mevcut_klinikler = new Klinik[100];
    }


    public String getHastane_adi() {

        return hastane_adi;
    }

    public String getKurulus_yili() {
        return kurulus_yili;
    }

    public String getBulundugu_il() {
        return bulundugu_il;
    }

    public Klinik[] getMevcut_klinikler() {
        return mevcut_klinikler;
    }

    public void setHastane_adi(String hastane_adi) {
        this.hastane_adi = hastane_adi;
    }

    public void setKurulus_yili(String kurulus_yili) {
        this.kurulus_yili = kurulus_yili;
    }

    public void setBulundugu_il(String bulundugu_il) {
        this.bulundugu_il = bulundugu_il;
    }


    public void klinik_ekle(Klinik klinik) {
        for (int i = 0; i < this.mevcut_klinikler.length; i++) {
            if (this.mevcut_klinikler[i] == null) {
                this.mevcut_klinikler[i] = klinik;
                System.out.println(klinik + " kliniği başarı ile " + this.hastane_adi + " 'ne eklendi");
                return;
            }
        }
        System.out.println(klinik + " kliniği eklenemedi boş yer yok");
    }



    public void klinik_sil(TumRandevular tumRandevular, Klinik klinik, int bugun) {
        if (!tumRandevular.klinik_silinebilir(klinik, bugun)) {
            System.out.println(klinik + " kliniği gelecekte randevuları olduğundan silinmedi");
            return;
        } //klinikte gelecekte randevu varsa
        for (int i = 0; i < this.mevcut_klinikler.length; i++) {
            if (this.mevcut_klinikler[i].equals(klinik)) {
                this.mevcut_klinikler[i] = null;
                System.out.println("\n" + klinik + " kliniği başarı ile silindi");
                return;
            }
        }
        System.out.println(klinik + " kliniği silinemedi, yazdığınız klinik listede yok");
    }


    //Klinik güncelle
    public void klinik_degistir(Klinik degistirilecek, Klinik yeni_klinik) {
        for (int i = 0; i < this.mevcut_klinikler.length; i++) {
            if (this.mevcut_klinikler[i].equals(degistirilecek)) {
                this.mevcut_klinikler[i] = yeni_klinik;
                System.out.println(degistirilecek + " klinik başarı ile degistirildi");
                return;
            }
        }
        System.out.println(degistirilecek + " kliniği değiştirilemedi, yazdığınız klinik listede yok");
    }


    public void klinik_listele() {
        System.out.println("\n\n\t" + this.hastane_adi + " 'ne ait klinikler");
        System.out.println("------------------------------------------------------");
        for (Klinik k : this.mevcut_klinikler) {
            if (k != null) System.out.println(k);
        }
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
        final Hastane other = (Hastane) obj;
        if (!Objects.equals(this.hastane_adi, other.hastane_adi)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return hastane_adi;
    }

}
