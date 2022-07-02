package de.hsesslingen.StudienprojektKneisel.Serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import de.hsesslingen.StudienprojektKneisel.Entities.RepairShop;

import java.io.IOException;
import java.util.Set;

public class RepairShopSetSerializer extends StdSerializer<Set<RepairShop>> {
    public RepairShopSetSerializer() {
        this(null);
    }

    public RepairShopSetSerializer(Class<Set<RepairShop>> t) {
        super(t);
    }

    @Override
    public void serialize(
            Set<RepairShop> repairShops, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        jgen.writeStartArray();
        for (RepairShop repairShop:
             repairShops) {
            jgen.writeStartObject();
            jgen.writeNumberField("id", repairShop.getId());
            jgen.writeStringField("name", repairShop.getName());
            jgen.writeStringField("street", repairShop.getStreet());
            jgen.writeNumberField("houseNumber", repairShop.getHouseNumber());
            jgen.writeNumberField("postalCode", repairShop.getPostalCode());
            jgen.writeStringField("city", repairShop.getCity());
            jgen.writeEndObject();
        }
        jgen.writeEndArray();
    }
}
