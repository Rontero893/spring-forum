package cat.itb.springforum.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

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
    private String date;

    private Specs specs;

    public Feedback(String userId, String description, Reaction reaction, String screenshotUrl, String date)
    {
        this.userId = userId;
        this.description = description;
        this.reaction = reaction;
        this.screenshotUrl = screenshotUrl;
        this.date = date;
    }
}
