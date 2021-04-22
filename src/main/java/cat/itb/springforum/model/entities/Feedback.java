package cat.itb.springforum.model.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonAutoDetect
@Entity(name = "feedback")
public class Feedback
{
    public enum Reaction { Happy, Angry, Sad, Neutral }

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    private UserForum userForum;

    private String description;
    private Reaction reaction;

    private String screenshotUrl;
    private String date;

    public Feedback(UserForum userForum, String description, Reaction reaction, String screenshotUrl, String date)
    {
        this.userForum = userForum;
        this.description = description;
        this.reaction = reaction;
        this.screenshotUrl = screenshotUrl;
        this.date = date;
    }
}
