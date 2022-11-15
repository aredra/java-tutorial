package design.proxy;

public class Browser implements IBrowser {

    private String url;

    public Browser(String url) {
        this.url = url;
    }

    @Override
    public Html2 show() {
        System.out.println("Loading ... " + this.url);
        return new Html2(url);
    }
}
