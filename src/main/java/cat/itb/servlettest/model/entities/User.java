package cat.itb.servlettest.model.entities;

public class User
{
    public static final String[] lastNames = {"Lopez", "Rodriguez", "Vera", "Romero", "Gutierrez", "Nunyes"};
    private int id;
    private String name, lastName;

    public User(String name)
    {
        id = (int) (Math.random() * 10 + 1);
        this.name = name;
        this.lastName = lastNames[(int)(Math.random() * lastNames.length)];
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}
