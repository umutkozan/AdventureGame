import java.util.Random;

public abstract class BattleLocation extends Location {
    private Monster monster;
    private String award;

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }

    private int maxMonster;

    public BattleLocation(Player player, String name, Monster monster, String award, int maxMonster) {
        super(player, name);
        this.monster = monster;
        this.award = award;
        this.maxMonster = maxMonster;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }


    @Override
    public boolean onLocation() {
        int monsterNumber = this.randomMonsterNumber();
        System.out.println("Şuan Buradasınız. : " + this.getName());
        System.out.println("Dikkatli ol. Haritada " + monsterNumber + "  " + this.getMonster().getName() + " var.");
        System.out.print("<S>AVAŞ YA DA <K>AÇ : ");
        String selectWar = input.nextLine();
        selectWar = selectWar.toUpperCase();
        if (selectWar.equals("S") && fight(monsterNumber)){
                System.out.println(this.getName() + " tüm düşmanları yendiniz.");
                return true;
        }
        if (this.getPlayer().getHealthy() <= 0) {
            System.out.println("Öldünüz. Oyun bitti...");
            return false;
        }
        return true;
    }

    public boolean fight(int monsNumber) {
        for (int i = 0; i < monsNumber; i++) {
            this.getMonster().setHealth(this.getMonster().getOrjinalhealth());
            playerInfo();
            monsterInfo(i);
            while (this.getPlayer().getHealthy() > 0 && this.getMonster().getHealth() > 0) {
                System.out.println("*V*ur veya *K*aç");
                String selectWar = input.nextLine().toUpperCase();
                if (selectWar.equals("V")) {
                    System.out.println("Siz vurdunuz. !");
                    this.getMonster().setHealth((this.getMonster().getHealth() - this.getPlayer().getHealthy()));
                    afterHit();
                    if (this.getMonster().getHealth() > 0) {
                        System.out.println("Canavar size vurdu. !");
                        int monsterDamage = this.getMonster().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy()-monsterDamage);
                        if (monsterDamage < 0) {
                            monsterDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy());
                        afterHit();
                    }
                } else {
                    return false;
                }
            }
            if(this.getMonster().getHealth() <this.getPlayer().getHealthy()){
                System.out.println(this.getMonster().getAward() + " para kazandınız. !");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getMonster().getAward());
                System.out.println("Güncel bakiye : " +this.getPlayer().getMoney());
            } else {
                return false;
            }
        }
        return true;
    }

    public void afterHit() {
        System.out.println("Canınız : " + this.getPlayer().getHealthy());
        System.out.println(this.getMonster().getName() + " Canı : " + this.getMonster().getHealth());
        System.out.println();
    }

    public void playerInfo() {
        System.out.println("Oyuncu : " + this.getPlayer().getCharName());
        System.out.println("--------------------------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealthy());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Hasar koruma : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Para : " + this.getPlayer().getMoney());
    }

    public void monsterInfo(int i) {
        System.out.println(i + ". Canavar : " + this.getMonster().getName());
        System.out.println("-----------------------------------------------");
        System.out.println("Sağlık : " + this.getMonster().getHealth());
        System.out.println("Hasar : " + this.getMonster().getDamage());
        System.out.println("Ödül : " + this.getMonster().getAward());
    }

    public int randomMonsterNumber() {
        Random rand = new Random();
        return rand.nextInt(this.getMaxMonster()) + 1;

    }
}
