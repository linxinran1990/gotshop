package com.gotIt.gotshop.security.properties;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/22</pre>
 */
public class ImageCodeProperties extends SmsCodeProperties {

    public ImageCodeProperties() {
        setLength(4);
    }

    private int width = 67;

    private int heigth = 23;

    public int getWidth() {
        return width;
    }

    public int getHeigth() {
        return heigth;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }

}



