package cat.itb.servlettest.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ForumUser
{
    public static final String[] lastNames = {"Lopez", "Rodriguez", "Vera", "Romero", "Gutierrez", "Nunyes"};

    private int id;
    private String name, lastName, password;

    public ForumUser(String name)
    {
        id = (int) (Math.random() * 10 + 1);
        this.name = name;
        this.lastName = lastNames[(int)(Math.random() * lastNames.length)];
    }
}
