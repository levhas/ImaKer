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
    private BufferedImage modifiedImage;

    public ImageModifier(BufferedImage img) {
        this.img = img;
        modifiedImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
    }

    public Kernel getKernel() {
        return kernel;
    }

    public void setKernel(Kernel kernel) {
        this.kernel = kernel;
    }

    public void modify(){

        SubImager subber = new SubImager(img);
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                var subbed = subber.getSub(x,y, kernel.getSize());
                modifiedImage.setRGB(x,y, kernel.kernelify(subbed).getRGB());


            }
        }
    }

    public WritableImage getModifierImage(){
        return SwingFXUtils.toFXImage(modifiedImage, null);
    }

}
