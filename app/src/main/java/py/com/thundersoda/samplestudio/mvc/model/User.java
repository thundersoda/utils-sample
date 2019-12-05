package py.com.thundersoda.samplestudio.mvc.model;

import java.util.List;

public class User {
    private String id;
    private String name;
    private String description;
    private List<Site> sites;
    private Address address;

    public User(String id, String name, String description, List<Site> sites, Address address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sites = sites;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Address getAddress() {
        return address;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}
