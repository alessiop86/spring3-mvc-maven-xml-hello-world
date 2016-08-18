package example;

import com.fasterxml.jackson.databind.ObjectMapper;
import initialisation.mess.components.Modello;
import org.springframework.core.convert.converter.Converter;

import java.io.IOException;

public final class UserConverter implements Converter<String, Modello[]> {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public Modello[] convert(String username) {
        try {
            return objectMapper.readValue(username,Modello[].class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}