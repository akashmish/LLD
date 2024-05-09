import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.phonepe.exceptions.IllegalConfigType;
import com.phonepe.exceptions.InvalidThresholdCountValue;
import com.phonepe.model.Client;
import com.phonepe.service.AlertService;

public class AlertServiceTest {
    private AlertService alertService;
    private Client clientX;
    private Client clientY;
    private Client clientTestExcep;


    @BeforeEach
    public void setup() throws Exception{
        this.alertService = new AlertService();
        this.clientX= new Client("X", "src/main/resources/clientjson/ClientX.json",alertService);
        this.clientY= new Client("Y", "src/main/resources/clientjson/ClientY.json",alertService);
        this.clientTestExcep = new Client("Test", "src/main/resources/clientjson/ClientExceptionTest.json",alertService);
    }

    @Test
    public void TestX(){
        Thread test_thread_X = new Thread(()->{
            for (int i = 0; i <580; i++) {
                System.out.println("camerhere");
                try {
                    clientX.executeEvent("PAYMENT_EXCEPTION");
                } catch (IllegalConfigType e) {
                    e.printStackTrace();
                }
                try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });
        test_thread_X.start();
    }

    @Test()
    public void TestY(){
        Thread test_thread_Y = new Thread(()->{
            for (int i = 0; i <580; i++) {
                System.out.println("camerhere");
                try {
                    clientY.executeEvent("PAYMENT_EXCEPTION");
                } catch (IllegalConfigType e) {
                    e.printStackTrace();
                }
                try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        });
        test_thread_Y.start();
    }

}
