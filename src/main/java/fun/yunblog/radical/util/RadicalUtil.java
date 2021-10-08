package fun.yunblog.radical.util;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author 耿子云
 * @date 2021/9/27
 */
public class RadicalUtil {
    public void TextToFile(final String strFileName, final String strBuffer) {
        try {
            File fileText = new File(strFileName);
            FileWriter fileWriter = new FileWriter(fileText);
            fileWriter.write(strBuffer);
            fileWriter.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * 获取缩略图并转为byte[]
     * */
//    https://blog.csdn.net/qq_34839150/article/details/109903432
    public static byte[] getNarrowFile(MultipartFile file) {
        try {
            //获取图片缩略图
            Thumbnails.Builder<? extends InputStream> builder = Thumbnails.of(file.getInputStream()).size(160, 160);
            //转为byte
            BufferedImage bufferedImage = builder.asBufferedImage();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, "png", baos);
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
