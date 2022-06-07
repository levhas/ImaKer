package com.wadaaaa.matri.matrix;

import java.awt.image.BufferedImage;

public class SubImager {
    BufferedImage img;
    private int lup, up ,rup;

    public SubImager(BufferedImage img) {
        this.img = img;
    }

    private int lmid, mid, rmid;
    private int ldown, down, rdown;


    public int[] getSub(int x, int y){
        lup = (x == 0 || y == 0) ? img.getRGB( x, y): img.getRGB(x - 1, y - 1);
        up = y == 0 ? img.getRGB(x, y) : img.getRGB(x, y - 1);
        rup = y == 0 || x == img.getWidth() - 1 ? img.getRGB(x, y) : img.getRGB(x + 1, y - 1);

        lmid = x == 0 ? img.getRGB(x, y)  : img.getRGB(x - 1, y);
        mid = img.getRGB(x, y);
        rmid = x == img.getWidth() -1 ? img.getRGB(x, y) : img.getRGB(x + 1, y);

        ldown = y == img.getHeight() - 1 || x == 0  ? img.getRGB(x, y) : img.getRGB(x - 1, y + 1);
        down = y == img.getHeight() -1 ? img.getRGB(x, y) : img.getRGB(x, y + 1);
        rdown = y == img.getHeight() - 1 || x == img.getWidth() - 1 ? img.getRGB(x, y) : img.getRGB(x + 1, y + 1);
        return new int[]{lup,up,rup,
                        lmid,mid,rmid,
                        ldown,down,rdown};

    }

}
