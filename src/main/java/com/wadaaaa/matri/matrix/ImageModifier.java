package com.wadaaaa.matri.matrix;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;

public class ImageModifier{
    private BufferedImage img;

    public void setImage(BufferedImage img) {
        this.img = img;
    }

    private Kernel kernel;

    public ImageModifier(BufferedImage img) {
        this.img = img;
    }

    public Kernel getKernel() {
        return kernel;
    }

    public void setKernel(Kernel kernel) {
        this.kernel = kernel;
    }

    ArrayList<Color> kernelized = new ArrayList<>();
    BufferedImage modifiedImage;

    public void modify(){
        modifiedImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        SubImager subber = new SubImager(img);
        kernelized.clear();
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                var subbed = subber.getSub(x,y);
                modifiedImage.setRGB(x,y, kernel.kernelify(subbed).getRGB());
                kernelized.add(kernel.kernelify(subbed));

            }
        }
    }

    public WritableImage getModifierImage(){
        BufferedImage imageProcessed = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        int size = (int) img.getWidth();
        for(int i = 0; i < kernelized.size(); i++){
            int x = i % size;
            int y = i / size;
            imageProcessed.setRGB(x,y, kernelized.get(i).getRGB());
        }
        return SwingFXUtils.toFXImage(imageProcessed, null);
    }


}
