

import com.mycompany.inventario.Entity.Stock;
import com.mycompany.inventario.Entity.User;
import com.mycompany.inventario.dao.StockRepository;
import com.mycompany.inventario.dao.UserRepository;
import com.mycompany.inventario.userInteraface.LoginFrame;

/**
 *
 * @author wuser
 */
public class Main {
    public static void main(String[] args){
        UserRepository userRepository = new UserRepository();
        StockRepository stockRepository = new StockRepository();
        User admin = new User();
        if(userRepository.findAll()!=null && userRepository.findAll().size()<=0){
            admin.setUsername("admin");
            admin.setPassword("admin");
            admin.setIsAdmin(true);
            userRepository.create(admin);
        }
        if(stockRepository.findAll()!=null && stockRepository.findAll().size()<=0){
            Stock stock = new Stock();
            stock.setDescripcion("Principal");
            stockRepository.create(stock);
        }
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);

    }
}
