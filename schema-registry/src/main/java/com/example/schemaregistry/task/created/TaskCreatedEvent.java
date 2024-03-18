/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.schemaregistry.task.created;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class TaskCreatedEvent extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 2741104762296421124L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TaskCreatedEvent\",\"namespace\":\"com.example.schemaregistry.task.created\",\"fields\":[{\"name\":\"eventName\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"eventPayload\",\"type\":{\"type\":\"record\",\"name\":\"TaskCreatedPayload\",\"fields\":[{\"name\":\"publicId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"executorId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"creatorId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"description\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}}],\"version\":\"1\"}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TaskCreatedEvent> ENCODER =
      new BinaryMessageEncoder<TaskCreatedEvent>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TaskCreatedEvent> DECODER =
      new BinaryMessageDecoder<TaskCreatedEvent>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TaskCreatedEvent> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TaskCreatedEvent> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TaskCreatedEvent> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TaskCreatedEvent>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TaskCreatedEvent to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TaskCreatedEvent from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TaskCreatedEvent instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TaskCreatedEvent fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String eventName;
  @Deprecated public com.example.schemaregistry.task.created.TaskCreatedPayload eventPayload;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TaskCreatedEvent() {}

  /**
   * All-args constructor.
   * @param eventName The new value for eventName
   * @param eventPayload The new value for eventPayload
   */
  public TaskCreatedEvent(java.lang.String eventName, com.example.schemaregistry.task.created.TaskCreatedPayload eventPayload) {
    this.eventName = eventName;
    this.eventPayload = eventPayload;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return eventName;
    case 1: return eventPayload;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: eventName = value$ != null ? value$.toString() : null; break;
    case 1: eventPayload = (com.example.schemaregistry.task.created.TaskCreatedPayload)value$; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'eventName' field.
   * @return The value of the 'eventName' field.
   */
  public java.lang.String getEventName() {
    return eventName;
  }


  /**
   * Sets the value of the 'eventName' field.
   * @param value the value to set.
   */
  public void setEventName(java.lang.String value) {
    this.eventName = value;
  }

  /**
   * Gets the value of the 'eventPayload' field.
   * @return The value of the 'eventPayload' field.
   */
  public com.example.schemaregistry.task.created.TaskCreatedPayload getEventPayload() {
    return eventPayload;
  }


  /**
   * Sets the value of the 'eventPayload' field.
   * @param value the value to set.
   */
  public void setEventPayload(com.example.schemaregistry.task.created.TaskCreatedPayload value) {
    this.eventPayload = value;
  }

  /**
   * Creates a new TaskCreatedEvent RecordBuilder.
   * @return A new TaskCreatedEvent RecordBuilder
   */
  public static com.example.schemaregistry.task.created.TaskCreatedEvent.Builder newBuilder() {
    return new com.example.schemaregistry.task.created.TaskCreatedEvent.Builder();
  }

  /**
   * Creates a new TaskCreatedEvent RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TaskCreatedEvent RecordBuilder
   */
  public static com.example.schemaregistry.task.created.TaskCreatedEvent.Builder newBuilder(com.example.schemaregistry.task.created.TaskCreatedEvent.Builder other) {
    if (other == null) {
      return new com.example.schemaregistry.task.created.TaskCreatedEvent.Builder();
    } else {
      return new com.example.schemaregistry.task.created.TaskCreatedEvent.Builder(other);
    }
  }

  /**
   * Creates a new TaskCreatedEvent RecordBuilder by copying an existing TaskCreatedEvent instance.
   * @param other The existing instance to copy.
   * @return A new TaskCreatedEvent RecordBuilder
   */
  public static com.example.schemaregistry.task.created.TaskCreatedEvent.Builder newBuilder(com.example.schemaregistry.task.created.TaskCreatedEvent other) {
    if (other == null) {
      return new com.example.schemaregistry.task.created.TaskCreatedEvent.Builder();
    } else {
      return new com.example.schemaregistry.task.created.TaskCreatedEvent.Builder(other);
    }
  }

  /**
   * RecordBuilder for TaskCreatedEvent instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TaskCreatedEvent>
    implements org.apache.avro.data.RecordBuilder<TaskCreatedEvent> {

    private java.lang.String eventName;
    private com.example.schemaregistry.task.created.TaskCreatedPayload eventPayload;
    private com.example.schemaregistry.task.created.TaskCreatedPayload.Builder eventPayloadBuilder;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.schemaregistry.task.created.TaskCreatedEvent.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.eventName)) {
        this.eventName = data().deepCopy(fields()[0].schema(), other.eventName);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.eventPayload)) {
        this.eventPayload = data().deepCopy(fields()[1].schema(), other.eventPayload);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (other.hasEventPayloadBuilder()) {
        this.eventPayloadBuilder = com.example.schemaregistry.task.created.TaskCreatedPayload.newBuilder(other.getEventPayloadBuilder());
      }
    }

    /**
     * Creates a Builder by copying an existing TaskCreatedEvent instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.schemaregistry.task.created.TaskCreatedEvent other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.eventName)) {
        this.eventName = data().deepCopy(fields()[0].schema(), other.eventName);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.eventPayload)) {
        this.eventPayload = data().deepCopy(fields()[1].schema(), other.eventPayload);
        fieldSetFlags()[1] = true;
      }
      this.eventPayloadBuilder = null;
    }

    /**
      * Gets the value of the 'eventName' field.
      * @return The value.
      */
    public java.lang.String getEventName() {
      return eventName;
    }


    /**
      * Sets the value of the 'eventName' field.
      * @param value The value of 'eventName'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedEvent.Builder setEventName(java.lang.String value) {
      validate(fields()[0], value);
      this.eventName = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'eventName' field has been set.
      * @return True if the 'eventName' field has been set, false otherwise.
      */
    public boolean hasEventName() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'eventName' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedEvent.Builder clearEventName() {
      eventName = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'eventPayload' field.
      * @return The value.
      */
    public com.example.schemaregistry.task.created.TaskCreatedPayload getEventPayload() {
      return eventPayload;
    }


    /**
      * Sets the value of the 'eventPayload' field.
      * @param value The value of 'eventPayload'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedEvent.Builder setEventPayload(com.example.schemaregistry.task.created.TaskCreatedPayload value) {
      validate(fields()[1], value);
      this.eventPayloadBuilder = null;
      this.eventPayload = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'eventPayload' field has been set.
      * @return True if the 'eventPayload' field has been set, false otherwise.
      */
    public boolean hasEventPayload() {
      return fieldSetFlags()[1];
    }

    /**
     * Gets the Builder instance for the 'eventPayload' field and creates one if it doesn't exist yet.
     * @return This builder.
     */
    public com.example.schemaregistry.task.created.TaskCreatedPayload.Builder getEventPayloadBuilder() {
      if (eventPayloadBuilder == null) {
        if (hasEventPayload()) {
          setEventPayloadBuilder(com.example.schemaregistry.task.created.TaskCreatedPayload.newBuilder(eventPayload));
        } else {
          setEventPayloadBuilder(com.example.schemaregistry.task.created.TaskCreatedPayload.newBuilder());
        }
      }
      return eventPayloadBuilder;
    }

    /**
     * Sets the Builder instance for the 'eventPayload' field
     * @param value The builder instance that must be set.
     * @return This builder.
     */

    public com.example.schemaregistry.task.created.TaskCreatedEvent.Builder setEventPayloadBuilder(com.example.schemaregistry.task.created.TaskCreatedPayload.Builder value) {
      clearEventPayload();
      eventPayloadBuilder = value;
      return this;
    }

    /**
     * Checks whether the 'eventPayload' field has an active Builder instance
     * @return True if the 'eventPayload' field has an active Builder instance
     */
    public boolean hasEventPayloadBuilder() {
      return eventPayloadBuilder != null;
    }

    /**
      * Clears the value of the 'eventPayload' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedEvent.Builder clearEventPayload() {
      eventPayload = null;
      eventPayloadBuilder = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TaskCreatedEvent build() {
      try {
        TaskCreatedEvent record = new TaskCreatedEvent();
        record.eventName = fieldSetFlags()[0] ? this.eventName : (java.lang.String) defaultValue(fields()[0]);
        if (eventPayloadBuilder != null) {
          try {
            record.eventPayload = this.eventPayloadBuilder.build();
          } catch (org.apache.avro.AvroMissingFieldException e) {
            e.addParentField(record.getSchema().getField("eventPayload"));
            throw e;
          }
        } else {
          record.eventPayload = fieldSetFlags()[1] ? this.eventPayload : (com.example.schemaregistry.task.created.TaskCreatedPayload) defaultValue(fields()[1]);
        }
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TaskCreatedEvent>
    WRITER$ = (org.apache.avro.io.DatumWriter<TaskCreatedEvent>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TaskCreatedEvent>
    READER$ = (org.apache.avro.io.DatumReader<TaskCreatedEvent>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.eventName);

    this.eventPayload.customEncode(out);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.eventName = in.readString();

      if (this.eventPayload == null) {
        this.eventPayload = new com.example.schemaregistry.task.created.TaskCreatedPayload();
      }
      this.eventPayload.customDecode(in);

    } else {
      for (int i = 0; i < 2; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.eventName = in.readString();
          break;

        case 1:
          if (this.eventPayload == null) {
            this.eventPayload = new com.example.schemaregistry.task.created.TaskCreatedPayload();
          }
          this.eventPayload.customDecode(in);
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










