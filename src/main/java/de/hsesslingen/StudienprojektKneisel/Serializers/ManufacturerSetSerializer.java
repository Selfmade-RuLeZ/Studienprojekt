package de.hsesslingen.StudienprojektKneisel.Serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import de.hsesslingen.StudienprojektKneisel.Entities.Manufacturer;

import java.io.IOException;
import java.util.Set;

public class ManufacturerSetSerializer  extends StdSerializer<Set<Manufacturer>> {
    public ManufacturerSetSerializer() {
        this(null);
    }

    public ManufacturerSetSerializer(Class<Set<Manufacturer>> t) {
        super(t);
    }

    @Override
    public void serialize(
            Set<Manufacturer> manufacturers, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartArray();
        for (Manufacturer manufacturer :
                manufacturers) {
            jgen.writeStartObject();
            jgen.writeNumberField("id", manufacturer.getId());
            jgen.writeStringField("name", manufacturer.getName());
            jgen.writeStringField("origin", manufacturer.getOrigin());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
    }
}
