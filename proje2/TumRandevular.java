package proje2;

public class TumRandevular {
    private Randevu[] randevular;
    private String[] randevu_saatleri = {"08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30"};//14 adet

    public TumRandevular(int max_kapasite) {
        randevular = new Randevu[max_kapasite];
    }


    public Randevu[] getRandevular() {
        return randevular;
    }

    //randevu Ekle
    public void randevu_ekle(Randevu randevu) {
        for (Klinik klinik : randevu.getHastane().getMevcut_klinikler()) {

            //eğer hastanede o klinik varsa silme aşamalarına geç
            if (klinik != null && klinik.equals(randevu.getClinic())) {
                if (!randevu_saati_musait_mi(randevu)) {
                    System.out.println("RET: " + randevu + " istenen randevu dolu olduğundan randevu verilememektedir");
                    return;
                }

                for (int i = 0; i < this.randevular.length; i++) {
                    if (this.randevular[i] == null) {
                        this.randevular[i] = randevu;
                        System.out.println("BAŞARILI:" + randevu);
                        return;
                    }
                }
                System.out.println("Aşağıda bilgileri yazılı randevu EKLENEMEDİ" + randevu);
                return;
            }
        }
        System.out.println("Girmiş olduğunuz klinik hastanede kayıtlı değil randevu talebiniz iptal edildi");

    }


    //randevu sil
    public void randevu_sil(Randevu randevu) {
        for (int i = 0; i < this.randevular.length; i++) {
            if (this.randevular[i].equals(randevu)) {
                this.randevular[i] = null;
                System.out.println(randevu + " başarı ile silindi");
                return;
            }
        }
        System.out.println(randevu + " eklenemedi, boş yer yok");
    }


    //randevu güncelle
    public void randevu_degistir(Randevu degistirilecek, Randevu yeni) {
        for (int i = 0; i < this.randevular.length; i++) {
            if (this.randevular[i].equals(degistirilecek)) {
                this.randevular[i] = yeni;
                System.out.println(degistirilecek + "randevusu başarı ile degistirildi");
                return;
            }
        }
        System.out.println(degistirilecek + " değiştirilemedi, yazdığınız randevu bulunamadı");
    }


    //tüm randevuları listele
    //2. Şimdiye kadar alınmış farklı kliniklerden olan randevuların listelenmesi
    public void randevu_listele() {
        System.out.println("\n\n\t şimdiye kadar alınmış sistemdeki tüm randevular");
        System.out.println("------------------------------------------------------");
        for (Randevu randevu : this.randevular) {
            if (randevu != null)
                System.out.println(randevu);
        }
    }


    // tüm randevuları listele OVERLOAD
    // 1. Adı girilen hastane ve klinik için alınabilecek randevuların listelenmesi (hastane, klinik ve ilgili klinikteki doktor bilgileri gibi)
    public void bos_randevulari_listele(Hastane hst, Klinik klinik) {
        System.out.println("\n\n" + hst + "-" + klinik + "'teki boş randevular");
        System.out.println("------------------------------------------------------");

        for (Doktor doktor : klinik.getKlinik_doktorlari()) {
            if (doktor == null) continue;
            System.out.println("\n" + doktor.ad_soyad + " doktorun boş randevuları");
            for (int tarih = 1; tarih <= 30; tarih++) {
                System.out.print("Ayın " + tarih + ".inci gunu:");
                for (String saat : this.randevu_saatleri) {
                    final Randevu tmp_rnd = new Randevu(hst, null, klinik, doktor, tarih, saat);
                    if (tmp_rnd == null || randevu_saati_musait_mi(tmp_rnd)) {
                        System.out.print(saat + ", ");
                    }
                }
                System.out.println("");
            }
        }
    }


    public void randevu_listele(Klinik klinik, Doktor doktor) {
        System.out.println("\n\n\t sistemdeki tüm randevular");
        System.out.println("------------------------------------------------------");
        for (Randevu randevu : this.randevular) {
            if (randevu != null)
                System.out.println(randevu);
        }
    }


    private boolean randevu_saati_duzgun_mu(Randevu istenen_randevu) {
        for (String saat : this.randevu_saatleri) {
            if (istenen_randevu != null && istenen_randevu.getRandevu_saati().equals(istenen_randevu))
                return false;
        }
        return true;
    }


    private boolean randevu_saati_musait_mi(Randevu istenen_randevu) {
        for (Randevu randevu : this.randevular) {
            if (randevu != null && randevu.equals(istenen_randevu))
                return false;
        }
        return true;
    }


