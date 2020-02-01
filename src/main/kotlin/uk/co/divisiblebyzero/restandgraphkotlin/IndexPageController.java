package uk.co.divisiblebyzero.restandgraphkotlin;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.Charset;

@RestController
public class IndexPageController {
    @RequestMapping("/")
    public String getIndex() {
        try {
            return IOUtils.toString(IndexPageController.class.getResourceAsStream("/index.html"), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("Error reading stream (bummer)");
            e.printStackTrace();
            throw new RuntimeException("Error reading stream", e);
        }
    }
}

