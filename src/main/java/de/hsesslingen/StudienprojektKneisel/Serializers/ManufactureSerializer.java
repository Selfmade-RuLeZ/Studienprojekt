package de.hsesslingen.StudienprojektKneisel.Serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import de.hsesslingen.StudienprojektKneisel.Entities.Manufacturer;

import java.io.IOException;

public class ManufactureSerializer extends StdSerializer<Manufacturer> {

        public ManufactureSerializer() {
            this(null);
        }

        public ManufactureSerializer(Class<Manufacturer> t) {
            super(t);
        }

        @Override
        public void serialize(
                Manufacturer manufacturer, JsonGenerator jgen, SerializerProvider provider)
                throws IOException, JsonProcessingException {

            jgen.writeStartObject();
            jgen.writeNumberField("id", manufacturer.getId());
            jgen.writeStringField("name", manufacturer.getName());
            jgen.writeStringField("origin", manufacturer.getOrigin());
            jgen.writeEndObject();
        }
}
