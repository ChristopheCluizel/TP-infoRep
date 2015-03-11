package HelloWorldSerializable;

import java.io.Serializable;

public class Guy implements Serializable {
   private String name;
   public Guy(String name) {
      this.name = name;
   }
   public String getName() {
      return this.name;
   }
}
