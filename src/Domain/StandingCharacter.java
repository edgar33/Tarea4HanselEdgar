package Domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

public class StandingCharacter extends Character {

    public StandingCharacter(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException{
        ArrayList<Image> sprite = super.getSprite();
        for(int i = 0; i < 4; i++){
//            if();
            sprite.add(new Image(new FileInputStream("src/Assets/Standing"+i+".png")));
        }
        super.setSprite(sprite);
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        int n=0;
        super.setImage(sprite.get(2));
        n++;
        if(n>8)
            n=0;
        while (true) {
            try {
                super.setImage(sprite.get(0));
                Thread.sleep(800);
                super.setImage(sprite.get(1));
                Thread.sleep(800);
                super.setImage(sprite.get(2));
                Thread.sleep(800);
                super.setImage(sprite.get(3));
                Thread.sleep(800);
                
            } 
            catch (InterruptedException ex) { }
        }
    }
}
