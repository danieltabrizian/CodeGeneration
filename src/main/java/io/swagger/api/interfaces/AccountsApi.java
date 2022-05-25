/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.interfaces;

import io.swagger.model.Account;
import io.swagger.model.InlineResponse401;
import io.swagger.model.InlineResponse403;
import io.swagger.model.InlineResponse404;
import io.swagger.model.InlineResponse405;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-26T09:18:21.534Z[GMT]")
@Validated
public interface AccountsApi {

    @Operation(summary = "Returns a list of accounts", description = "Successfully returns a list of all users and the acoounts with it. A saving account or the current account.", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Accounts" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Successfully returned a list of accounts", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Account.class)))),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "403", description = "403 not Authorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse403.class))) })
    @RequestMapping(value = "/accounts",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Account>> accountsGet(@Parameter(in = ParameterIn.QUERY, description = "Limits the number of items on a page" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit, @Parameter(in = ParameterIn.QUERY, description = "Specifies the page number of the artists to be displayed" ,schema=@Schema()) @Valid @RequestParam(value = "offset", required = false) Integer offset);


    @Operation(summary = "Returns single account using IBAN", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Accounts" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "returns account", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "403", description = "403 not Authorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse403.class))),
        
        @ApiResponse(responseCode = "404", description = "404 not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse404.class))) })
    @RequestMapping(value = "/accounts/iban/{iban}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Account> accountsIbanIbanGet(@Parameter(in = ParameterIn.PATH, description = "Gets the Iban of the user based on the input", required=true, schema=@Schema()) @PathVariable("iban") String iban);


    @Operation(summary = "Change account data", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Accounts" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "returns account", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "403", description = "403 not Authorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse403.class))),
        
        @ApiResponse(responseCode = "404", description = "404 not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse404.class))),
        
        @ApiResponse(responseCode = "405", description = "Data input is invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse405.class))) })
    @RequestMapping(value = "/accounts/iban/{iban}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Account> accountsIbanIbanPut(@Parameter(in = ParameterIn.PATH, description = "The iban of the user is taken", required=true, schema=@Schema()) @PathVariable("iban") String iban);


    @Operation(summary = "Returns all accounts on user id", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Accounts" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "returns account", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "403", description = "403 not Authorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse403.class))),
        
        @ApiResponse(responseCode = "404", description = "404 not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse404.class))) })
    @RequestMapping(value = "/accounts/id/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Account> accountsIdIdGet(@Parameter(in = ParameterIn.PATH, description = "The unique id of the user is taken", required=true, schema=@Schema()) @PathVariable("id") Integer id);


    @Operation(summary = "Creating a new account", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Accounts" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "The account has been successfully created", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "403", description = "403 not Authorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse403.class))),
        
        @ApiResponse(responseCode = "405", description = "Data input is invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse405.class))) })
    @RequestMapping(value = "/accounts",
        produces = { "application/json" }, 
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    String accountsPost(@Parameter(in = ParameterIn.DEFAULT, description = "This endpoint creates a new account that can be used to transfer and withdraw money.", required=true, schema=@Schema()) @Valid @RequestBody Account body);


    @Operation(summary = "Returns single account using IBAN", description = "", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Accounts" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "returns account", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Account.class))),
        
        @ApiResponse(responseCode = "401", description = "Access token is missing or invalid", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse401.class))),
        
        @ApiResponse(responseCode = "403", description = "403 not Authorized", content = @Content(mediaType = "application/json", schema = @Schema(implementation = InlineResponse403.class))) })
    @RequestMapping(value = "/accounts/search",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Account> accountsSearchGet(@Parameter(in = ParameterIn.QUERY, description = "The name of the user is searched with the submitted input. If the user existed the account is returned" ,schema=@Schema()) @Valid @RequestParam(value = "name", required = false) String name);

}
