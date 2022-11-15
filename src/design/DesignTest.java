package design;

import design.adapter.*;
import design.decorator.*;
import design.facade.Ftp;
import design.facade.Reader;
import design.facade.SftpClient;
import design.facade.Writer;
import design.observer.Button;
import design.observer.IButtonListener;
import design.proxy.Browser;
import design.proxy.BrowserProxy;
import design.proxy.IBrowser;
import design.singleton.AClazz;
import design.singleton.BClazz;
import design.singleton.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

public class DesignTest {
    public static void main(String[] args) {

        AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println(aClient.equals(bClient));

        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V adapter2 = new SocketAdapter(airConditioner);
        connect(adapter2);

        Browser browser = new Browser("text.com");
        browser.show();
        browser.show();
        browser.show();

        IBrowser browser1 = new BrowserProxy("text.com");
        browser1.show();
        browser1.show();
        browser1.show();
        browser1.show();

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("text.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                });

        aopBrowser.show();
        System.out.println("Loading time : " + end.get());
        aopBrowser.show();
        System.out.println("Loading time : " + end.get());


        ICar audi = new Audi(1000);
        audi.showPrice();

        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();
        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();
        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();

        Button button = new Button("버튼");
        button.addListener(System.out::println);

        button.click("Click 1");
        button.click("Click 2");
        button.click("Click 3");

        SftpClient sftpClient = new SftpClient("text.com", 22, "/home/etc", "text.txt");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
    }

    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
