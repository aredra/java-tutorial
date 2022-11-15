package design.proxy;

public class BrowserProxy implements IBrowser {

    private String url;
    private Html2 html;

    public BrowserProxy(String url) {
        this.url = url;
    }

    @Override
    public Html2 show() {
        if (html == null) {
            this.html = new Html2(url);
            System.out.println("BrowserProxy loading html from : " + url);
            return html;
        }

        System.out.println("BrowserProxy use cache html : " + url);
        return html;
    }
}
