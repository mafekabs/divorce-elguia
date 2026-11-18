package za.co.mafeka.divorceelguia.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
class EncryptedStringConverter implements AttributeConverter<String, String> {
    // TODO: Inject AES service - use Spring @Component + @Autowired
    // For now, placeholder - implement with AES/GCM using key from application.properties: app.encryption.key
    @Override
    public String convertToDatabaseColumn(String attribute) {
        if (attribute == null) return null;
        return attribute; // REPLACE with encrypt(attribute)
    }
    @Override
    public String convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;
        return dbData; // REPLACE with decrypt(dbData)
    }
}
