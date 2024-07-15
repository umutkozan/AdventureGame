public class SafeHouse extends NormalLocation{
    public SafeHouse(Player player) {
        super(player, "Güvenli Ev");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Güvenli evdesiniz. !");
        System.out.println("Canınız yenilendi. !");
        this.getPlayer().setHealthy(this.getPlayer().getOrjinalHealth());
        return  true;
    }
}
