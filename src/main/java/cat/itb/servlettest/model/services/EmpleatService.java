package cat.itb.servlettest.model.services;

import cat.itb.servlettest.model.entities.Empleat;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleatService
{
    private final List<Empleat> repositori = new ArrayList<>();

    public void afegir(Empleat e)
    {
        e.setId(repositori.size() + 1);
        repositori.add(e);
    }

    public List<Empleat> llistat() { return repositori; }

    public List<Empleat> llistatOrdenatPerNom()
    {
        return repositori.stream().sorted(Comparator.comparing(Empleat::getNom)).collect(Collectors.toList());
    }

    public Empleat consultaPerId(int id)
    {
        for (Empleat empleat : repositori) { if(empleat.getId() == id) return empleat; }
        return null;
    }

    public void eliminarPerId(int id) { repositori.removeIf(empleat -> empleat.getId() == id); }

    public void substituir(Empleat e)
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

    @PostConstruct
    public void init()
    {
        repositori.addAll(
                Arrays.asList(
                        new Empleat(1, "Montse Madridejos", "montse@itb.cat", "677123456", true),
                        new Empleat(2, "Alberto Vila", "alberto@itb.cat", "699876543", false),
                        new Empleat(3, "Robert López", "robert@bbc.com", "123456789", true)
                ));
    }
}
