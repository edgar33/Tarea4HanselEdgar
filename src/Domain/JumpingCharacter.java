package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class JumpingCharacter extends Character {
     
    public JumpingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 2; i++){
            if(i==0)
            sprite.add(new Image(new FileInputStream("src/Assets/Jumping0.png")));
            else 
                sprite.add(new Image(new FileInputStream("src/Assets/Jumping1.png")));
        }
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        int x=super.getY();
        boolean con=true;
        while (true) {
            try {
//                Thread.sleep(800);
                this.setY(x);
                if(con)
                    x-=5;
                else
                    x+=5;
                if(x==170){
                    con=false;
                    super.setImage(sprite.get(1));
                }
                else if(x==370){
                    con=true;
                    super.setImage(sprite.get(0));
                }
                Thread.sleep(50);
//                this.setY(370);
            } 
            catch (InterruptedException ex) {} 
        }
    }
}
