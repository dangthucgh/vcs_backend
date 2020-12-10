package vcs.com.project.Services.Impl;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vcs.com.project.Entity.Users;
import vcs.com.project.Repositories.UsersRepository;
import vcs.com.project.Services.UsersService;
import vcs.com.project.dto.UsersDto;

@Service
public class UsersServiceImpl implements UsersService {
    private final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsersDto getUser(String username, String password) {
        UsersDto usersDto = new UsersDto();
        try {
            Users users = usersRepository.findByUsername(username);
            if (users == null) {
                log.error("User not found with username: ", username);
            } else if (!users.getPassword().equals(password)) {
                log.error("User not found with password: ", password);
            } else {
                usersDto = modelMapper.map(users, UsersDto.class);
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return usersDto;
    }
}
