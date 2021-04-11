package cat.itb.springforum.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Specs
{
    private String OS, RAM, GPU, CPU;
}
