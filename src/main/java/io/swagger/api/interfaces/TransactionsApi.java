/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.33).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api.interfaces;

import io.swagger.model.*;
import io.swagger.responses.transactions.TransactionAtmResponse;
import io.swagger.responses.transactions.TransactionListResponse;
import io.swagger.responses.transactions.TransactionSingleResponse;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-04-26T09:18:21.534Z[GMT]")
@Validated
public interface TransactionsApi {

    @Operation(summary = "", description = "Returns a list of transactions", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transactions" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "returns a list of all the transactions tht has been made", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Transaction.class)))),
    })
    @RequestMapping(value = "/transactions",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<TransactionListResponse>> transactionsGet(@Parameter(in = ParameterIn.QUERY, description = "Limits the number of items on a page" ,schema=@Schema()) @Valid @RequestParam(value = "limit", required = false) Integer limit, @Parameter(in = ParameterIn.QUERY, description = "Specifies the page number of the artists to be displayed" ,schema=@Schema()) @Valid @RequestParam(value = "offset", required = false) Integer offset) throws IOException;


    @Operation(summary = "creates a new transaction", description = "creates a new transaction", security = {
        @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transactions" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "creates new transaction and returns the information of the transaction e.g. timestamp, from, to and the amount of the transaction", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Transaction.class))),
    })
    @RequestMapping(value = "/transactions",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<TransactionSingleResponse> transactionsPost(@RequestBody Transaction body) throws IOException;

    @Operation(summary = "Withdraw money", description = "withdraw money", security = {
            @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Withdraws money from the account", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Transaction.class))),
    })
    @RequestMapping(value = "/atm/withdraw",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<TransactionAtmResponse> atmWithdraw(@RequestBody Atm body) throws IOException;

    @Operation(summary = "Depositing money", description = "depositing money", security = {
            @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Withdraws money from the account", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Transaction.class))),
    })
    @RequestMapping(value = "/atm/deposit",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<TransactionAtmResponse> atmDeposit(@RequestBody Atm body) throws IOException;

    @Operation(summary = "", description = "Advanced search for transactions", security = {
            @SecurityRequirement(name = "bearerAuth")    }, tags={ "Transactions" })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "advance search for transactions", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Transaction.class)))),
    })
    @RequestMapping(value = "/transactions/search",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<TransactionListResponse>> transactionsGetAdvancedSearch(
            @Parameter(in = ParameterIn.QUERY, description = "Limits the number of items on a page" ,schema=@Schema())
            @Valid @RequestParam(value = "limit", required = false) Integer limit,
            @Parameter(in = ParameterIn.QUERY, description = "Specifies the page number of the artists to be displayed" ,schema=@Schema())
            @Valid @RequestParam(value = "offset", required = false) Integer offset,
            @RequestBody TransactionAdvancedSearchRequest body) throws IOException;

}

