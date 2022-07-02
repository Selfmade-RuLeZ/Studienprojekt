package de.hsesslingen.StudienprojektKneisel.Serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import de.hsesslingen.StudienprojektKneisel.Entities.Manufacturer;
import de.hsesslingen.StudienprojektKneisel.Entities.Repair;

import java.io.IOException;
import java.util.Set;

public class RepairSetSerializer extends StdSerializer<Set<Repair>> {
    public RepairSetSerializer() {
        this(null);
    }

    public RepairSetSerializer(Class<Set<Repair>> t) {
        super(t);
    }

    @Override
    public void serialize(
            Set<Repair> repairs, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartArray();
        for (Repair repair :
                repairs) {
            jgen.writeStartObject();
            jgen.writeNumberField("id", repair.getId());
            jgen.writeNumberField("carId", repair.getCar().getId());
            jgen.writeNumberField("cost", repair.getCost());
            jgen.writeStringField("description", repair.getDescription());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
    }
}
