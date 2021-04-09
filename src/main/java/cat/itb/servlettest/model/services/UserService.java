package cat.itb.servlettest.model.services;

import cat.itb.servlettest.model.entities.ForumUser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService
{
    private final List<ForumUser> repositori = new ArrayList<>();

    public void afegir(ForumUser e)
    {
        e.setId(repositori.size() + 1);
        repositori.add(e);
    }

    public List<ForumUser> llistat() { return repositori; }

    public List<ForumUser> llistatOrdenatPerNom()
    {
        return repositori.stream().sorted(Comparator.comparing(ForumUser::getName)).collect(Collectors.toList());
    }

    public ForumUser consultaPerId(int id)
    {
        for (ForumUser empleat : repositori) { if(empleat.getId() == id) return empleat; }
        return null;
    }

    public void eliminarPerId(int id) { repositori.removeIf(empleat -> empleat.getId() == id); }

    public void substituir(ForumUser e)
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
