package eu.profinit.opendata.model;

import java.util.Collection;
import java.util.Objects;


/**
 * Represents an entity taking part in a transaction (a Record). Can be a public institution (ministry), company, an
 * individual contractor, or even just an employee.
 */


public class Entity {

    /** The tax identification number. Mostly unused. */
    private String dic;

    /** The taxpayer identification number. The primary attribute used to avoid duplicitous entities. */
    private String ico;

    /** Indicates that this institution is a public institution that publishes data, as opposed to an entity created
     * during processing.
     */
    private boolean isPublic;

    /** The normalized entity name. Some institutions only publish a partner's name and every effort is made to avoid
     * duplicitous entries, but this is a lot less reliable than the identification number.
     */
    private String name;

    /** The database primary key */
    private Long entityId;

    /** The nature of this entity. This attribute is not used correctly at the moment. */
    private EntityType entityType;

    /** DataSources that this Entity publishes. Only applicable if this Entity is public. */
    private Collection<DataSource> dataSources;

    /** Records where this Entity is the publishing authority. */
    private Collection<Record> recordsAsAuthority;

    /** Records where this Entity is the partner. */
    private Collection<Record> recordsAsPartner;

    public String getDic() {
        return dic;
    }

    public void setDic(String dic) {
        this.dic = dic;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public void setEntityType(EntityType entityType) {
        this.entityType = entityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entity entity = (Entity) o;

        if (!Objects.equals(entityId, entity.entityId)) return false;
        if (isPublic != entity.isPublic) return false;
        if (dic != null ? !dic.equals(entity.dic) : entity.dic != null) return false;
        if (entityType != null ? !entityType.equals(entity.entityType) : entity.entityType != null) return false;
        if (ico != null ? !ico.equals(entity.ico) : entity.ico != null) return false;
        if (name != null ? !name.equals(entity.name) : entity.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = dic != null ? dic.hashCode() : 0;
        result = 31 * result + (ico != null ? ico.hashCode() : 0);
        result = 31 * result + (isPublic ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + entityId.intValue();
        result = 31 * result + (entityType != null ? entityType.hashCode() : 0);
        return result;
    }

    public Collection<DataSource> getDataSources() {
        return dataSources;
    }

    public void setDataSources(Collection<DataSource> dataSources) {
        this.dataSources = dataSources;
    }

    public Collection<Record> getRecordsAsAuthority() {
        return recordsAsAuthority;
    }

    public void setRecordsAsAuthority(Collection<Record> recordsAsAuthority) {
        this.recordsAsAuthority = recordsAsAuthority;
    }

    public Collection<Record> getRecordsAsPartner() {
        return recordsAsPartner;
    }

    public void setRecordsAsPartner(Collection<Record> recordsAsPartner) {
        this.recordsAsPartner = recordsAsPartner;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "dic='" + dic + '\'' +
                ", ico='" + ico + '\'' +
                ", isPublic=" + isPublic +
                ", name='" + name + '\'' +
                ", entityId=" + entityId +
                ", entityType=" + entityType +
                ", dataSources=" + dataSources +
                '}';
    }
}
