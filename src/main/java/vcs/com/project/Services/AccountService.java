package vcs.com.project.Services;

import vcs.com.project.dto.AccountDto;
import vcs.com.project.dto.BaseResponse;
import vcs.com.project.dto.GetListDataResponse;
import vcs.com.project.dto.GetSingleDataResponse;

public interface AccountService {
    GetListDataResponse<AccountDto> getAllListAccount(AccountDto accountDto);

    GetSingleDataResponse<AccountDto> getDataById(AccountDto accountDto);

    GetSingleDataResponse<AccountDto> createAccount(AccountDto accountDto);

    GetSingleDataResponse<AccountDto> updateAccount(AccountDto accountDto);

    BaseResponse deleteAccount(AccountDto accountDto);
}
