package az.askyard.askyardws.core.file.concretes;

import az.askyard.askyardws.core.file.abstracts.FileService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Base64;
import java.util.UUID;


@Service
@Scope(scopeName = "prototype")
public class FileManager implements FileService {

    @Override
    public String writeBase64Encoder(String image) throws IOException {
        String fileName = generateName();
        File target = new File("src/main/java/com/holy/ws/storage" + fileName);
        OutputStream outputStream = new FileOutputStream(target);
        byte[] bytes = Base64.getDecoder().decode(image);
        outputStream.write(bytes);
        outputStream.close();
        return fileName;
    }

    @Override
    public String generateName() {
        return UUID.randomUUID().toString().replaceAll("-","")+".png";
    }


}
