package proje2;

import java.util.Objects;

public class Kimlik {
    protected String ad_soyad;
    protected String tc_kimlik_no;
    protected String dogum_yili;

    public Kimlik() {

    }

    public Kimlik(String ad_soyad, String tc_kimlik_no, String dogum_yili) {
        this.ad_soyad = ad_soyad;
        this.tc_kimlik_no = tc_kimlik_no;
        this.dogum_yili = dogum_yili;
    }

    public String getAd_soyad() {

        return ad_soyad;
    }

    public String getTc_kimlik_no() {

        return tc_kimlik_no;
    }

    public String getDogum_yili() {

        return dogum_yili;
    }

    public void setAd_soyad(String ad_soyad) {

        this.ad_soyad = ad_soyad;
    }

    public void setTc_kimlik_no(String tc_kimlik_no) {

        this.tc_kimlik_no = tc_kimlik_no;
    }

    public void setDogum_yili(String dogum_yili) {

        this.dogum_yili = dogum_yili;
    }

    public void bilgileri_yaz() {
        System.out.println("ad_soyad      : " + ad_soyad);
        System.out.println("tc_kimlik_no  : " + tc_kimlik_no);
        System.out.println("dogum_yili    : " + dogum_yili);
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
        final Kimlik other = (Kimlik) obj;
        if (!Objects.equals(this.tc_kimlik_no, other.tc_kimlik_no)) {
            return false;
        }
        return true;
    }


    @Override
    public String toString() {
        return "Kimlik{" + "ad_soyad=" + ad_soyad + ", tc_kimlik_no=" + tc_kimlik_no + ", dogum_yili=" + dogum_yili + '}';
    }
}
