package cigma.pfe;

import cigma.pfe.models.Facture;
import cigma.pfe.presentation.ClientController;
import cigma.pfe.models.Client;
import cigma.pfe.presentation.FactureController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class MonApplication {
    public static void main(String[] args) {
        // ClientController ctrl1 = new ClientController();
        // Client client =new Client(1L,"testing");
        // ctrl1.save(client);

        // Au cas ou le scope = singleton
        // ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Au cas ou le scope = prototype
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        ClientController ctrl = (ClientController) context.getBean("controller");
      
        // Test save use case for three clients
        ctrl.save(new Client("OMAR"));
        ctrl.save(new Client("SIHAM"));
        ctrl.save(new Client("AHMED"));
        ctrl.save(new Client("FARAH"));

        // Test modify use case for client with id==1
        ctrl.modify(new Client("new Name"));

        // Test remove use case for client with id==1
        ctrl.removeById(1L);

        // Test find use case for client with id==1
        Client found = ctrl.getById(1L);

        // Test get all clients
        List<Client> clientList = ctrl.getAll();

        // ================= Second Part [ Facture Test ] =================
        FactureController ctrlF = (FactureController) context.getBean("controllerFacture");

        // Test save use case for two factures
        ctrlF.save(new Facture(new Date(System.currentTimeMillis()), 1450.00));
        ctrlF.save(new Facture(new Date(2020, 04,17), 500.00));

        // Test modify use case for facture with id==1
        ctrlF.modify(new Facture(new Date(System.currentTimeMillis()),1780.00));

        // Test remove use case for facture with id==1
        ctrlF.removeById(1L);

        // Test find use case for facture with id==1
        Facture foundF = ctrlF.getById(1L);

        // Test get all factures
        List<Facture> factureList = ctrlF.getAll();

    }
}
