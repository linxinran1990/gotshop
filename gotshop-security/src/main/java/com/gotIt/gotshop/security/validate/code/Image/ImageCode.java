package com.gotIt.gotshop.security.validate.code.Image;

import com.gotIt.gotshop.security.validate.code.ValidateCode;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author linxr
 * @version 1.0
 * @since <pre>2019/3/10</pre>
 */
public class ImageCode extends ValidateCode {

    private BufferedImage image;

    private Boolean isExpried;

    public ImageCode(BufferedImage image, String code, int expireIn){
        super(code, expireIn);
        this.image = image;
    }

    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public Boolean getExpried() {
        return isExpried;
    }

    public void setExpried(Boolean expried) {
        isExpried = expried;
    }
}



