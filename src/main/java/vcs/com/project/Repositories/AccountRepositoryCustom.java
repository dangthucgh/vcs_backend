package vcs.com.project.Repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vcs.com.project.dto.AccountDto;

public interface AccountRepositoryCustom {
    Page<AccountDto> getAllListAccount(Pageable pageable);
}
