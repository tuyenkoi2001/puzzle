package level;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import java.util.Random;

public class ImageLoader {

    private final String fileLocal = System.getProperty("user.dir");
    private int NumberOfImage;
    public BufferedImage loadedImage;

    public ImageLoader(int level){
        NumberOfImage = level;
        try {
            Random random = new Random();
            int n = random.nextInt(level)+1;
            loadedImage = ImageIO.read(new File(fileLocal+"\\src\\level\\"+n+".png"));
            loadedImage = getScaleImage(loadedImage);
            //loadedImage = loadedImage.getScaledInstance(loadedImage.getWidth()/10,loadedImage.getHeight()/10,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ImageLoader(String path,int level){
        NumberOfImage = level;
        try {
            loadedImage = ImageIO.read(new File(path));
            loadedImage=getScaleImage(loadedImage);
            //loadedImage = loadedImage.getScaledInstance(loadedImage.getWidth()/10,loadedImage.getHeight()/10,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    BufferedImage getScaleImage(BufferedImage img){
        int ImageWidth = img.getWidth();
        int ImageHeight = img.getHeight();
        float ImageRatio = (float)ImageHeight/500;
        ImageWidth = (int)(ImageWidth/ImageRatio);
        ImageHeight = (int)(ImageHeight/ImageRatio);
        Image image = img.getScaledInstance(ImageWidth,ImageHeight,Image.SCALE_SMOOTH);
        BufferedImage bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bimage.createGraphics();
        g2d.drawImage(image,0,0,null);
        g2d.dispose();
        return bimage;
    }

    public BufferedImage crop(int x,int y,int width,int height)
    {
        return loadedImage.getSubimage(x,y,width,height);
    }

    public BufferedImage getImage(){
        return loadedImage;
    }
    public BufferedImage[] GetSetOfImage(){
        BufferedImage[] SetOfimg = new BufferedImage[NumberOfImage*NumberOfImage];

        int imgWidth = loadedImage.getWidth();
        int imgHeight = loadedImage.getHeight();
        int cropImageWidth = imgWidth/NumberOfImage;
        int cropImageHeight = imgHeight/NumberOfImage;
        int imgIndex = 0;

        for(int i=0;i<NumberOfImage;i++)
            for(int j=0;j<NumberOfImage;j++)
            {
                SetOfimg[imgIndex] = crop(j*cropImageWidth,i*cropImageHeight,cropImageWidth,cropImageHeight);
                imgIndex++;
            }
        return SetOfimg;
    }

}
