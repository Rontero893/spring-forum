package cat.itb.springforum.model.entities;

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

    private String userId, description;
    private Reaction reaction;

    private String screenshotUrl;
    private Date date;

    private Specs specs;
}