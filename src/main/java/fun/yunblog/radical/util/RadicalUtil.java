package fun.yunblog.radical.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
}
