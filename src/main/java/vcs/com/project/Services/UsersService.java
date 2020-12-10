package vcs.com.project.Services;

import vcs.com.project.dto.UsersDto;

public interface UsersService {
    UsersDto getUser(String username, String password);
}
