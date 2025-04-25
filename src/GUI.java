import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;

public class GUI implements ActionListener{
    public static int dealt, defplus;
    public static JFrame frame;
    public static JPanel panel;
    public static JLabel label;
    public static JButton[] characterButtons = new JButton[11];
    public static JButton[] fightButtons = new JButton[4];
    public static JButton positive, negative;
    public static JButton selectButton;
    public static JTextField textField;
    public static JTextArea textArea, championList;
    public static Font myFont = new Font("Times New Roman", Font.BOLD, 20);
    public static JTextArea enemyArea, conclusionArea, endArea;
    public static boolean fightPressed=false,gameDecision=true,yesPressed=true;
    public static JScrollPane scrollPane;
    public static DefaultCaret caret;

    public GUI() {

        frame = new JFrame();
        frame.setTitle("League Of Java");
        frame.getLayeredPane();
        frame.setLayout(null);
        frame.setLocation(0, 0);
        frame.setSize(1000, 1040);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        // CREARE PANEL //
        panel = new JPanel();
        panel.setBounds(0, 0, 1000, 1040);
        panel.setBackground(Color.black);
        frame.add(panel);
        // CREARE LABEL //
        label = new JLabel();
        panel.add(label);
        label.setIcon(new ImageIcon(GUI.class.getClassLoader().getResource("resources/bataiefundal.png")));

        textField = new JTextField();
        textField.setBounds(665, 15, 275, 40);
        textField.setFocusable(false);
        textField.setFont(myFont);
        label.add(textField);

        textArea = new JTextArea();
        textArea.setBounds(15, 15, 600, 50);
        textArea.setBackground(Color.black);
        textArea.setFocusable(false);
        textArea.setText("");
        textArea.setForeground(Color.black);
        textArea.setOpaque(false);
        textArea.setFont(myFont);
        textArea.setVisible(false);

        caret=(DefaultCaret) textArea.getCaret();
        textArea.setCaretPosition(textArea.getDocument().getLength());
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        scrollPane=new JScrollPane(textArea);
        label.add(scrollPane);
        scrollPane.setBounds(15,15,615,200);
        scrollPane.setBorder(null);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setOpaque(false);
        textArea.setOpaque(false);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        scrollPane.setVisible(false);

        championList = new JTextArea();
        championList.setBounds(15, 15, 475, 300);
        championList.setBackground(Color.black);
        championList.setFocusable(false);
        championList.setText("");
        championList.setForeground(Color.black);
        championList.setOpaque(false);
        championList.setFont(myFont);
        championList.setVisible(false);
        label.add(championList);

        enemyArea = new JTextArea();
        enemyArea.setBounds(15, 70, 600, 50);
        enemyArea.setBackground(Color.black);
        enemyArea.setFocusable(false);
        enemyArea.setText("");
        enemyArea.setForeground(Color.black);
        enemyArea.setOpaque(false);
        enemyArea.setFont(myFont);
        enemyArea.setVisible(false);
        label.add(enemyArea);

        conclusionArea = new JTextArea();
        conclusionArea.setBounds(15, 125, 452, 50);
        conclusionArea.setBackground(Color.black);
        conclusionArea.setFocusable(false);
        conclusionArea.setText("");
        conclusionArea.setForeground(Color.black);
        conclusionArea.setOpaque(false);
        conclusionArea.setFont(myFont);
        conclusionArea.setVisible(false);
        label.add(conclusionArea);

        endArea = new JTextArea();
        endArea.setBounds(15, 180, 452, 25);
        endArea.setBackground(Color.black);
        endArea.setFocusable(false);
        endArea.setText("Mai vrei sa joci?");
        endArea.setForeground(Color.black);
        endArea.setOpaque(false);
        endArea.setFont(myFont);
        endArea.setVisible(false);
        label.add(endArea);
        positive = new JButton("Yes");
        positive.setBounds(5, 220, 100, 30);
        label.add(positive);
        negative = new JButton("No");
        negative.setBounds(115, 220, 100, 30);
        label.add(negative);

        positive.setFocusable(false);
        positive.addActionListener(this);
        positive.setFont(myFont);
        positive.setVisible(false);
        positive.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yesPressed=true;
                textArea.setText("RELOADING...");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        textField.setText("");
                        positive.setVisible(false);
                        negative.setVisible(false);
                    }
                });
                new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        Thread.sleep(1500);
                        unviewScrollPane();
                        gameDecision=true;
                        textArea.setText("");
                        return null;
                    }
                }.execute();

            }
        });

        negative.setFocusable(false);
        negative.addActionListener(this);
        negative.setFont(myFont);
        negative.setVisible(false);
        negative.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                positive.setVisible(false);
                negative.setVisible(false);

                textArea.setText("CLOSING...");
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                        System.exit(1);
                    }
                });
            }
        });

        frame.setVisible(true);
    }
