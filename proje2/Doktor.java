package proje2;

public class Doktor extends Kimlik {
    private String bransi;
    private String ise_basladigi_yil;
    private Randevu[][] randevular;
    private Randevu[][] eski_randevular;
    private final int BIR_GUNDEKI_MAX_RANDEVU_SAYISI = 24;  //her güne max 24 randevu olacak
    private final int MAX_RANDEVU_GUN_SAYISI = 30;  //MAX 30 gün randevu oluşturulacak


    public Doktor() {
        bos_randevu_listesi_olustur();
    }


    public Doktor(Hastane calistigi_hastane, Klinik calistigi_klinik, String bransi, String ise_basladigi_yil, String ad_soyad, String tc_kimlik_no, String dogum_yili) {
        super(ad_soyad, tc_kimlik_no, dogum_yili);
        this.bransi = bransi;
        this.ise_basladigi_yil = ise_basladigi_yil;
        bos_randevu_listesi_olustur();
    }

    public String getBransi() {
        return bransi;
    }

    public String getIse_basladigi_yil() {
        return ise_basladigi_yil;
    }

    public void setBransi(String bransi) {
        this.bransi = bransi;
    }

    public void setIse_basladigi_yil(String ise_basladigi_yil) {
        this.ise_basladigi_yil = ise_basladigi_yil;
    }

    private void bos_randevu_listesi_olustur() {
        this.randevular = new Randevu[MAX_RANDEVU_GUN_SAYISI][];
        for (int i = 0; i < this.randevular.length; i++) {
            this.randevular[i] = new Randevu[BIR_GUNDEKI_MAX_RANDEVU_SAYISI];
        }
    }

    @Override
    public void bilgileri_yaz() {
        System.out.println("ad_soyad      : " + ad_soyad);
        System.out.println("tc_kimlik_no  : " + tc_kimlik_no);
        System.out.println("dogum_yili    : " + dogum_yili);
        System.out.println("branşı        : " + bransi);
        System.out.println("işe başl.yıl  : " + ise_basladigi_yil);
    }

    // doktor randevularını listele
    public void doktorun_tum_randevularini_listele() {
        for (int satir = 0; satir < MAX_RANDEVU_GUN_SAYISI; satir++) {
            for (int sutun = 0; sutun < BIR_GUNDEKI_MAX_RANDEVU_SAYISI; sutun++) {
                if (randevular[satir][sutun] == null)
                    System.out.print("\tBOŞ");
                else
                    System.out.println("\tDOLU");
            }
            System.out.println();
        }
    }

    public void doktorun_dolu_randevularini_listele() {
        for (int satir = 0; satir < MAX_RANDEVU_GUN_SAYISI; satir++) {
            for (int sutun = 0; sutun < BIR_GUNDEKI_MAX_RANDEVU_SAYISI; sutun++) {
                if (randevular[satir][sutun] != null)
                    System.out.print("\tBOŞ");
            }
        }
    }

    @Override
    public String toString() {
        return getDogum_yili() + ", " + getTc_kimlik_no() + ", " + getAd_soyad() + ", " + bransi + ", " + ise_basladigi_yil;
    }

}
