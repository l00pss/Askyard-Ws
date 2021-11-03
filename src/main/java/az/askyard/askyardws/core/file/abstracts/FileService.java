package az.askyard.askyardws.core.file.abstracts;



import java.io.IOException;


public interface FileService {
    String writeBase64Encoder(String image) throws IOException;
    String generateName();
}
