package cat.itb.servlettest.model.services;

import cat.itb.servlettest.model.entities.UserTest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService
{
    private final List<UserTest> repositori = new ArrayList<>();

    public void afegir(UserTest e)
    {
        e.setId(repositori.size() + 1);
        repositori.add(e);
    }

    public List<UserTest> llistat() { return repositori; }

    public List<UserTest> llistatOrdenatPerNom()
    {
        return repositori.stream().sorted(Comparator.comparing(UserTest::getName)).collect(Collectors.toList());
    }

    public UserTest consultaPerId(int id)
    {
        for (UserTest empleat : repositori) { if(empleat.getId() == id) return empleat; }
        return null;
    }

    public void eliminarPerId(int id) { repositori.removeIf(empleat -> empleat.getId() == id); }

    public void substituir(UserTest e)
    {
        int id = e.getId();
        for (int i = 0; i < repositori.size() ; i++)
        {
            if(repositori.get(i).getId() == id)
            {
                repositori.set(i, e);
                return;
            }
        }
    }
}
