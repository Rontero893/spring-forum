package cat.itb.servlettest.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserForum extends DatabaseItem
{
    public enum Role { ADMIN, USER }

    private String email, username, password;

    private Feedback[] feedbackHistory;
}
