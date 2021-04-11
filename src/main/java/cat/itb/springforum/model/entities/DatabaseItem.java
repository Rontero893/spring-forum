package cat.itb.springforum.model.entities;

import cat.itb.springforum.utilities.Utilities;
import lombok.Getter;

@Getter
public class DatabaseItem
{
    private final String id = Utilities.generateCode(8);
}
