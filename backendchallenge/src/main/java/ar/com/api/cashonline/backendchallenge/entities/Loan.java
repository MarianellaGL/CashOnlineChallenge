package ar.com.api.cashonline.backendchallenge.entities;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "loan")
//@NamedNativeQuery(name = "Prestamo.findByUsuarioid", query ="SELECT * FROM prestamo WHERE usuario_id = ? LIMIT ?, ?" )
//@NamedNativeQuery(name = "Prestamo.listarPrestamos", query = "SELECT * FROM prestamo LIMIT ?,?") //LIMIT (Comienzo=offset),(Longitud=size)
public class Loan{

    @Id
    @Column(name = "loan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanId;

    @Column(name = "total_loan")
    private BigDecimal totalLoan = new BigDecimal(0);
    @Column(name = "loan_date")
    private Date loanDate;
    @Column(name = "cant_loan")
    private Integer cantLoan;

    @Column(name = "loan_amount")
    private BigDecimal loanAmount = new BigDecimal (0);

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;


    public Loan(int loanId, BigDecimal totalLoan, User user, Date loanDate, Integer cantLoan,
            BigDecimal loanAmount) {
        this.loanId = loanId;
        this.totalLoan = totalLoan;
        this.user = user;
        this.loanDate = loanDate;
        this.cantLoan = cantLoan;
        this.loanAmount = loanAmount;
    }

    public Loan() {
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public BigDecimal getTotalLoan() {
        return totalLoan;
    }

    public void setTotalLoan(BigDecimal totalLoan) {
        this.totalLoan = totalLoan;
    }

    @JsonIgnore

    public User getUser() {
        return user;
    }

    @JsonIgnore

    public void setUser(User user) {
        
        this.user = user;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Integer getCantLoan() {
        return cantLoan;
    }

    public void setCantLoan(Integer cantLoan) {
        this.cantLoan = cantLoan;
    }


    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

}