    //3. En çok randevusu olan hastanın tüm randevu bilgilerinin listelenmesi (hasta bilgileri, hastane bilgisi, klinik bilgisi, randevu tarihi vb. bilgiler)
    public void en_cok_randevusu_olan_hasta() {
        Hasta[] hastalar = new Hasta[this.randevular.length];
        int[] tpl_randevu = new int[this.randevular.length];
        //dizileri doldur
        dongu_baslangici:
        for (Randevu randevu : this.randevular) {
            if (randevu == null) continue;
            for (int i = 0; i < hastalar.length; i++) {
                if (hastalar[i] == null) {//listenin sonuna gelindi hastayı diizye ekle
                    hastalar[i] = randevu.getHasta();
                    continue dongu_baslangici;
                } else if (hastalar[i].equals(randevu.getHasta())) {
                    tpl_randevu[i]++;
                }
            }
        }

        //max olan hastayı bul
        int max = 0;
        Hasta maxHasta = null;
        for (int i = 0; i < this.randevular.length; i++) {
            if (max < tpl_randevu[i]) {
                max = tpl_randevu[i];
                maxHasta = hastalar[i];
            }
        }

        //max hastanın randevularını yazdır
        System.out.println("\nMax randevuya sahip hasta(" + maxHasta.ad_soyad + ") toplam " + (max + 1) + " adet randevusu vardır. Randevuları:");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Randevu randevu : this.randevular) {
            if (randevu != null && randevu.getHasta().equals(maxHasta)) {
                System.out.println(randevu);
            }
        }
    }


    //OVERLOAD
    //4. Adı girilen hastanın geçmişteki ve gelecekteki randevularının listelenmes
    public void randevu_listele(String hastaAdSoyad) {
        //max hastanın randevularını yazdır
        System.out.println("\n" + hastaAdSoyad + " adlı hastaya ait tüm randevular:");
        System.out.println("----------------------------------------------------------------");
        for (Randevu randevu : this.randevular) {
            if (randevu != null && randevu.getHasta().ad_soyad.equals(hastaAdSoyad)) {
                System.out.println(randevu);
            }
        }
    }

    //6. Karmaşık String araması yapılabilir. Adı * ile başlayan ve adının içerisinde ‘dul’ veya ‘hme’ geçen ve sonu ‘t’ ile biten hastanın ya da
    //hastaların randevu bilgisini (geçmişte ve gelecekte bulunan randevular) ekrana yazar (Not: * herhangi bir harf olabilir, büyük veya küçük farketmez)
    public void randevu_listele_jokerli(String hastaAdSoyad) {
        //max hastanın randevularını yazdır
        System.out.println("----------------------------------------------------------------");
        for (Randevu randevu : this.randevular) {
            if (randevu != null && joker_isimler_ayni_mi(randevu.getHasta().getAd_soyad(), hastaAdSoyad)) {
                System.out.println(randevu);
            }
        }
    }

