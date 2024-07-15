
import java.util.Scanner;

public class Player {
    private int damage;
    private int healthy;
    private int orjinalHealth;
    private int money;


    private String charName;
    private String name;
    private Inventory inventory;
    Scanner scanner = new Scanner(System.in);

    public Player(String name) {
        this.name = name;
        this.inventory = new Inventory();

    }

    public void selectChar() {
        GameCharacter[] characterList = {new Samurai(), new Archer(), new Knight()};
        for (GameCharacter gameChar : characterList) {
            System.out.println("*****************************************************************************");
            System.out.println("ID : " + gameChar.getId() +
                    "\t Karakter : " + gameChar.getName() +
                    "\t Hasarı : " + gameChar.getDamage() + " " +
                    "\t Sağlık : " + gameChar.getHealth() + " " +
                    "\t Para :" + gameChar.getMoney());
        }
        System.out.println("**************************************************************************");
        System.out.println("Bir karakter seçiniz : ");
        int selectChar = scanner.nextInt();
        switch (selectChar) {
            case 1:
                startPlayer(new Samurai());
                break;
            case 2:
                startPlayer(new Archer());
                break;
            case 3:
                startPlayer(new Knight());
                break;
            default:
                startPlayer(new Knight());
        }
        System.out.println("Seçtiğiniz karakter : " + this.getCharName() +
                " Canı : " + this.getHealthy() + " Hasarı : "
                + this.getDamage() +
                " Para : " + getMoney());
    }

    public void startPlayer(GameCharacter game) {
        this.setCharName(game.getName());
        this.setDamage(game.getDamage());
        this.setHealthy(game.getHealth());
        this.setOrjinalHealth(game.getHealth());
        this.setMoney(game.getMoney());
    }

    public void printPlayerInfo() {
        System.out.println("Silahınız : "+ this.getInventory().getWeapon().getName() +
                ", Zırhınız  :  "+ this.getInventory().getArmor().getName() +
                ", Hasar engelleme :  "+ this.getInventory().getArmor().getBlock() +
                ", Can : " + this.getHealthy()+
                ", Hasar : "  + this.getTotalDamage()+
                ", Para : " + getMoney());


    }
   public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
   }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        if(healthy <0){
            healthy = 0;
        }
        this.healthy = healthy;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player(Inventory inventory) {
        this.inventory = inventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
    public int getOrjinalHealth() {
        return orjinalHealth;
    }

    public void setOrjinalHealth(int orjinalHealth) {
        this.orjinalHealth = orjinalHealth;
    }
}