////////////////////////////// SCROLLPANE SETTINGS /////////////////////////////////////////////////
    public void viewScrollPane() {
        scrollPane.setVisible(true);
    }
    public void unviewScrollPane() {
        scrollPane.setVisible(false);
    }
    ///////////////////////// BACKGROUND SETTINGS /////////////////////////////////////////////////////////
    public static void setPicture(String fileName) {
        label.setIcon(new ImageIcon(GUI.class.getClassLoader().getResource("resources/"+fileName)));
    }

    /////////////////////////    ZONA DE TEXT PENTRU END AREA   ///////////////////////////////////////////
    public static void showEndArea() {
        endArea.setVisible(true);
    }

    public static void unshowEndArea() {
        endArea.setVisible(false);
    }

    /////////////////////////    ZONA DE TEXT PENTRU COCLUZIE   ///////////////////////////////////////////
    public static void showConclusionArea() {
        conclusionArea.setVisible(true);
    }

    public static void unshowConclusionArea() {
        conclusionArea.setVisible(false);
    }

    /////////////////////////    ZONA DE TEXT PENTRU INAMIC     ///////////////////////////////////////////
    public static void showEnemyArea() {
        enemyArea.setVisible(true);
    }

    public static void unshowEnemyArea() {
        enemyArea.setVisible(false);
    }

    /////////////////////////    LISTA CAMPIONI     /////////////////////////////////////////////
    public static void setList() {

        championList.setText("Alegeti unul dintre campioni: " + System.lineSeparator());
        for (int i = 1; i <= CharacterList.count; i++)
            championList.setText(championList.getText().concat("Nume: " + CharacterList.list[i].name + ", Atac: "
                    + CharacterList.list[i].attack + ", Defensiva: " + CharacterList.list[i].defense +
                    ", HP: " + CharacterList.list[i].health + "." + System.lineSeparator()));
    }

    public static void showList() {
        championList.setVisible(true);
    }

    public static void unshowList() {
        championList.setVisible(false);
    }

    ////////////////////////   ZONA DE TEXT PENTRU BATALIE    /////////////////////////////////////////////
    public static void showTextArea() {
        textArea.setVisible(true);
    }

    public static void unshowTextArea() {
        textArea.setVisible(false);
    }

    /////////////////////////////     BUTOANE FIGHT    /////////////////////////////////////////////
    public static void viewFightButtons() {
        for (int i = 1; i <= 3; i++) {
            fightButtons[i].setVisible(true);
        }
    }

    public static void unviewFightButtons() {
        for (int i = 1; i <= 3; i++) {
            fightButtons[i].setVisible(false);
        }
    }

    public void createFightButtons() {
        //textField.setBounds(665,15,275,40);
        fightButtons[1] = new JButton("Attack");
        fightButtons[1].setBounds(700, 20, 100, 30);
        fightButtons[2] = new JButton("Defend");
        fightButtons[2].setBounds(700, 60, 100, 30);
        fightButtons[3] = new JButton("Surrender");
        fightButtons[3].setBounds(700, 100, 120, 30);
        int i;
        for (i = 1; i <= 3; i++) {
            label.add(fightButtons[i]);
            fightButtons[i].setFocusable(false);
            fightButtons[i].addActionListener(this);
            fightButtons[i].setFont(myFont);
            fightButtons[i].setVisible(false);
        }
    }

    /////////////////////////////    BUTON SELECT     /////////////////////////////////////////////////
    public static void viewSelectButton() {
        selectButton.setVisible(true);
    }

    public static void unviewSelectButton() {
        selectButton.setVisible(false);
    }

    /////////////////////////////    BUTOANE CARACTERE    ////////////////////////////////////////////
    public static void viewCharacterButtons() {

        for (int i = 1; i <= CharacterList.count; i++)
            characterButtons[i].setVisible(true);
        textField.setVisible(true);
    }

    public static void unviewCharacterButtons() {
        int i;
        for (i = 1; i <= CharacterList.count; i++)
            characterButtons[i].setVisible(false);
        textField.setVisible(false);
    }

    public void createCharacterButtons() {
        //textArea.setBounds(15,15,452,300);
        selectButton = new JButton("Select");
        label.add(selectButton);
        selectButton.setBounds(750, 65, 100, 30);
        selectButton.setFocusable(false);
        selectButton.setFont(myFont);
        selectButton.addActionListener(this);
        selectButton.setVisible(false);
        int i, c = 0;
        for (i = 1; i <= CharacterList.count; i++) {
            characterButtons[i] = new JButton(CharacterList.list[i].name);
            label.add(characterButtons[i]);
            characterButtons[i].setBounds(490, 35 + c, 145, 21);
            characterButtons[i].setFocusable(false);
            characterButtons[i].addActionListener(this);
            characterButtons[i].setFont(myFont);
            characterButtons[i].setVisible(false);
            c += 26;
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 1; i <= CharacterList.count; i++) {
            if (e.getSource() == characterButtons[i]) {
                textField.setText(CharacterList.getChampionName(i));
                viewSelectButton();
            }
        }
        if(e.getSource()== selectButton){
            if(Main.characterOrder==1){
                for (int i = 1; i <= CharacterList.count; i++) {
                    if (CharacterList.list[i].name.equals(textField.getText())) {
                        Main.myCharacter=new Character("",0,0,0);
                        Main.myCharacter.name=CharacterList.list[i].name;
                        Main.myCharacter.attack=CharacterList.list[i].attack;
                        Main.myCharacter.defense=CharacterList.list[i].defense;
                        Main.myCharacter.health=CharacterList.list[i].health;
                    }
                }
                unviewSelectButton();
                textField.setText("Acum alege-ti inamicul!");
                Main.characterOrder++;
            }
            else if(Main.characterOrder==2){
                for (int i = 1; i <= CharacterList.count; i++) {
                    if (CharacterList.list[i].name.equals(textField.getText())) {
                        Main.enemyCharacter=new Character("",0,0,0);
                        Main.enemyCharacter.name=CharacterList.list[i].name;
                        Main.enemyCharacter.attack=CharacterList.list[i].attack;
                        Main.enemyCharacter.defense=CharacterList.list[i].defense;
                        Main.enemyCharacter.health=CharacterList.list[i].health;
                    }
                }

                unviewCharacterButtons();
                unviewSelectButton();
                unshowList();
                showTextArea();
                Main.characterOrder++;
                Main.choseCharacters=true;
                Main.battle=1;
                fightPressed=false;
                Main.fighter1=new Fighter1(Main.myCharacter,Main.enemyCharacter);
                Main.fighter2=new Fighter2(Main.enemyCharacter,Main.myCharacter);
                //Main.tFighter1=new Thread(Main.fighter1);
                //Main.tFighter2 = new Thread(Main.fighter2);
                setPicture("binitial.png");
                viewScrollPane();
                textArea.append("\nSA INCEAPA BATALIA\n===================");

                new SwingWorker() {
                    @Override
                    protected Object doInBackground() throws Exception {
                        Thread.sleep(2000);
                        textArea.append("\nCe vrei sa faci: Attack/ Defend/ Surrender?\n===================");
                        viewFightButtons();
                        return null;
                    }
                }.execute();

            }
        }

        if(e.getSource()==fightButtons[1]){
            fightPressed=true;
            Main.fighter1.attack();
            setPicture("ballyhit.png");
            if(Main.fighter1.myEnemy.health==0){
                setPicture("ballywin.png");
                fightPressed=false;
                textArea.append("\nAI CASTIGAT GG!\n===================");
                Main.battle=0;
                gameDecision=false;
                yesPressed=false;
            }
        }
        if(e.getSource()==fightButtons[2]){
            fightPressed=true;
            Main.fighter1.defend();
            setPicture("ballydefense.png");
        }
        if(e.getSource()==fightButtons[3]){
                textArea.append("\nFUGI CA O PISICUTA");
                setPicture("renunt.png");
                unviewFightButtons();
            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    Thread.sleep(3000);
                    System.exit(1);
                    return null;
                }
            }.execute();
              //  SwingUtilities.invokeLater(new Runnable() {
              //      @Override
              //      public void run() {
              //      }
              //  });

        }
        if(fightPressed){
            unviewFightButtons();
            fightPressed=false;
            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    int enemyBehaviour=Rambo.randInt(1,100);
                    Thread.sleep(2500);
                    if((int) (Main.fighter2.myCharacter.attack -(((float) Main.fighter2.myEnemy.defense / 100) * Main.fighter2.myCharacter.attack))>=Main.fighter2.myEnemy.health){
                        setPicture("benemyhit.png");
                        Main.fighter2.attack();
                        if(Main.fighter2.myEnemy.health==0){
                            new SwingWorker() {
                                @Override
                                protected Object doInBackground() throws Exception {
                                    Thread.sleep(1500);
                                    setPicture("benemywin.png");
                                    textArea.append("\nAI PIERDUT\n===================");
                                    Main.battle=0;
                                    gameDecision=false;
                                    yesPressed=false;
                                    positive.setVisible(true);
                                    negative.setVisible(true);
                                    return null;
                                }
                            }.execute();
                        }
                        if(Main.fighter2.myEnemy.health>0){
                            viewFightButtons();
                        }
                    } else if(Main.fighter2.myCharacter.defense==50){
                        setPicture("benemyhit.png");
                        Main.fighter2.attack();
                        if(Main.fighter2.myEnemy.health==0){
                            new SwingWorker() {
                                @Override
                                protected Object doInBackground() throws Exception {
                                    Thread.sleep(1500);
                                    setPicture("benemywin.png");
                                    textArea.append("\nAI PIERDUT\n===================");
                                    Main.battle=0;
                                    gameDecision=false;
                                    yesPressed=false;
                                    positive.setVisible(true);
                                    negative.setVisible(true);
                                    return null;
                                }
                            }.execute();
                        }
                        if(Main.fighter2.myEnemy.health>0){
                            viewFightButtons();
                        }
                    } else if(enemyBehaviour%2==1){
                        setPicture("benemyhit.png");
                        Main.fighter2.attack();
                        if(Main.fighter2.myEnemy.health==0){
                            new SwingWorker() {
                                @Override
                                protected Object doInBackground() throws Exception {
                                    Thread.sleep(1500);
                                    setPicture("benemywin.png");
                                    textArea.append("\nAI PIERDUT\n===================");
                                    Main.battle=0;
                                    gameDecision=false;
                                    yesPressed=false;
                                    positive.setVisible(true);
                                    negative.setVisible(true);
                                    return null;
                                }
                            }.execute();
                        }
                        if(Main.fighter2.myEnemy.health>0){
                            viewFightButtons();
                        }
                    }else{
                        setPicture("benemydefense.png");
                        Main.fighter2.defend();
                        viewFightButtons();
                    }
                    return null;
                }
            }.execute();
        }
        if(!gameDecision && !yesPressed){
            unviewFightButtons();
            new SwingWorker() {
                @Override
                protected Object doInBackground() throws Exception {
                    Thread.sleep(2000);
                    textArea.append("\nMai vrei sa joci?");
                    positive.setVisible(true);
                    negative.setVisible(true);
                    return null;
                }
            }.execute();
        }

    }
    }
