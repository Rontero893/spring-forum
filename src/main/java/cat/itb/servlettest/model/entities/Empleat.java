package cat.itb.servlettest.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleat
{
   private int id;
   private String nom;
   private String email;
   private String telefon;
   private boolean esDirectiu;
}
