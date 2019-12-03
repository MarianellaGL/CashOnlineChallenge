package ar.com.api.cashonline.backendchallenge.models.response;

import java.util.*;

import ar.com.api.cashonline.backendchallenge.entities.Loan;
import ar.com.api.cashonline.backendchallenge.models.Paging;

public class LoansResponse {

    public List<Loan> items = new ArrayList<Loan>();

    public Paging paging = new Paging();
    

}