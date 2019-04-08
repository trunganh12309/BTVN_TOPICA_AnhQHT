import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Main {

    public static void main(String[] args) {
                BufferedImage img = null;
                File f;

                // open image
                try
                {
                    f = new File("D:\\Download\\BTVN-Topica\\img-input.jpg");
                    img = ImageIO.read(f);
                }
                catch(IOException e)
                {
                    System.out.println(e);
                }

                // Get image width and height
                int width = img.getWidth();
                int height = img.getHeight();

                // Change color
                for (int y = 0; y < height; y++)
                {
                    for (int x = 0; x < width; x++)
                    {
                        int p = img.getRGB(x,y);
                        int a = (p>>24)&0xff;
                        int r = (p>>16)&0xff;
                        int g = (p>>8)&0xff;
                        int b = p&0xff;
                        if(r>=50&&g+b<r){
                            g=r;
                            r=0;
                            b=0;
                        }
                        //set new RGB value
                        p = (a<<24) | (r<<16) | (g<<8) | b;
                        img.setRGB(x, y, p);
                    }
                }

                // write image
                try
                {
                    f = new File("D:\\Download\\BTVN-Topica\\img-output.jpg");
                    ImageIO.write(img, "jpg", f);
                }
                catch(IOException e)
                {
                    System.out.println(e);
                }
    }
}