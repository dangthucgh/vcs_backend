package vcs.com.project.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto extends BaseRequest {
    private String username;
    private String password;
    private String email;
}
