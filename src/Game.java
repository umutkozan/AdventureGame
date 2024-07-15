import java.sql.SQLOutput;
import java.util.Scanner;
public class Game {
    Scanner scanner = new Scanner(System.in);

    void start() {
        System.out.println("Adventure Game ! ");
        System.out.print("Kullanıcı adınızı girin : ");
        String playerName = scanner.nextLine();
        Player player = new Player(playerName);
        System.out.println(player.getName() + " hoşgeldin. !");
        System.out.println("Karakterinizi seçin . ");
        player.selectChar();

        Location location = null;
        while(true) {
            player.printPlayerInfo();
            System.out.println("Gidebileceğiniz bölgeler : ");
            System.out.println("----------------------------------------------------");
            System.out.println("1- Güvenli ev.");
            System.out.println("2- Alışveriş : Silah veya özellik satın alabilirsiniz.");
            System.out.println("3- Mağaraya gir. Ödül->Yemek : Dikkatli ol ! Zombilerin bölgesine ışınlanıyorsun.");
            System.out.println("4- Ormana gir. Ödül->Odun : Dikkatli ol !  Vampirlerin bölgesine ışınlanıyorsun.");
            System.out.println("5- Nehire in. Ödül->Su : Dikkatli ol ! Ayıların bölgesine ışınlanıyorsun.");
            System.out.println("0- Oyundan çıkış yap");
            System.out.print("Lütfen ışınlanmak istediğiniz bölgeyi seçin. ! : ");
            int selectLoc = scanner.nextInt();
            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz. !");

            }
            if(location == null){
                System.out.println("Oyun bitti...");
                break;
            }

            if(!location.onLocation()){
                System.out.println("Canın bitti... Game Over!");
                break;
            }
        }
    }
}