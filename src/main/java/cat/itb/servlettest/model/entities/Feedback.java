package cat.itb.servlettest.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback extends DatabaseItem
{
    public enum Reaction { Happy, Angry, Sad, Neutral }

    private String description;
    private Reaction reaction;

    private Date date;

    private Specs specs;
}
