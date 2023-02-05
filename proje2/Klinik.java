package proje2;

import java.util.Objects;

public class Klinik {
    private String klinik_adi;
    private final Doktor[] klinik_doktorlari;


    public Klinik() {
        this.klinik_doktorlari=new Doktor[100];

    }

    public Klinik(String klinik_adi ) {
        this.klinik_adi = klinik_adi;
        this.klinik_doktorlari=new Doktor[100];
    }


    public String getKlinik_adi() { return klinik_adi; }
    public void setKlinik_adi(String klinik_adi) { this.klinik_adi = klinik_adi; }
    public Doktor[] getKlinik_doktorlari() { return klinik_doktorlari; }



    public void doktor_ekle(Doktor doktor){
        for (int i = 0; i < this.klinik_doktorlari.length; i++) {
            if(this.klinik_doktorlari[i]==null){
                this.klinik_doktorlari[i]=doktor;
                System.out.println(doktor.getAd_soyad()+", "+klinik_adi +" kliniğine başarı ile eklendi");
                return;
            }
        }
        System.out.println(doktor.getAd_soyad()+", "+klinik_adi +" kliniğine eklenemedi, BOŞ YER YOK");
    }



    public void doktor_sil(TumRandevular tumRandevular, Doktor doktor,int simdiki_gun){
        if (tumRandevular.doktor_silinebilir(doktor, simdiki_gun)) {
            for (int i = 0; i < this.klinik_doktorlari.length; i++) {
                if (this.klinik_doktorlari[i].equals(doktor)) {
                    this.klinik_doktorlari[i] = null;
                    System.out.println(doktor.getAd_soyad() + " başarı ile silindi");
                    return;
                }
            }
            System.out.println(doktor.getAd_soyad() + " silinemedi, yazdığınız doktor " + this.getKlinik_adi() + " kliniğinde çalışmıyor (listede yok)");
        } else {
            System.out.println("Doktorun aktif veya gelecekte randevuları olduğundan silinmedi");
        }

    }


    public void doktor_degistir(Doktor degistirilecek, Doktor yeni){
        for (int i = 0; i < this.klinik_doktorlari.length; i++) {
            if (this.klinik_doktorlari[i].equals(degistirilecek)) {
                this.klinik_doktorlari[i]=yeni;
                System.out.println(degistirilecek.getAd_soyad()+" başarı ile degistirildi");
                return;
            }
        }
        System.out.println(degistirilecek.getAd_soyad()+" değiştirilemedi, yazdığınız doktor "+this.klinik_adi+" kliniğinde bulunamadı");
    }


    public void doktor_listele(){
        System.out.println("\n\n\t"+this.klinik_adi+" 'nde çalışan doktorlar");
        System.out.println("------------------------------------------------------");
        for (Doktor k : this.klinik_doktorlari) {
            if(k!=null)
                System.out.println(k);
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
        final Klinik other = (Klinik) obj;
        if (!Objects.equals(this.klinik_adi, other.klinik_adi)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return klinik_adi ;
    }
}
