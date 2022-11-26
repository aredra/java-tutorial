package di;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class UrlEncoder implements IEncoder {

    @Override
    public String encode(String message) {
        return URLEncoder.encode(message, StandardCharsets.UTF_8);
    }
}
