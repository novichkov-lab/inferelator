
package us.kbase.workspaceservice;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import us.kbase.common.service.Tuple11;


/**
 * <p>Original spec-file type: get_object_output</p>
 * <pre>
 * Output generated by the "get_object" function.
 *         string data - data for object retrieved in json format (an essential argument)
 *         object_metadata metadata - metadata for object retrieved (an essential argument)
 * </pre>
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "data",
    "metadata"
})
public class GetObjectOutput {

    @JsonProperty("data")
//    private java.lang.String data;
    private Object data; //without this fix, getObject function will not work
    @JsonProperty("metadata")
    private Tuple11 <String, String, String, Long, String, String, String, String, String, String, Map<String, String>> metadata;
    private Map<java.lang.String, Object> additionalProperties = new HashMap<java.lang.String, Object>();

/*	
    @JsonProperty("data")
    public java.lang.String getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(java.lang.String data) {
        this.data = data;
    }

    public GetObjectOutput withData(java.lang.String data) {
        this.data = data;
        return this;
    }
*/   

    // without this fix, getObject function will not work
    @JsonProperty("data")
    public Object getData() {
        return data;
    }
    
    @JsonProperty("data")
    public void setData(Object data) {
        this.data = data;
    }

    public GetObjectOutput withData(Object data) {
        this.data = data;
        return this;
    }

    @JsonProperty("metadata")
    public Tuple11 <String, String, String, Long, String, String, String, String, String, String, Map<String, String>> getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Tuple11 <String, String, String, Long, String, String, String, String, String, String, Map<String, String>> metadata) {
        this.metadata = metadata;
    }

    public GetObjectOutput withMetadata(Tuple11 <String, String, String, Long, String, String, String, String, String, String, Map<String, String>> metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonAnyGetter
    public Map<java.lang.String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(java.lang.String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public java.lang.String toString() {
        return ((((((("GetObjectOutput"+" [data=")+ data)+", metadata=")+ metadata)+", additionalProperties=")+ additionalProperties)+"]");
    }

}
