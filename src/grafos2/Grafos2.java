    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos2;

import com.vista.UI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Joaquin R. Martinez
 */
public class Grafos2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            UI ui = new UI();
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            SwingUtilities.updateComponentTreeUI(ui);
            ui.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(Grafos2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
