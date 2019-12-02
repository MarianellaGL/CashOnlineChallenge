package ar.com.api.cashonline.backendchallenge.models;

/**
 * Paging
 */
public class Paging {

    public int page;
    public int size;
    public long total;

    public Paging(int page, int size, long total) {
        this.page = page;
        this.size = size;
        this.total = total;
    }

    public Paging() {
    }
    
}