package cat.itb.servlettest.model.entities;

import cat.itb.servlettest.utilities.Utilities;

public class DatabaseItem
{
    private final String id = Utilities.generateCode(8);

    public String getId() { return id; }
}
