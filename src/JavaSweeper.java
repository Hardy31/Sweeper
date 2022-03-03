import javax.swing.*;
import java.awt.*;
import sweeper.Game;


public class JavaSweeper extends JFrame {
    private JPanel panel ;
    private Game game;



    public static void main(String[] args) {
        new JavaSweeper();
    }
    private JavaSweeper (){
        game = new Game();
         initPanel();
        initFrame();



    }
    private void initPanel(){
        panel = new JPanel() {
            @Override
            protected  void paintComponent(Graphics g) {
                super.paintComponent(g);
//                g.drawImage(getImage(),0,0,this);
//                g.drawImage(getImage("num1"),0,50,this);
//                g.drawImage(getImage("num2"),IMAGE_SIZE,IMAGE_SIZE,this);
//                g.drawImage(getImage("num5"),IMAGE_SIZE,0,this);

//                for (Box box: Box.values()) {
//                    g.drawImage(getImage(box.name().toLowerCase(Locale.ROOT)),box.ordinal()*IMAGE_SIZE,0,this);
//                }

//                Cell[][] pp = new PlayField(10*IMAGE_SIZE,10*IMAGE_SIZE).getPlayField();
//                Cell x2y3 = pp[2][3];
//                System.out.println(getImage(x2y3.getCellImage()));
//                System.out.println(x2y3.getNumberX()*IMAGE_SIZE);
//                System.out.println(x2y3.getNumberY()*IMAGE_SIZE);
//                g.drawImage(getImage(x2y3.getCellImage()),x2y3.getNumberX()*IMAGE_SIZE,x2y3.getNumberY()*IMAGE_SIZE,this);
//                  Game game = new Game()  ;

                game.drowPlayField(g, this);

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }

//                g.drawImage(getImage(),0,0,this);


            }

        };
//        panel.setPreferredSize(new Dimension(500, 500));
        add(panel);
    }

    private void initFrame(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        "/home/alex/Hardy/JavaSweeper/res/images/icon.png"
        setIconImage(getIcon());
        setTitle("Java Sweeper Hardy");
//        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
        setSize(500,800);

//        pack();
        setLocationRelativeTo(null);

    }
    private Image getIcon(){
        ImageIcon icon = new ImageIcon("res/images/icon.png");
        return icon.getImage();
    }
    private Image getImage(){
        ImageIcon icon = new ImageIcon("res/images/bomb.png");
        return icon.getImage();
    }
    private Image getImage(String imagName){
        ImageIcon icon = new ImageIcon("res/images/"+imagName+".png");
        return icon.getImage();
    }

}
