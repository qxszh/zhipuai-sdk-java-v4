package com.zhipu.oapi.service.v4.realtime.object;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.util.Objects;

@Getter
@Setter
@JsonSerialize(using = ConfigIntOrInf.ConfigIntOrInfSerializer.class)
@JsonDeserialize(using = ConfigIntOrInf.ConfigIntOrInfDeserializer.class)
public class ConfigIntOrInf {
    private final Integer value;
    private final Boolean isInf;

    private ConfigIntOrInf(Integer value, Boolean isInf) {
        this.value = value;
        this.isInf = isInf;
    }

    public static ConfigIntOrInf inf() {
        return new ConfigIntOrInf(null, true);
    }

    public static ConfigIntOrInf of(int value) throws IllegalArgumentException {
        // 256K = 256 * 1024 = 262,144
        if (value < 1 || value > 262_144) {
            return new ConfigIntOrInf(null, true);
        }
        return new ConfigIntOrInf(value, false);
    }

    @Override
    public String toString() {
        return isInf ? "inf" : value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConfigIntOrInf that = (ConfigIntOrInf) o;
        return isInf == that.isInf && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isInf);
    }

    public static class ConfigIntOrInfSerializer extends JsonSerializer<ConfigIntOrInf> {
        @Override
        public void serialize(ConfigIntOrInf value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            if (value.isInf != null && value.getIsInf()) {
                gen.writeString("inf");
            } else {
                gen.writeNumber(value.getValue());
            }
        }
    }

    public static class ConfigIntOrInfDeserializer extends JsonDeserializer<ConfigIntOrInf> {
        @Override
        public ConfigIntOrInf deserialize(JsonParser p, DeserializationContext context) throws IOException {
            String text = p.getText();
            if (text == null) {
                return null;
            }
            if ("inf".equalsIgnoreCase(text)) {
                return ConfigIntOrInf.inf();
            } else {
                try {
                    int intValue = Integer.parseInt(text);
                    return ConfigIntOrInf.of(intValue);
                } catch (NumberFormatException e) {
                    return ConfigIntOrInf.inf();
                }
            }
        }
    }
}