
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BlackJack {

  public static void main(String[] args) {
    boolean oyunDevam = true;
    Object etiketOyun[] = {"Kağıt AL", "BEKLE"};

    int bilgisayarPuan;
    String bilgisayarMesaj;
    JPanel bilgisayarPanel = new JPanel();
    boolean bilgisayarDevam;
    boolean bilgisayarAS = false;

    int oyuncuPara = 200;
    int oyuncuPuan;
    int bahis = 0;
    String oyuncuMesaj;
    JPanel oyuncuPanel = new JPanel();
    boolean oyuncuDevam;
    boolean oyuncuAS = false;

    int kartNo, kartPuan;
    String durumMesaj = "";
    Object oyunPanel[] = new Object[5];

    do {
      System.out.println("*************  YENİ OYUN  *************");
      boolean bahisHata = false;
      do {
        try {
          Object bahisTutar = JOptionPane.showInputDialog(null,
                  "<html><h1>BlackJack Oyunu</h1></html>\n"
                  + "Kağıtları toplamı 21 olan BlackJack yapar\n"
                  + "Kağıtları toplamı 21'e en yakın olan kazanır.\n"
                  + "Bilgisayarın kağıtları toplamı en az 17 olmalıdır.\n"
                  + "<html><h2>Şu anda " + oyuncuPara + " TL paran var.</h2></html>"
                  + "<html><h1>Lütfen bahsinizi belirleyin !!!</html></h1>",
                  "Bahis Değeri",
                  JOptionPane.PLAIN_MESSAGE,
                  new ImageIcon(BlackJack.class.getResource("resimler/bahisLogo.png")),
                  null, "");
          bahis = Integer.parseInt(bahisTutar.toString());
          if (bahis > oyuncuPara || bahis < 5) {
            JOptionPane.showMessageDialog(null,
                    "<html><h2>Paranızdan büyük veya 5 TL'den küçük bahis giremezsiniz !!!</h2></html>",
                    "HATALI GİRİŞ",
                    JOptionPane.ERROR_MESSAGE);
            bahisHata = true;
          } else {
            bahisHata = false;
          }
        } catch (NumberFormatException hata) {
          JOptionPane.showMessageDialog(null,
                  "<html><h2>Sayı değeri girmelisiniz !!!</h2></html>",
                  "HATALI GİRİŞ YAPTINIZ",
                  JOptionPane.ERROR_MESSAGE,
                  null);
          bahisHata = true;
        } catch (NullPointerException hata) {
          JOptionPane.showMessageDialog(null,
                  "<html><h1>Oyundan çıktınız</h1></html>", "ÇIKIŞ",
                  JOptionPane.WARNING_MESSAGE,
                  null);
          System.exit(0);
        }
      } while (bahisHata);
      System.out.println("Bahis = " + bahis);
      durumMesaj = "Bahis = " + bahis + "\nParanız = " + oyuncuPara;
      
      bilgisayarPuan = 0;
      bilgisayarDevam = true;
      // Bilgisayar 1. kart çekiliyor
      kartNo = (int) (Math.random() * 52) + 1;
      System.out.print("Bilgisayar\tKartNO = " + kartNo + "\t");
      switch(kartNo % 13) {
        case 0: kartPuan = 10; break; // K geldi kartPuan = 10
        case 1: 
          kartPuan = 11; 
          bilgisayarAS = true;
          break; // AS geldi kartPuan = 11
        case 11: case 12: kartPuan = 10; break; // J veya Q geldi kartPuan = 10
        default: 
          kartPuan = kartNo % 13; 
          break; 
      }
      System.out.print("KartPUAN  = " + kartPuan + "\t");
      bilgisayarPuan += kartPuan;
      bilgisayarPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k"+kartNo+".png"))));
      System.out.println("TOPLAM PUAN  = " + bilgisayarPuan);
      // Bilgisayar 2. kağıt kapalı gösterilir.
      JLabel kapaliKagit = new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k0.png")));
      bilgisayarPanel.add(kapaliKagit);
      bilgisayarMesaj = "Bilgisayar = " + bilgisayarPuan + " Puan";
      
      oyuncuPuan = 0;
      oyuncuDevam = true;
      // Oyuncu 1. kart 
      kartNo = (int) (Math.random() * 52) + 1;
      System.out.print("Oyuncu\tKartNO = " + kartNo + "\t");
      switch(kartNo % 13) {
        case 0: kartPuan = 10; break; // K geldi kartPuan = 10
        case 1: 
          kartPuan = 11; 
          bilgisayarAS = true;
          break; // AS geldi kartPuan = 11
        case 11: case 12: kartPuan = 10; break; // J veya Q geldi kartPuan = 10
        default: 
          kartPuan = kartNo % 13; 
          break; 
      }
      System.out.print("KartPUAN = " + kartPuan + "\t");
      oyuncuPuan += kartPuan;
      oyuncuPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k"+kartNo+".png"))));
      System.out.println("Toplam PUAN  = " + oyuncuPuan);
      
      // Oyuncu 2. kart 
      kartNo = (int) (Math.random() * 52) + 1;
      System.out.print("Oyuncu\tKartNO = " + kartNo + "\t");
      switch(kartNo % 13) {
        case 0: kartPuan = 10; break; // K geldi kartPuan = 10
        case 1: 
          kartPuan = 11; 
          bilgisayarAS = true;
          break; // AS geldi kartPuan = 11
        case 11: case 12: kartPuan = 10; break; // J veya Q geldi kartPuan = 10
        default: 
          kartPuan = kartNo % 13; 
          break; 
      }
      System.out.print("KartPUAN = " + kartPuan + "\t");
      oyuncuPuan += kartPuan;
      oyuncuPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k"+kartNo+".png"))));
      System.out.println("Toplam PUAN  = " + oyuncuPuan);
      oyuncuMesaj = "Oyuncu = " + oyuncuPuan + " Puan";
      
      if(oyuncuPuan >= 21) { // oyuncu bitirdi kart çekmeye gerek yok
        oyuncuDevam = false;
        bilgisayarDevam = false;
      }
      while(oyuncuDevam) {
        oyunPanel[0] = bilgisayarMesaj;
        oyunPanel[1] = bilgisayarPanel;
        oyunPanel[2] = durumMesaj;
        oyunPanel[3] = oyuncuPanel;
        oyunPanel[4] = oyuncuMesaj;
        int kartSecim = JOptionPane.showOptionDialog(null, oyunPanel, "BlackJack Oyunu", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                new ImageIcon(BlackJack.class.getResource("resimler/blackjack.png")), 
                etiketOyun, etiketOyun[0]);
        if(kartSecim == 1) { // BEKLE seçildi kartNo almaz
          oyuncuDevam = false;
        } else {
          // Oyuncu Yeni kart 
          kartNo = (int) (Math.random() * 52) + 1;
          switch(kartNo % 13) {
            case 0: kartPuan = 10; break; // K geldi kartPuan = 10
            case 1: 
              kartPuan = 11; 
              bilgisayarAS = true;
            break; // AS geldi kartPuan = 11
            case 11: case 12: kartPuan = 10; break; // J veya Q geldi kartPuan = 10
            default: 
              kartPuan = kartNo % 13; 
              break; 
          }
          System.out.print("Oyuncu\tKartNO = " + kartNo + "\tKartPUAN = " + kartPuan + "\t");
          oyuncuPuan += kartPuan;
          oyuncuPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k"+kartNo+".png"))));
          if(oyuncuAS && oyuncuPuan > 21) { // oyuncuda AS var ama puanı 21'den büyük. AS=1 sayılır
            oyuncuPuan -= 10;
            oyuncuAS = false;
          }
          System.out.println("Toplam PUAN  = " + oyuncuPuan);
          oyuncuMesaj = "Oyuncu = " + oyuncuPuan + " Puan";
        } // oyuncu AS kontrolü bitti
        if(oyuncuPuan >= 21) {
          oyuncuDevam = false;
          bilgisayarDevam = false;
        }
      } // oyuncu aşaması bitti
      
      // bilgisayar oynamaya başladı. Kapalı kağıtı kaldıralım
      bilgisayarPanel.remove(kapaliKagit);
      while(bilgisayarDevam) {
        if(bilgisayarPuan < 17) {
          // bilgisayar yeni kart
          kartNo = (int) (Math.random() * 52) + 1;
          switch (kartNo % 13) {
            case 0:
              kartPuan = 10;
              break; // K geldi kartPuan = 10
            case 1:
              kartPuan = 11;
              bilgisayarAS = true;
              break; // AS geldi kartPuan = 11
            case 11:
            case 12:
              kartPuan = 10;
              break; // J veya Q geldi
            default:
              kartPuan = kartNo % 13;
              break; // 
          }
          System.out.print("Bilgisayar\tKartNO = " + kartNo + "\tKartPUAN = " + kartPuan + "\t");
          bilgisayarPuan += kartPuan;
          bilgisayarPanel.add(new JLabel(new ImageIcon(BlackJack.class.getResource("resimler/k" + kartNo + ".png"))));
          if(bilgisayarAS && bilgisayarPuan > 21) { // bilgisayarda AS var ama puanı 21'den büyük. AS=1 sayılır
            bilgisayarPuan -= 10;
            bilgisayarAS = false;
          }
          System.out.println("Toplam PUAN = " + bilgisayarPuan);
          bilgisayarMesaj = "Bilgisayar = " + bilgisayarPuan + " Puan";
        } else {
          bilgisayarDevam = false;
        }
      } // bilgisayar bitirdi
      // Durum Kontrol
      String durum;
      if(oyuncuPuan == 21 || bilgisayarPuan > 21) {
        oyuncuPara += bahis;
        durum = "KAZANDINIZ";
      } else if(oyuncuPuan > 21 || bilgisayarPuan == 21) {
        oyuncuPara -= bahis;
        durum = "KAYBETTİNİZ";
      } else if(oyuncuPuan == bilgisayarPuan) {
        durum = "BERABERE";
      } else {
        if(oyuncuPuan < bilgisayarPuan) {
          oyuncuPara -= bahis;
          durum = "KAYBETTİNİZ";
        } else {
          oyuncuPara += bahis;
          durum = "KAZANDINIZ";
        }
      }
      durumMesaj = "Bahis = " + bahis + "\n<html><h1>!!! " + durum + " !!!</h1></html>\nParanız = " + oyuncuPara;
      oyunPanel[0] = bilgisayarMesaj;
      oyunPanel[1] = bilgisayarPanel;
      oyunPanel[2] = durumMesaj;
      oyunPanel[3] = oyuncuPanel;
      oyunPanel[4] = oyuncuMesaj;
      JOptionPane.showMessageDialog(null, oyunPanel, "SKOR", JOptionPane.ERROR_MESSAGE,
              new ImageIcon(BlackJack.class.getResource("resimler/blackjack.png")));
      bilgisayarPanel.removeAll();
      oyuncuPanel.removeAll();
      if(oyuncuPara < 5) { // en küçük bahisten daha az para varsa
        durumMesaj = "<html><h2>Bahis için yeterli paranız kalmadı !!!</h2></html>" 
                        + "\n<html><h1>Paranız=" + oyuncuPara + " TL</h1></html>";
        oyunDevam = false;
      }      
    } while (oyunDevam);

    JOptionPane.showMessageDialog(null,
            durumMesaj, "Oyun Bitti !!!",
            JOptionPane.ERROR_MESSAGE,
            new ImageIcon(BlackJack.class.getResource("resimler/bitisLogo.png")));
  }
}
