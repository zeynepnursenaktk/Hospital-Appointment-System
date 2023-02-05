package proje2;

public class HastaRandevuTest {
    public static void main(String[] args) {
        TumRandevular tumRandevular=new TumRandevular(100);

        //hastane oluşturma (yapılandırıcılar ve set metodlarının testi)
        Hastane[] hastaneler=new Hastane[2];
        hastaneler[0] = new Hastane("Acibadem Hastanesi", "2010", "İstanbul");

        hastaneler[1] = new Hastane();
        hastaneler[1].setHastane_adi("Avrasya Hastanesi");
        hastaneler[1].setBulundugu_il("İzmir");
        hastaneler[1].setKurulus_yili("2000");
        dizi_yaz(hastaneler, "Hastaneler");


        //klinik oluşturma (yapılandırıcılar ve set metodlarının testi)
        Klinik[] klinikler = new Klinik[5];
        klinikler[0] = new Klinik("Ortopedi");
        klinikler[1] = new Klinik("Dahiliye");
        klinikler[2] = new Klinik("Cildiye");
        klinikler[3] = new Klinik("Acil - Travma");
        klinikler[4] = new Klinik();
        klinikler[4].setKlinik_adi("Üroloji");
        dizi_yaz(klinikler,"Klinikler");



        //Hastalar oluşturma (yapılandırıcılar ve set metodlarının testi)
        Hasta[] hastalar=new Hasta[5];
        hastalar[0]=new Hasta("Böbrek yetmezliği", "Zeynep Ecrin Ozubek", "12352101452", "2005");
        hastalar[1]=new Hasta("Kronik Kalp Hastası", "Esma Kuru", "22352101414", "2000");
        hastalar[2]=new Hasta("Kol kırıklığı", "Sezayi Talha Kutuk", "12352101416", "1984");
        hastalar[3]=new Hasta("Sinuzit", "Gamze Corlu", "52352101485", "1988");
        hastalar[4]=new Hasta();
        hastalar[4].setTc_kimlik_no("85142101412");
        hastalar[4].setAd_soyad("Asya Dazkir");
        hastalar[4].setDogum_yili("2010");
        hastalar[4].setHastaligi("Kalça Kırığı");
        dizi_yaz(hastalar, "Hastalar");


        //Doktor oluşturma (yapılandırıcılar ve set metodlarının testi)
        Doktor[] doktorlar = new Doktor[10];
        doktorlar[0] = new Doktor(hastaneler[0], klinikler[0], "Ortopedi ve Travmatoloji", "2002", "Dr.Beyzanur Erdem", "14251001251", "1980");
        doktorlar[1] = new Doktor(hastaneler[0],klinikler[0], "Ortopedi ve Travmatoloji", "1980", "Dr.Feyzanur Midillioglu", "12012012101", "1960");
        doktorlar[2] = new Doktor(hastaneler[0],klinikler[0], "Ortopedi ve Travmatoloji", "1996", "Dr.Ayse Ceyda Kutuk", "10232523652", "1982");
        doktorlar[3] = new Doktor(hastaneler[0],klinikler[0], "Ortopedi ve Travmatoloji", "2008", "Dr.Melike Tuana Kutuk", "25251001251", "1965");
        doktorlar[4] = new Doktor(hastaneler[0],klinikler[1], "Göğüs hastalıkları", "2018", "Dr.Davut Islek", "14251001247", "1984");
        doktorlar[5] = new Doktor(hastaneler[0],klinikler[1], "Göğüs hastalıkları", "2020", "Dr.Murat Elevli", "21451001251", "1977");
        doktorlar[6] = new Doktor(hastaneler[0],klinikler[1], "Enfeksiyon Hastalıkları", "2003", "Dr.Ensar Aydin", "523651001251", "1974");
        doktorlar[7] = new Doktor(hastaneler[0],klinikler[2], "Dermatoloji", "2008", "Dr.Berrin SOYDAN", "12251001251", "1982");
        doktorlar[8] = new Doktor(hastaneler[0],klinikler[3], "Pratisyen Tabip", "2021", "Dr.İlknur TAN", "12541478564", "1980");
        doktorlar[9] = new Doktor();
        doktorlar[9].setAd_soyad("Dr.Bahar GÜL");
        doktorlar[9].setBransi("Pediatrik üroloji");
        doktorlar[9].setDogum_yili("1977");
        doktorlar[9].setIse_basladigi_yil("2000");
        doktorlar[9].setTc_kimlik_no("52362532100");
        dizi_yaz(doktorlar,"Doktorlar");



        //randevu oluşturma (yapılandırıcılar ve set metodlarının testi)
        Randevu[] randevus=new Randevu[10];
        randevus[0]=new Randevu(hastaneler[0], hastalar[0], klinikler[0], doktorlar[0], 1, "10:30");
        randevus[1]=new Randevu(hastaneler[0], hastalar[0], klinikler[0], doktorlar[0], 1, "15:30");
        randevus[2]=new Randevu(hastaneler[0], hastalar[0], klinikler[0], doktorlar[0], 1, "9:00");
        randevus[3]=new Randevu(hastaneler[0], hastalar[0], klinikler[0], doktorlar[3], 8, "14:30");
        randevus[4]=new Randevu(hastaneler[0], hastalar[0], klinikler[0], doktorlar[0], 1, "10:30");
        randevus[5]=new Randevu(hastaneler[0], hastalar[1], klinikler[0], doktorlar[0], 1, "11:30");
        randevus[6]=new Randevu(hastaneler[0], hastalar[1], klinikler[0], doktorlar[0], 1, "10:00");
        randevus[7]=new Randevu(hastaneler[0], hastalar[2], klinikler[0], doktorlar[0], 1, "9:30");
        randevus[8]=new Randevu(hastaneler[0], hastalar[3], klinikler[0], doktorlar[0], 1, "8:30");
        randevus[9]=new Randevu();
        randevus[9].setHastane(hastaneler[0]);
        randevus[9].setClinic(klinikler[0]);
        randevus[9].setDoktor(doktorlar[0]);
        randevus[9].setHasta(hastalar[4]);
        randevus[9].setRandevu_tarihi( 15);
        randevus[9].setRandevu_saati("10:30");
        dizi_yaz(randevus,"Randevular");




        //hastaneye klinik ekle, sil, değiştir, listele
        System.out.println("\n\nHastanelere klinikler ekleniyor");
        System.out.println("--------------------------------");
        for (Klinik klinik : klinikler) {
            hastaneler[0].klinik_ekle(klinik);
        }

        hastaneler[0].klinik_listele();

        Klinik yeni=new Klinik("Nöroloji");
        hastaneler[0].klinik_degistir(klinikler[2], yeni);
        hastaneler[0].klinik_listele();
        hastaneler[1].klinik_ekle(klinikler[0]);
        hastaneler[1].klinik_ekle(klinikler[4]);
        hastaneler[1].klinik_listele();




        //Kliniklere doktor ekle, sil, değiştir, listele
        System.out.println("\n\nKliniklere Doktorlar ekleniyor");
        System.out.println("--------------------------------");
        klinikler[0].doktor_ekle(doktorlar[0]);
        klinikler[0].doktor_ekle(doktorlar[1]);
        klinikler[0].doktor_ekle(doktorlar[2]);
        klinikler[0].doktor_ekle(doktorlar[3]);
        klinikler[1].doktor_ekle(doktorlar[4]);
        klinikler[1].doktor_ekle(doktorlar[5]);
        klinikler[1].doktor_ekle(doktorlar[6]);

        //1. Adı girilen hastane ve klinik için alınabilecek randevuların listelenmesi
        //(hastane, klinik ve ilgili klinikteki doktor bilgileri gibi)
        klinikler[0].doktor_listele();
        klinikler[1].doktor_listele();


        //randevu işlemleri
        tumRandevular.randevu_ekle(randevus[0]);
        tumRandevular.randevu_ekle(randevus[1]);
        tumRandevular.randevu_ekle(randevus[2]);
        tumRandevular.randevu_ekle(randevus[3]);
        tumRandevular.randevu_ekle(randevus[4]);
        tumRandevular.randevu_ekle(randevus[5]);
        tumRandevular.randevu_ekle(randevus[6]);
        tumRandevular.randevu_ekle(randevus[7]);
        tumRandevular.randevu_ekle(randevus[8]);
        tumRandevular.randevu_ekle(randevus[9]);

        //1. Adı girilen hastane ve klinik için alınabilecek randevuların listelenmesi
        tumRandevular.bos_randevulari_listele(hastaneler[0], hastaneler[0].getMevcut_klinikler()[0]);

        //2. Şimdiye kadar alınmış farklı kliniklerden olan randevuların listelenmesi
        tumRandevular.randevu_listele();

        //3. En çok randevusu olan hastanın tüm randevu bilgilerinin listelenmesi (hasta bilgileri, hastane bilgisi, klinik bilgisi, randevu tarihi vb.
        //bilgiler)
        tumRandevular.en_cok_randevusu_olan_hasta();

        //4. Adı girilen hastanın geçmişteki ve gelecekteki randevularının listelenmesi
        tumRandevular.randevu_listele("Asya Dazkir");

        /*
        5. Hasta, randevu tarihinden en geç 1 gün önce randevusunu iptal
        edebilir. 1 günden daha az bir süre kaldıysa randevu iptal edilemez veya
        değişiklik yapılamaz. 1 günden daha fazla bir süre varsa almış olduğu
        randevuyu güncelleyebilir.*/
        tumRandevular.randevu_iptal_et(tumRandevular.getRandevular()[3],8);
        Randevu yeniRnd=new Randevu(hastaneler[0], hastalar[0], klinikler[2], doktorlar[3], 8, "14:30");
        tumRandevular.randevu_guncelle(tumRandevular.getRandevular()[3],yeniRnd,8);
        tumRandevular.randevu_guncelle(tumRandevular.getRandevular()[3],yeniRnd,12);

        /*6. Karmaşık String araması yapılabilir. Adı * ile başlayan ve adının
        içerisinde ‘dul’ veya ‘hme’ geçen ve sonu ‘t’ ile biten hastanın ya da
        hastaların randevu bilgisini (geçmişte ve gelecekte bulunan randevular)
        ekrana yazar
        (Not: * herhangi bir harf olabilir, büyük veya küçük farketmez)
        */
        System.out.println("\nhasta adı *zkir ile biten randevular");
        tumRandevular.randevu_listele_jokerli("*zkir");
        System.out.println("\nhasta adı içinde *lh* geçen randevular");
        tumRandevular.randevu_listele_jokerli("*lh*");
        System.out.println("\nhasta adı gamz* ile başlayan randevular");
        tumRandevular.randevu_listele_jokerli("gamz*");

        //7. Klinik silebilme Silinecek klinik için herhangi bir hasta tarafından gelecekte randevu
        //alınmamış olması gerekir. Eğer varsa bilgi verilip klinik silme işlemi yapılmamalı
        //randevusu olan bir kliniği silinmeye çalışılması
        hastaneler[0].klinik_sil(tumRandevular,klinikler[0],1);

        // Silinmek istenen klinikten herhangi bir randevu alınmadıysa (gelecekteki randevu) ilgili klinik silinmelidir ve kliniğin bulunduğu
        //hastanede bu klinik için bir daha randevu verilmemelidir.
        hastaneler[0].klinik_sil(tumRandevular,klinikler[4],22);
        hastaneler[0].klinik_listele();

        //silinen bu klinik için randevu verilecek mi test
        Randevu klinik4_randevusu=new Randevu(hastaneler[0], hastalar[0], klinikler[4], doktorlar[0], 12, "10:30");
        tumRandevular.randevu_ekle(klinik4_randevusu);


        /*
        8. Doktor silebilme
        • Silinecek doktorun aktif bir randevusu veya gelecekte ilgili doktora alınmış bir randevu yoksa bu doktor silinebilir.
        Eğer varsa bilgi verilip bu aktif randevu veya randevular rastgele olarak başka doktor/doktorların
        üzerine atanmalı. Eğer sistemde doktorun çalıştığı klinik için randevu
        atanabilecek (randevu çakışması yok ise) başka bir doktor yoksa silme
        işlemi yapılmamalı. Eğer randevu atanabilecek başka bir doktor varsa
        silme işlemi yapılmalı ve silinen bu doktora ait daha önceki randevular
        “eskiRandevular” listesine eklenerek saklanmalı
        */
        klinikler[0].doktor_sil(tumRandevular,doktorlar[0],1);  //randevulu doktor silinmesi

        /*
        9. Girilen tarihte en fazla hastaya bakan doktorun bilgileri listelenmesi
        */
        tumRandevular.enfazla_hastaya_bakan_doktor(1); //ayın 1 inde en fazla hastaya bakan doktor


        /*
        10. Klinik bazında en çok randevu alan hastaların bilgilerinin
        listelenmesi.*/
        System.out.println("\nKlinik bazda en çok randevu alan hastalar");
        System.out.println("----------------------------------------------");
        tumRandevular.klinik_bazda_en_cok_randevu_alan_hastalar(hastaneler);




        /*
        12.Verilen tarihler arasındaki bütün tamamlanmış randevuların listelenmesi
        */
        System.out.println("\n\nBelirtilen tarihler arasındaki bütün TAMAMLANMIŞ randevular");
        System.out.println("-----------------------------------------------------------");
        tumRandevular.tamamlanmis_randevulari_listele(1,  8,3);

        /*
        13. Verilen tarihler arasındaki bütün tamamlanmamış/gelecekteki
        randevuların listelenmesi. İlgili randevuyu alan müşteri bilgileri,
        klinik bilgisi, doktor bilgisi, hastane bilgisi, randevu tarihi vb.
        bilgiler listelenmeli.
        */
        System.out.println("\n\nBelirtilen tarihler arasındaki bütün TAMAMLANMAMIŞ gelecekteki randevular");
        System.out.println("-----------------------------------------------------------");
        tumRandevular.tamamlanmamis_randevulari_listele(1,  8,3);

    }


    public static void dizi_yaz(Object[] dizi, String baslik){
        System.out.println("\n\n\t"+baslik);
        System.out.println("------------------------------------------");
        for (Object object : dizi) {
            System.out.println(object);
        }
    }
}
