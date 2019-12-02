package ar.com.api.cashonline.backendchallenge.models.response;

import java.util.*;

import ar.com.api.cashonline.backendchallenge.entities.Prestamo;
import ar.com.api.cashonline.backendchallenge.models.Paging;

public class LoansResponse {

    public List<Prestamo> items = new ArrayList<Prestamo>();

    public Paging paging = new Paging();
    

}