package entity;

import java.util.Date;
import java.util.Objects;

public class Item {
      /**
       * 
       */
      public Item() {
      }
      private Integer id;
      private String name;
      private int available;
      private String description;
      private Date created_at;
      /**
       * @return the created_at
       */
      public Date getCreated_at() {
            return created_at;
      }
      /**
       * @param created_at the created_at to set
       */
      public void setCreated_at(Date created_at) {
            this.created_at = created_at;
      }
      /**
       * @param id
       * @param name
       * @param available
       * @param description
       */
      public Item(Integer id, String name, int available, String description,Date created_at) {
            this.id = id;
            this.name = name;
            this.available = available;
            this.description = description;
            this.created_at= created_at;
      }
      /**
       * @return the id
       */
      public Integer getId() {
            return id;
      }
      /**
       * @param id the id to set
       */
      public void setId(Integer id) {
            this.id = id;
      }
      /**
       * @return the name
       */
      public String getName() {
            return name;
      }
      /**
       * @param name the name to set
       */
      public void setName(String name) {
            this.name = name;
      }
      /**
       * @return the available
       */
      public int getAvailable() {
            return available;
      }
      /**
       * @param available the available to set
       */
      public void setAvailable(int available) {
            this.available = available;
      }
      /**
       * @return the description
       */
      public String getDescription() {            
            return description;
      }
      /**
       * @param description the description to set
       */
      public void setDescription(String description) {
            this.description = description;
      }
     
      @Override
      public String toString() {           
            return "id :"+id+" name :"+name+" available :"+available+
                   " description :"+description+" created_at :"+created_at+";";
      }
      @Override
      public int hashCode() {
            return Objects.hash(id, name, available, description, created_at);
      }
      @Override
      public boolean equals(Object obj) {
            if (this == obj)
                  return true;
            if (!(obj instanceof Item))
                  return false;
            Item other = (Item) obj;
            return Objects.equals(id, other.id) && Objects.equals(name, other.name) && available == other.available
                        && Objects.equals(description, other.description)
                        && Objects.equals(created_at, other.created_at);
      }

}
