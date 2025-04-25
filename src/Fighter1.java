import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Fighter1 implements Runnable{

    public Character myCharacter, myEnemy;
    Scanner scan = new Scanner(System.in);
    public String replica;
    public  int allyAttack, allyDefense, allyHealth, enemyAttack, enemyDefense, enemyHealth;
    public  String allyName, enemyName;
    //public static Object o=new Object();

    public Fighter1(Character myCharacter, Character myEnemy) {
       /* this.allyAttack = myCharacter.attack;
        this.allyDefense = myCharacter.defense;
        this.allyHealth = myCharacter.health;
        this.enemyAttack = myEnemy.attack;
        this.enemyDefense = myEnemy.defense;
        this.enemyHealth = myEnemy.health;
        this.allyName = myCharacter.name;
        this.enemyName = myEnemy.name;
        */
        this.myCharacter=myCharacter;
        this.myEnemy=myEnemy;

    }

    @Override
    public void run() {
        //  while(this.myCharacter.didAction){
        //    try{
        //      wait();
        //   }catch (Exception e) {}
        //}
        synchronized (Main.o) {
            while (Main.battle == 1) {

                while (!Main.allyTurn) {
                    try {
                        Main.o.wait();
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("Ce vrei sa faci: Attack / Defend / Surrender ?");
                boolean ok = false;
                while (!ok) {
                    this.replica = scan.nextLine();
                    if (this.replica.equals("Attack")) {
                        this.attack();
                        Main.order++;
                        if (this.enemyHealth == 0) {
                            System.out.println("Ai castigat!");
                            Main.battle = 0;
                        }
                        ok = true;
                    } else if (this.replica.equals("Defend")) {
                        this.defend();
                        Main.order++;
                        ok = true;
                    } else if (this.replica.equals("Surrender")) {
                        System.out.println("Fugi ca o pisica");
                        ok = true;
                        System.exit(1);

                    } else {
                        System.out.println("Nu ai scris bine comanda!");
                    }
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
                Main.allyTurn = false;
                Main.o.notify();
            }

        }


    }

    public  void attack() {
        int dealt = (int) (this.myCharacter.attack -(((float) this.myEnemy.defense / 100) * this.myCharacter.attack));
        this.myEnemy.health-=dealt;
        this.myCharacter.attack+=Rambo.randInt(1,5);
        if(this.myEnemy.health<0)
            this.myEnemy.health=0;
        GUI.textArea.append("\nL-ai lovit pe "+this.myEnemy.name+" cu "+dealt+" DMG. A ramas cu "+this.myEnemy.health
                +" HP\n===================");
        // System.out.printf("%s Attacked %s with %d Damage %n %s Has %d Health left %n"
        //         , allyName, enemyName, allyAttack, enemyName, enemyHealth);
        //System.out.println("=====================");

    }
    public  void defend() {
        int defPlus=Rambo.randInt(1,9);
        if(this.myCharacter.defense+defPlus<50){
            this.myCharacter.defense+=defPlus;
            GUI.textArea.append("\nTi-ai crescut defensiva cu "+defPlus
                    +".\nAcum ai "+this.myCharacter.defense+" DEF\n===================");
        }else {
            this.myCharacter.defense=50;
            GUI.textArea.append("\nAi ajuns la nivelul maxim de protectie! Ai 50 DEF!\n===================");
        }

        //System.out.printf("%s Increased The Defense with : %d %n New Defense : %d %n"
        //       , allyName, defPlus, allyDefense);
    }

   /* public  void attack() {
        int dealt = (int) (this.allyAttack -(((float) this.enemyDefense / 100) * this.allyAttack));
        this.enemyHealth-=dealt;
        if(this.enemyHealth<0)
            this.enemyHealth=0;
        GUI.textArea.append("\nL-ai lovit pe "+this.enemyName+" cu "+dealt+" DMG. A ramas cu "+this.enemyHealth
                +" HP\n===================");
       // System.out.printf("%s Attacked %s with %d Damage %n %s Has %d Health left %n"
       //         , allyName, enemyName, allyAttack, enemyName, enemyHealth);
        //System.out.println("=====================");

    }


    public  void defend() {
        int defPlus=Rambo.randInt(1,5);
        this.allyDefense+=defPlus;
        GUI.textArea.append("\nTi-ai crescut defensiva cu "+defPlus
                +".\nAcum ai "+this.allyDefense+" DEF\n===================");
        //System.out.printf("%s Increased The Defense with : %d %n New Defense : %d %n"
         //       , allyName, defPlus, allyDefense);
    }

    */


}

