package integration;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class Transformer {

    public String transform(String filePath) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        content = Normalizer.normalize(content, Normalizer.Form.NFKD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        String result = pattern.matcher(content).replaceAll("").replace('đ','d').replace('Đ','D');
        return "Transformed: \n" + result.toUpperCase();
    }

    public String transformFromDB (Message<List<Map<String, String>>> result) throws IOException {
        String content = "";
        List<String> list = new ArrayList<>();
        List<Map<String, String>> test = result.getPayload();
        for(Map<String,String> entry : test){
            content = Normalizer.normalize(entry.get("name"), Normalizer.Form.NFKD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            list.add(pattern.matcher(content).replaceAll("").replace('đ','d').replace('Đ','D'));
        }
        return String.join("\n",list);
    }
}
