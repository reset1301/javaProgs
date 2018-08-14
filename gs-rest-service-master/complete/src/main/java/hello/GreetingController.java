package hello;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "%s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/akd_api_ws/getcontent")
    public Greeting greeting(@RequestParam(value="docId", defaultValue="0903601992be5a71") String name) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("c:\\111\\2.a"));
        StringBuilder s = new StringBuilder();
        while (br.ready())
            s.append(br.readLine());
        br.close();

        return new Greeting(counter.incrementAndGet(),
                            String.format(template, s.toString()));
    }
}
