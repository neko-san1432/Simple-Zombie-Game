package Exer05_Repetition;
import javax.swing.*;
public class Exer05c_Zombiegame{
    public static void main(String[] args) {
        int dmg = 0,
            t_dmg = 0,
            z_hp = 0,
            bs_z_dist = 200,
            r_bullets = 0,
            mags = 0,
            z_dist = 0,
            z_spd = 0,
            z_def = 0,
            num_shot,bullets =0;
        String z_type = "";
        int z_opt = Integer.parseInt(JOptionPane.showInputDialog("Commander: We need your help now! Choose your zombie you wanna kill. Each of us has it's own preferences\n" +
                    "*Enter a random number to choose your zombie you will kill:"));
        int z_chc = z_opt % 3;
        switch (z_chc) {
            case 0 -> {
                z_hp = 4000;
                z_dist = 200;
                z_spd = 40;
                z_def = 500;
                z_type = "Normal";
                JOptionPane.showMessageDialog(null, "You have encounter a normal zombie");
            }
            case 1 -> {
                z_hp = 6000;
                z_dist = 200;
                z_spd = 30;
                z_def = 700;
                z_type = "Elite";
                JOptionPane.showMessageDialog(null, "You have encounter a elite zombie\nProceed with caution");
            }
            case 2 -> {
                z_hp = 9900;
                z_dist = 200;
                z_spd = 20;
                z_def = 900;
                z_type = "Boss";
                JOptionPane.showMessageDialog(null, "You have encounter a BOSS zombie!\nCareful! That thing is tough!");
            }
            default -> JOptionPane.showMessageDialog(null, "That's not a number, you need to ");
        }
        int gun_chc = Integer.parseInt(JOptionPane.showInputDialog("""
                Choose your gun soldier:
                [1] Sub-Machine Gun
                [2] Light Machine Gun
                [3] Heavy Machine Gun
                [4] Shotgun
                [5] Rifle"""));

        while (gun_chc >5 || gun_chc <0) {
            JOptionPane.showMessageDialog(null, "Commander: Be serious, soldier!");
            gun_chc = Integer.parseInt(JOptionPane.showInputDialog("""
                Choose your gun soldier:
                [1] Sub-Machine Gun
                [2] Light Machine Gun
                [3] Heavy Machine Gun
                [4] Shotgun
                [5] Rifle"""));
        }
        if (gun_chc == 1)
        {
            dmg = 35;
            bullets = 25;
            r_bullets = 25;
            mags = 17;
        }
        else if (gun_chc == 2)
        {
            dmg = 45;
            bullets = 100;
            r_bullets = 100;
            mags = 2;
        }
        else if (gun_chc == 3)
        {
            dmg = 60;
            bullets = 300;
            r_bullets = 300;
            mags = 1;
        }
        else if (gun_chc == 4)
        {
            int int_dmg = 10;
            dmg = int_dmg * 8;
            bullets = 8;
            r_bullets = 8;
            mags = 15;
        }
        else if (gun_chc == 5)
        {
            dmg = 70;
            bullets = 25;
            r_bullets = 25;
            mags = 11;
        }
        else {
            JOptionPane.showMessageDialog(null, "Commander: Choose properly soldier");
        }
            JOptionPane.showMessageDialog(null,"Commander: Good choice! Now let's kick some brain-dead person");
        if(z_hp > 0) {
            while (z_hp > 0) {
                float b_shot = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of percentage of you will shot\n" +
                        "Total bullets: " + bullets + "\n" +
                        "Total magazines: " + mags));
                int crt_num = Integer.parseInt(JOptionPane.showInputDialog("""
                        Enter random number:
                        *For a chance to have critical hit
                        *Critical hit can double the damage of each bullet""")),
                        crt_dcs = crt_num % 2;
                float prct = b_shot/100;
                switch (crt_dcs) {
                    case 0:
                        t_dmg *= 2;
                        JOptionPane.showMessageDialog(null, "You got critical hit boost");
                        break;
                    case 1:
                        break;
                }
                if (b_shot >= 1 && b_shot <= 100) {
                    num_shot = (int) (bullets * (prct));
                    t_dmg = num_shot * dmg;
                    z_hp -= t_dmg / 2;
                    z_def -= t_dmg / 2;
                    bullets -= num_shot;
                    z_dist -= z_spd;
                    if(z_def<=0){
                        z_hp-=t_dmg;
                        z_def=0;
                    }
                } else if (b_shot >= 100||b_shot<=0){
                        JOptionPane.showMessageDialog(null, "Commander: Come on, soldier!");
                }
                if (z_dist <= bs_z_dist) {
                    z_dist -= z_spd;
                } else if (z_dist <= 0) {
                    JOptionPane.showMessageDialog(null, "YOUR DEAD\n GAME OVER");
                    System.exit(0);
                }

                if(z_hp <= 0){
                    z_hp = 0;
                    JOptionPane.showMessageDialog(null, "Commander: Thank you soldier, the world is back in peace...");
                    System.exit(0);
                }else if (z_hp > 0) {
                    JOptionPane.showMessageDialog(null, "" + z_type + " zombie status report\n" +
                            "Health points: " + z_hp + "\n" +
                            "Armor points: " + z_def);
                }
                if (mags == 0) {
                    JOptionPane.showMessageDialog(null, "Darn it, I don't have mags left...");
                }
                if (bullets == 0) {
                    JOptionPane.showMessageDialog(null, "Reloading...");
                    z_dist -= z_spd;
                    bullets += r_bullets;
                    mags -= 1;
                } else if (bullets == 0 && mags == 0){
                    JOptionPane.showMessageDialog(null, "Oh no...");
                    System.exit(0);
                }
            }
        }
    }
}