//String arama
    private boolean joker_isimler_ayni_mi(String bakilacak_isim, String jokerli_isim) {

        bakilacak_isim = bakilacak_isim.toLowerCase();
        jokerli_isim = jokerli_isim.toLowerCase();
        String yeniJoker = "";
        boolean basta = false, sonda = false, ortada = false;

        if (jokerli_isim.charAt(0) == '*')
            basta = true;
        if (jokerli_isim.charAt(jokerli_isim.length() - 1) == '*')
            sonda = true;
        if (basta && sonda) {
            ortada = true;
            for (int i = 1; i < jokerli_isim.length() - 1; i++) {
                yeniJoker += jokerli_isim.charAt(i);
            }
        } else if (basta) {
            for (int i = 1; i < jokerli_isim.length(); i++) {
                yeniJoker += jokerli_isim.charAt(i);
            }
        } else {
            for (int i = 0; i < jokerli_isim.length() - 1; i++) {
                yeniJoker += jokerli_isim.charAt(i);
            }
        }

        int pos = bakilacak_isim.indexOf(yeniJoker);
        if (ortada && pos > -1)
            return true;
        else if (basta && pos == (bakilacak_isim.length() - yeniJoker.length()))
            return true;
        else if (sonda && pos == 0)
            return true;
        return false;
    }

    /*
    7. Klinik silebilme
    • Silinecek klinik için herhangi bir hasta tarafından gelecekte randevu
    alınmamış olması gerekir. Eğer varsa bilgi verilip klinik silme işlemi
    yapılmamalı
    */
    public boolean klinik_silinebilir(Klinik klinik, int simdiki_gun) {
        for (Randevu randevu : randevular) {//tum randevular
            if (randevu == null) continue;
            //gelecekte randevu var mı
            if (randevu.getClinic().equals(klinik) && randevu.getRandevu_tarihi() >= simdiki_gun)
                return false;
        }
        return true;
    }


    public boolean doktor_silinebilir(Doktor doktor, int simdiki_gun) {
        for (Randevu randevu : randevular) {//tum randevular
            if (randevu == null) continue;
            //gelecekte randevu var mı
            if (randevu.getDoktor().equals(doktor) && randevu.getRandevu_tarihi() >= simdiki_gun)
                return false;
        }
        return true;
    }


    /*
    9. Girilen tarihte en fazla hastaya bakan doktorun bilgileri listelenmesi.
    */
    public void enfazla_hastaya_bakan_doktor(int gun) {
        Doktor[] doktorlar = new Doktor[this.randevular.length];
        int[] tpl_randevu = new int[this.randevular.length];
        //dizileri doldur
        dongu_baslangici:
        for (Randevu randevu : this.randevular) {
            if (randevu == null || randevu.getRandevu_tarihi() != gun) continue;

            for (int i = 0; i < doktorlar.length; i++) {
                if (doktorlar[i] == null) {//listenin sonuna gelindi doktoru diizye ekle
                    doktorlar[i] = randevu.getDoktor();
                    continue dongu_baslangici;
                } else if (doktorlar[i].equals(randevu.getDoktor())) {
                    tpl_randevu[i]++;
                }
            }
        }

        //max olan doktoru bul
        int max = 0;
        Doktor maxDoktor = null;
        for (int i = 0; i < this.randevular.length; i++) {
            if (max < tpl_randevu[i]) {
                max = tpl_randevu[i];
                maxDoktor = doktorlar[i];
            }
        }

        //max hastanın randevularını yazdır
        System.out.println("\nMax randevuya sahip doktor(" + maxDoktor.ad_soyad + ") 'dır, Randevuları:");
        System.out.println("-----------------------------------------------------------------------------------");
        for (Randevu randevu : this.randevular)
            if (randevu != null && randevu.getDoktor().equals(maxDoktor)) {
                System.out.println(randevu);
            }

    }

    /*
       5. Hasta, randevu tarihinden en geç 1 gün önce randevusunu iptal
       edebilir. 1 günden daha az bir süre kaldıysa randevu iptal edilemez veya
       değişiklik yapılamaz. 1 günden daha fazla bir süre varsa almış olduğu
       randevuyu güncelleyebilir.*/
    public void randevu_iptal_et(Randevu rnd, int gun) {
        for (int j = 0; j < randevular.length; j++) {
            if (randevular[j] != null) {
                if (randevular[j].equals(rnd)) {
                    if (randevular[j].getRandevu_tarihi() - gun == 0) {
                        System.out.println("\nrandevu en az 1 gün önce iptal edilebilir. şu anda iptali mümkün değildir.");
                    } else {
                        randevular[j] = null;
                        System.out.println("\nrandevunuz iptal edildi");
                    }
                }
            }
        }

    }


    //randevu güncelle (1 gün önceye kadar güncellemeye izin verilir)
    public void randevu_guncelle(Randevu guncellenecek, Randevu yeni, int gun) {
        for (int j = 0; j < randevular.length; j++) {
            if (randevular[j] != null) {
                if (randevular[j].equals(guncellenecek)) {
                    if (randevular[j].getRandevu_tarihi() - gun == 0) {
                        System.out.println("\nrandevu en az 1 gün önce güncellenebilir. şu anda güncelleme mümkün değildir.");
                    } else {
                        randevular[j] = guncellenecek;
                        System.out.println("\nrandevunuz güncellendi");
                    }
                }
            }
        }
    }


    public void tamamlanmis_randevulari_listele(int i0, int i1, int simdikiGun) {

        for (Randevu randevu : randevular) {
            if (randevu == null) continue;
            //aralıkta ise
            if (randevu.getRandevu_tarihi() >= i0 && randevu.getRandevu_tarihi() <= i1) {
                //tamamlanmış olması için şimdiki günden daha erken bir tarih olmalı
                if (randevu.getRandevu_tarihi() < simdikiGun) {
                    System.out.println(randevu);
                }
            }

        }
    }


    public void tamamlanmamis_randevulari_listele(int i0, int i1, int simdikiGun) {
        for (Randevu randevu : randevular) {
            if (randevu == null) continue;
            //aralıkta ise
            if (randevu.getRandevu_tarihi() >= i0 && randevu.getRandevu_tarihi() <= i1) {
                //tamamlanmış olması için şimdiki günden daha erken bir tarih olmalı
                if (randevu.getRandevu_tarihi() > simdikiGun) {
                    System.out.println(randevu);
                }
            }

        }
    }


    public void klinik_bazda_en_cok_randevu_alan_hastalar(Hastane[] hastaneler) {
        for (Hastane hastane : hastaneler) {
            for (Klinik klinik : hastane.getMevcut_klinikler()) {
                klinik_bazda_en_cok_randevu_alan_hastalar(klinik);
            }
        }
    }


    private void klinik_bazda_en_cok_randevu_alan_hastalar(Klinik klinik) {
        Hasta[] hastalar = new Hasta[this.randevular.length];
        int[] tpl_randevu = new int[this.randevular.length];
        dongu_baslangici:
        for (Randevu randevu : this.randevular) {
            if (randevu == null || !randevu.getClinic().equals(klinik))
                continue;
            for (int i = 0; i < hastalar.length; i++) {
                if (hastalar[i] == null) {//listenin sonuna gelindi hastayı diizye ekle
                    hastalar[i] = randevu.getHasta();
                    continue dongu_baslangici;
                } else if (hastalar[i].equals(randevu.getHasta())) {
                    tpl_randevu[i]++;
                }
            }
        }

        //max olan hastayı bul
        int max = 0;
        Hasta maxHasta = null;
        for (int i = 0; i < this.randevular.length; i++) {
            if (max < tpl_randevu[i]) {
                max = tpl_randevu[i];
                maxHasta = hastalar[i];
            }
        }

        //max hastanın bilgilerini yazdır
        if (klinik != null)
            System.out.println(klinik + " kliniğinde en çok randevu alan hasta: " + maxHasta);
    }
}