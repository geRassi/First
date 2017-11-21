package CSV;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @GetMapping(path = "/download")
    public ResponseEntity<ByteArrayResource> download() throws IOException {

        //File file = new File("C:\\Users\\Rami\\Desktop\\17710 New Hampshire- Profile Hebrew.pdf");
        //File file = new File("C:\\Users\\Rami\\Downloads\\7049D_APAC_AL_M_G50EN_V1.7_160630.rar");
        File file1 = new File("C:\\Users\\Rami\\Downloads\\ubuntu-16.04.3-desktop-amd64.iso");
        //       InputStreamReader i = new InputStreamReader(new FileInputStream(file));
        Path path = Paths.get(file1.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Content-Disposition", "attachment; filename=MyFileName.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file1.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }


    @GetMapping(value = "/download2")
    public ResponseEntity<InputStreamResource> downloadFile(HttpServletRequest request) throws IOException {

        //File file = new File("C:\\Users\\Rami\\Downloads\\7049D_APAC_AL_M_G50EN_V1.7_160630.rar");
        File file1 = new File("C:\\Users\\Rami\\Downloads\\ubuntu-16.04.3-desktop-amd64.iso");
        InputStream is = new FileInputStream(file1);
        InputStreamResource resource = new InputStreamResource(is);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Content-Disposition", "attachment; filename=MyFileName.pdf");

        return ResponseEntity.ok().headers(headers).body(resource);
    }
}