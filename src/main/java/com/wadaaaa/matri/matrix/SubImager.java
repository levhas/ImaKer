package com.wadaaaa.matri.matrix;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubImager {
    BufferedImage img;
    private int lup, up ,rup;

    public SubImager(BufferedImage img) {
        this.img = img;
    }

    private int lmid, mid, rmid;
    private int ldown, down, rdown;


    public int[] getSub(int x, int y, int size){

        List<Integer> colors = new ArrayList<>();
        for(int iy = y-(size/2); iy <= (y + (size/2)); iy++){
            for(int ix = x-(size/2); ix <= (x + (size/2)); ix++){
                var cx = Math.min(Math.max(0,ix), img.getWidth() - 1);
                var cy = Math.min(Math.max(0,iy), img.getHeight() - 1);
                try {
                    colors.add(img.getRGB(cx, cy));
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(cx + " " + cy);
                }
            }
        }
        int[] returnArr = colors.stream().mapToInt(i->i).toArray();
        return returnArr;



    }

}
