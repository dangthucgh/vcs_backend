package vcs.com.project.Services.Impl;

import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vcs.com.project.Entity.Account;
import vcs.com.project.Repositories.AccountRepository;
import vcs.com.project.Repositories.AccountRepositoryCustom;
import vcs.com.project.Services.AccountService;
import vcs.com.project.dto.AccountDto;
import vcs.com.project.dto.BaseResponse;
import vcs.com.project.dto.GetListDataResponse;
import vcs.com.project.dto.GetSingleDataResponse;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class AccountServiceImpl implements AccountService {
    Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountRepositoryCustom accountRepositoryCustom;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public GetListDataResponse<AccountDto> getAllListAccount(AccountDto accountDto) {
        GetListDataResponse<AccountDto> getListDataResponse = new GetListDataResponse<>();
        try {
            Pageable pageable = PageRequest.of(0, Integer.MAX_VALUE);
            if (accountDto.getPageNumber() != null && accountDto.getPageSize() != null) {
                pageable = PageRequest.of(accountDto.getPageNumber(), accountDto.getPageSize());
            }
            Page<AccountDto> page = accountRepositoryCustom.getAllListAccount(pageable);
            getListDataResponse.setResult(page.getContent(), page.getTotalElements(), page.getTotalPages());
        } catch (Exception e) {
            getListDataResponse.setFailed();
        }
        return getListDataResponse;
    }

    @Override
    public GetSingleDataResponse<AccountDto> getDataById(AccountDto accountDto) {
        GetSingleDataResponse<AccountDto> getSingleDataResponse = new GetSingleDataResponse<>();
        try {
            if (accountDto != null) {
                Account account = accountRepository.findByAccountNumber(accountDto.getAccountNumber());
                if (account != null) {
                    getSingleDataResponse.setResult(modelMapper.map(account, AccountDto.class));
                } else {
                    getSingleDataResponse.setResult(null);
                }
            }
        } catch (Exception e) {
            getSingleDataResponse.setResult(null);
        }
        return getSingleDataResponse;
    }

    @Override
    public GetSingleDataResponse<AccountDto> createAccount(AccountDto accountDto) {
        GetSingleDataResponse<AccountDto> getSingleDataResponse = new GetSingleDataResponse<>();

        try {
            Account accountByEmail = accountRepository.findByEmail(accountDto.getEmail());
            if (accountByEmail != null) {
                getSingleDataResponse.setFailed("003", "Email đã tồn tại trong hệ thống");
            } else {
                Account accountSave = accountRepository.save(modelMapper.map(accountDto, Account.class));
                getSingleDataResponse.setResult(modelMapper.map(accountSave, AccountDto.class));
            }
        } catch (Exception e) {
            getSingleDataResponse.setFailed();
        }
        return getSingleDataResponse;
    }

    @Override
    public GetSingleDataResponse<AccountDto> updateAccount(AccountDto accountDto) {
        GetSingleDataResponse<AccountDto> getSingleDataResponse = new GetSingleDataResponse<>();
        if (StringUtils.isNotEmpty(String.valueOf(accountDto.getAccountNumber()))) {
            try {
                Account account = accountRepository.findByAccountNumber(accountDto.getAccountNumber());
                Account accountByEmail = accountRepository.findByEmail(accountDto.getEmail());
                if (account == null) {
                    getSingleDataResponse.setFailed("003", "Account không tồn tại trong hệ thống");
                } else if (accountByEmail != null) {
                    getSingleDataResponse.setFailed("003", "Email đã tồn tại trong hệ thống");
                } else {
                    Account accountSave = accountRepository.save(modelMapper.map(accountDto, Account.class));
                    getSingleDataResponse.setResult(modelMapper.map(accountSave, AccountDto.class));
                }
            } catch (Exception e) {
                getSingleDataResponse.setFailed();
            }
        } else {
            getSingleDataResponse.setFailed();
        }
        return getSingleDataResponse;
    }

    @Override
    public BaseResponse deleteAccount(AccountDto accountDto) {
        BaseResponse baseResponse = new BaseResponse();
        if (StringUtils.isNotEmpty(String.valueOf(accountDto.getAccountNumber()))) {
            try {
                Account account = accountRepository.findByAccountNumber(accountDto.getAccountNumber());
                if (account != null) {
                    accountRepository.deleteByAccount(accountDto.getAccountNumber());
                    baseResponse.setSuccess();
                } else {
                    baseResponse.setFailed("002", "Không tồn tại account");
                    return baseResponse;
                }
            } catch (Exception e) {
                baseResponse.setFailed();
                log.error(e.getMessage());
            }
        } else {
            baseResponse.setFailed("003", "Account number is empty");
        }
        return baseResponse;
    }
}
