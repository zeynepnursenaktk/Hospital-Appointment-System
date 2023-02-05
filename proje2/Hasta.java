package proje2;

public class Hasta extends Kimlik {
    private String hastaligi;

    public Hasta() {
    }

    public Hasta(String hastaligi, String ad_soyad, String tc_kimlik_no, String dogum_yili) {
        super(ad_soyad, tc_kimlik_no, dogum_yili);
        this.hastaligi = hastaligi;
    }

    public String getHastaligi() {
        return hastaligi;
    }

    public void setHastaligi(String hastaligi) {
        this.hastaligi = hastaligi;
    }

    @Override
    public void bilgileri_yaz() {
        System.out.println("ad_soyad      : " + ad_soyad);
        System.out.println("tc_kimlik_no  : " + tc_kimlik_no);
        System.out.println("dogum_yili    : " + dogum_yili);
        System.out.println("hastalığı     : " + hastaligi);
    }


    @Override
    public String toString() {
        return this.getAd_soyad() + ", " + this.getDogum_yili() + ", " + this.getTc_kimlik_no() + ", " + hastaligi;
    }

}
