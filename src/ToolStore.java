public class ToolStore extends NormalLocation {
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        boolean showMenu = true;
        System.out.println("Mağazadasınız. !");
        while (showMenu) {
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış yap");
            System.out.print("Seçim yapabilirsiniz. :");
            int selectItem = input.nextInt();
            while (selectItem < 0 || selectItem > 3) {
                System.out.println("Geçersiz değer girdiniz. Tekrar değer girin : ");
                selectItem = input.nextInt();
            }
            switch (selectItem) {
                case 1:
                    printWeapons();
                    buyWeapon();
                    break;
                case 2:
                    printArmors();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Marketten çıkış yaptınız");
                    showMenu = false;
                    break;
            }
        }
        return true;

    }


    public void printWeapons() {
        System.out.println("Silahlar");
        System.out.println("*****************************************");
        for (Weapon weapon : Weapon.weapons()) {
            System.out.println(weapon.getName() + " **** Para : " + weapon.getPrice() + " Hasar : " + weapon.getDamage() + " ****");
        }
        System.out.println("0 - Çıkış yap");


    }

    public void buyWeapon() {
        System.out.print("Bir silah seçiniz : ");
        int selectWeaponId = input.nextInt();
        while (selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
            System.out.println("Geçersiz değer girdiniz. Tekrar değer girin : ");
            selectWeaponId = input.nextInt();
        }
        if (selectWeaponId != 0) {
            Weapon selectedWeapon = Weapon.getWeaponById(selectWeaponId);


            if (selectedWeapon != null) {
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız yok. ");
                } else {
                    //Satın alma işleminin gerçekleştiği alan
                    System.out.println(selectedWeapon.getName() + " silah satın aldınız. ");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);
                }
            }
        }
    }

    public void printArmors() {
        for (Armor arm : Armor.armors()) {
            System.out.println(arm.getId() + " - " + arm.getName() + " - " + "Para  : " + arm.getPrice()
                    + " Hasar engelleme : " + arm.getBlock()
            );
        }
        System.out.println("0 - Çıkış Yap");
    }


    public void buyArmor() {
        System.out.println("Bir zırh seçiniz : ");
        int selectedArmorId = input.nextInt();
        while (selectedArmorId < 0 || selectedArmorId > Armor.armors().length) {
            System.out.println("Geçersiz değer girdiniz. Tekrar değer girin : ");
            selectedArmorId = input.nextInt();
        }

        if (selectedArmorId != 0) {
            Armor selectedArmor = Armor.getArmorById(selectedArmorId);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız yok. ");
                } else {
                    //Zırh satın alma işleminin gerçekleştiği alan
                    System.out.println(selectedArmor.getName() + " zırh satın aldınız. ");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());

                }
            }


        }
    }
        public void exitMenu () {
            System.out.println("Mağazadan çıkış yaptınız.");


        }
    }
