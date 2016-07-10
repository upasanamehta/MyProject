package expedia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.stereotype.Component;

@Component

public class XMLHttpMessageConverter extends Jaxb2RootElementHttpMessageConverter {

    public XMLHttpMessageConverter() {
        List<MediaType> supportedMediaTypes = new ArrayList<>();
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        setSupportedMediaTypes(supportedMediaTypes);
    }

}
