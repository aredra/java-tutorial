package di;

public class DiTest {
    public static void main(String[] args) {
        String url = "test.com/api/user/1";

        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);
    }
}
