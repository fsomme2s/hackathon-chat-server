package de.conet.hack.realtime.chat.server.entities._common.util;

import de.conet.hack.realtime.chat.server._common.logging.MyLoggerFactory;
import de.conet.hack.realtime.chat.server.entities._common.PersistableEnum;
import org.slf4j.Logger;

import javax.persistence.AttributeConverter;

/**
 * Convertes between {@link PersistableEnum} and its database-representation.
 */
public abstract class PersistableEnumConverter<ENTITY_TYPE extends PersistableEnum<Db_TYPE>, Db_TYPE>
        implements AttributeConverter<ENTITY_TYPE, Db_TYPE> {

    protected abstract Class<ENTITY_TYPE> getEnumType();

    protected Logger logger = MyLoggerFactory.createLogger(getClass());

    @Override
    public Db_TYPE convertToDatabaseColumn(ENTITY_TYPE enumConstant) {
        return (enumConstant == null) ? null : enumConstant.getEnumId();
    }

    @Override
    public ENTITY_TYPE convertToEntityAttribute(Db_TYPE dbEnumId) {
        for (ENTITY_TYPE enumConst : getEnumType().getEnumConstants()){
            if (enumConst.getEnumId().equals(dbEnumId)) {
                return enumConst;
            }
        }

        throw new IllegalArgumentException(String.format(
                "Could not find Enum Constant of Type %s for database-enumId '%s'",
                getEnumType().getSimpleName(),
                dbEnumId.toString()
                ));
    }
}
