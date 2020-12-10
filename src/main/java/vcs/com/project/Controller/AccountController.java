package vcs.com.project.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vcs.com.project.Services.AccountService;
import vcs.com.project.dto.AccountDto;
import vcs.com.project.dto.BaseResponse;
import vcs.com.project.dto.GetListDataResponse;
import vcs.com.project.dto.GetSingleDataResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/getAllList")
    public ResponseEntity<?> getAllListAccount(@RequestBody AccountDto accountDto) {
        GetListDataResponse<AccountDto> getListDataResponse = new GetListDataResponse<>();
        getListDataResponse = accountService.getAllListAccount(accountDto);
        return new ResponseEntity<>(getListDataResponse, HttpStatus.OK);
    }

    @PostMapping("/getInfoById")
    public ResponseEntity<?> getInfoById(@RequestBody AccountDto accountDto) {
        GetSingleDataResponse<AccountDto> getSingleDataResponse = new GetSingleDataResponse<>();
        getSingleDataResponse = accountService.getDataById(accountDto);
        return new ResponseEntity<>(getSingleDataResponse, HttpStatus.OK);
    }

    @PostMapping("/createAccount")
    public ResponseEntity<?> createAccount(@RequestBody AccountDto accountDto) {
        GetSingleDataResponse<AccountDto> getSingleDataResponse = new GetSingleDataResponse<>();
        getSingleDataResponse = accountService.createAccount(accountDto);
        return new ResponseEntity<>(getSingleDataResponse, HttpStatus.OK);
    }

    @PostMapping("/updateAccount")
    public ResponseEntity<?> updateAccount(@RequestBody AccountDto accountDto) {
        GetSingleDataResponse<AccountDto> getSingleDataResponse = new GetSingleDataResponse<>();
        getSingleDataResponse = accountService.updateAccount(accountDto);
        return new ResponseEntity<>(getSingleDataResponse, HttpStatus.OK);
    }

    @PostMapping("/deleteByAccountNumber")
    public ResponseEntity<?> deleteByAccountNumber(@RequestBody AccountDto accountDto) {
        BaseResponse baseResponse = new BaseResponse();
        baseResponse = accountService.deleteAccount(accountDto);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }
}
