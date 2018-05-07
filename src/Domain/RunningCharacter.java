package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class RunningCharacter extends Character {

    public RunningCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 8; i++){
            if(i==0)
                sprite.add(new Image(new FileInputStream("src/Assets/Running0.png")));
            else if(i==1)
                sprite.add(new Image(new FileInputStream("src/Assets/Running1.png")));
            else if(i==2)
                sprite.add(new Image(new FileInputStream("src/Assets/Running2.png")));
            else if(i==3)
                sprite.add(new Image(new FileInputStream("src/Assets/Running3.png")));
            else if(i==4)
                sprite.add(new Image(new FileInputStream("src/Assets/Running4.png")));
            else if(i==5)
                sprite.add(new Image(new FileInputStream("src/Assets/Running5.png")));
            else if(i==6)
                sprite.add(new Image(new FileInputStream("src/Assets/Running6.png")));
            else
                sprite.add(new Image(new FileInputStream("src/Assets/Running7.png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
//        super.setImage(sprite.get(0));
        int n=0;
        int i=100;
        while (true) {
            try {
//                for(int i=100;i<=800;i+=5){
                    super.setX(i);
                    super.setImage(sprite.get(n));
//                    Thread.sleep(50);
//                    int n=0;
//                    super.setImage(sprite.get(n));
//                    System.out.println(super.getImage());
                    n++;
                    i+=5;
                    if(n>7)
                        n=0;
                    if(i>700)
                        i=100;
//                    Thread.sleep(800);
//                    super.setX(700);
                    Thread.sleep(50);
//                }
            } 
            catch (InterruptedException ex) {}
        }
    }
    public String path(int n){
        if(n==0)
            return "src/Assets/Jumping0.png";
        else if(n==1)
             return "src/Assets/Jumping1.png";
        else if(n==2)
             return "src/Assets/Jumping2.png";
        else 
             return "src/Assets/Jumping3.png";
    }
}
