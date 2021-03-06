package io.swagger.api;

import io.swagger.annotations.Api;
import io.swagger.api.interfaces.AccountsApi;
import io.swagger.helpers.Authorized;
import io.swagger.jwt.JwtTokenProvider;
import io.swagger.model.Request.AccountRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.model.Entity.AccountEntity;
import io.swagger.responses.account.AccountListResponse;
import io.swagger.responses.account.AccountSingleResponse;
import io.swagger.service.AccountService;
import io.swagger.service.UserService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-26T09:18:21.534Z[GMT]")
@RestController
@Api(tags = "Accounts")
public class AccountsApiController implements AccountsApi {

    private static final Logger log = LoggerFactory.getLogger(AccountsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    Authorized authorized;

    @org.springframework.beans.factory.annotation.Autowired
    public AccountsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<AccountListResponse> accountsGet(@Parameter(in = ParameterIn.QUERY, description = "Limits the number of items on a page", schema = @Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit,
                                                           @Parameter(in = ParameterIn.QUERY, description = "Specifies the page number of the artists to be displayed", schema = @Schema()) @Valid
                                                                 @RequestParam(value = "offset", required = false) Integer offset) throws IOException {
        authorized.NeedsToBeEmployee();
        List<AccountEntity> accounts = accountService.getAccounts(offset,limit);
        return ResponseEntity.ok(new AccountListResponse(HttpStatus.OK, accounts));
    }

    public ResponseEntity<AccountSingleResponse> accountsIbanIbanGet(
            @Parameter(in = ParameterIn.PATH, description = "Gets the Iban of the user based on the input", required = true, schema = @Schema())
            @PathVariable("IBAN") String IBAN) throws IOException {
        AccountEntity account = accountService.getAccountByIBAN(IBAN);
        return ResponseEntity.ok(new AccountSingleResponse(HttpStatus.OK, account));
    }

    public ResponseEntity<AccountSingleResponse> accountsIbanIbanPut(
            @Parameter(in = ParameterIn.PATH, description = "The iban of the user is taken",
                    required = true,
                    schema = @Schema()) @PathVariable("IBAN") String IBAN,
            @RequestBody AccountRequest body) throws IOException {
        authorized.CanOnlyEditOwnAccount(UUID.fromString(body.getUserId()));
        AccountEntity account = accountService.updateAccountByIBAN(body, IBAN);
        return ResponseEntity.ok(new AccountSingleResponse(HttpStatus.OK, account));
    }

    public ResponseEntity<AccountListResponse> accountsIdIdGet(@Parameter(in = ParameterIn.PATH,
            description = "The unique id of the user is taken",
            required = true,
            schema = @Schema()) @PathVariable("id") String id) throws IOException {
        String newid = id.replaceAll("-","").replaceAll(
                "(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})",
                "$1-$2-$3-$4-$5");
        authorized.CanOnlyEditOwnAccount(UUID.fromString(id));
        List<AccountEntity> accounts = accountService.getAccountByUserId(UUID.fromString(newid));
        return ResponseEntity.ok(new AccountListResponse(HttpStatus.OK, accounts));
    }

    public ResponseEntity<AccountSingleResponse> accountsPost(@Parameter(in = ParameterIn.DEFAULT,
            description = "This endpoint creates a new account that can be used to transfer and withdraw money.",
            required = true, schema = @Schema()) @RequestBody AccountRequest body) throws IOException {
        authorized.CanOnlyEditOwnAccount(UUID.fromString(body.getUserId()));
        AccountEntity account = accountService.addAccount(body);
        return ResponseEntity.ok(new AccountSingleResponse(HttpStatus.CREATED, account));
    }

    public ResponseEntity<AccountSingleResponse> accountsSearchGet(
            @Parameter(in = ParameterIn.QUERY, description = "The name of the user is searched with the submitted input. If the user existed the account is returned", schema = @Schema())
            @Valid @RequestParam(value = "name", required = true) String name) throws IOException {
        AccountEntity account = accountService.findAccountByUserName(name);
        return ResponseEntity.ok(new AccountSingleResponse(HttpStatus.OK, account));
    }
}
