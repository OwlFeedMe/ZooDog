/*
 * Carlos Steven Portilla Botero
 * 1015473300
 * Ing. Sistemas y telecomunicaciones 
 *   * 
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Dogs")
@XmlAccessorType(XmlAccessType.FIELD)
public class Dogs {

    private String breed;
    private String description;
    private String pic;

    public Dogs(String breed, String description, String pic) {
        this.breed = breed;
    
        this.description = description;
        this.pic = pic;
    }

    public String getBreed() {
        return breed;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
