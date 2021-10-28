package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateGithubRepoResponsePOJO {

	public int id;
    public String node_id;
    public String name;
    public String full_name;
    
    @JsonProperty(value="private")
    public boolean privateVal;
    
    public String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNode_id() {
		return node_id;
	}

	public void setNode_id(String node_id) {
		this.node_id = node_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public boolean isPrivateVal() {
		return privateVal;
	}

	public void setPrivateVal(boolean privateVal) {
		this.privateVal = privateVal;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    
}
