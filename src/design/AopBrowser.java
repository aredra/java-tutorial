package design;

import design.proxy.Html2;
import design.proxy.IBrowser;

public class AopBrowser implements IBrowser {

    private String url;
    private Html2 html;
    private Runnable before;
    private Runnable after;

    public AopBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html2 show() {
        before.run();

        if (html == null) {
            this.html = new Html2(url);
            System.out.println("AopBrowser loading html from : " + url);

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            after.run();
            return html;
        }

        System.out.println("AopBrowser use cache html : " + url);

        after.run();
        return html;
    }
}
