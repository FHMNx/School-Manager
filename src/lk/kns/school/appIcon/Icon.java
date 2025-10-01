package lk.kns.school.appIcon;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Icon {

    private static Image appIcon;

    static {
        try {
            try {
                URL iconPath = Icon.class.getResource("/lk/kns/school/image/knslogo.png");
                ImageIcon icon = new ImageIcon(iconPath);
                Icon.appIcon = icon.getImage();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
        }
    }

    public static void applyIcon(JFrame frame) {
        if (frame != null) {
            frame.setIconImage(appIcon);
        }
    }

}
