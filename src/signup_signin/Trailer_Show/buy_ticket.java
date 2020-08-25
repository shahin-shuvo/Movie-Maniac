
package signup_signin.Trailer_Show;




import chrriis.common.UIUtils;
import chrriis.dj.nativeswing.swtimpl.NativeInterface;
import chrriis.dj.nativeswing.swtimpl.components.JWebBrowser;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


public class buy_ticket {
    public static void main(String[] args,String url) {
        String link = url;
        NativeInterface.open();
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame frame = new JFrame("Star Cineplex");
            
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
           
            frame.getContentPane().add(getBrowser(link), BorderLayout.CENTER);
            frame.setSize(925, 610);
          
            
            frame.setLocationByPlatform(true);
            frame.setVisible(true);
            
            frame.setLocationRelativeTo(null);
        }
    });
        NativeInterface.runEventPump();
         Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
            NativeInterface.close();
        }
    }));
    }
    
    public static JPanel getBrowser(String link)
    {
         JPanel p = new JPanel(new BorderLayout());
         JWebBrowser wb = new JWebBrowser();
         p.add(wb,BorderLayout.CENTER);
         wb.setBarsVisible(false);
         wb.navigate(link);
         return p;
    }
}


