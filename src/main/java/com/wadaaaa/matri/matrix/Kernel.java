package com.wadaaaa.matri.matrix;

import java.awt.Color;

public class Kernel {
    private float[] kernel;
    private float[] origKernel;
    private int size;
    public float normal;
    public boolean normalized;

    public Kernel(float[] kernel) {
        this.kernel = kernel;
        this.size = (int) Math.sqrt(kernel.length);

        origKernel = kernel.clone();
        normal = normal > 0 ? normal : 1;
        boolean normalized = true;
        if(normalized){
            for(int g = 0; g< kernel.length; g++){
                kernel[g] = kernel[g] / normal;
            }
        }
    }

    public void setValues(float[] newKernelValues){
        this.kernel = newKernelValues;
        origKernel = kernel.clone();
    }

    public void setNormalization(boolean bool){
        normalized = bool;



    }
    public void normalize(){

        normal = 0;
        for (var num:kernel) {
            normal += num;
        }
        normal = normal > 0 ? normal : 1;
        for(int g = 0; g< kernel.length; g++){
           kernel[g] = kernel[g] / normal;
        }

    }
    public Color kernelify(int[] partOfImage){

        int red = 0;
        int blue = 0;
        int green = 0;
        if(normalized){
            normalize();
        }else {
            kernel = origKernel.clone();
        }

        for(int i = 0; i < partOfImage.length; i++){

            int R = ((int)partOfImage[i] >> 16) & 0xff; // Red Value
            int G = ((int)partOfImage[i] >> 8) & 0xff;	// Green Value
            int B = ((int)partOfImage[i]) & 0xff;		// Blue Value


            red += R * kernel[i];
            green += G  * kernel[i];
            blue += B * kernel[i];

        }

        red = (int) (red);
        green = (int) (green );
        blue = (int) (blue);
        red = Math.max(0, red);
        blue = Math.max(0, blue);
        green = Math.max(0, green);
        red = Math.min(255, red);
        blue = Math.min(255, blue);
        green = Math.min(255, green);

        try {
            Color result = new Color((int)(red), (int)(green), (int)(blue));
            return result;
        } catch (IllegalArgumentException e){
            return Color.BLACK;
        }



    }
}
