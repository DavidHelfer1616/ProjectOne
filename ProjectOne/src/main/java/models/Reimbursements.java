package models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

public class Reimbursements {

    private Integer reimbId;
    private Double reimbAmount;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp submitDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Timestamp resolveDate;
    private String reimbDescription;
    private byte[] reimbReciept;
    private String reimbAuthorFirst;
    private String reimbAuthorLast;
    private String reimbResolverFirst;
    private String reimbResolverLast;
    private Integer reimbStatus;
    private Integer reimbType;
    private Integer authorId;
    private Integer resolverId;

    public Reimbursements() {
    }

    public Reimbursements(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public Reimbursements(Integer reimbId, Integer reimbStatus, Integer resolverId) {
        this.reimbId = reimbId;
        this.reimbStatus = reimbStatus;
        this.resolverId = resolverId;
    }

    public Reimbursements(Double reimbAmount, String reimbDescription, Integer reimbType, Integer authorId) {
        this.reimbAmount = reimbAmount;
        this.reimbDescription = reimbDescription;
        this.reimbType = reimbType;
        this.authorId = authorId;
    }

    public Reimbursements(Integer reimbId, Double reimbAmount, Timestamp submitDate, Timestamp resolveDate,
                          String reimbDescription, byte[] reimbReciept, String reimbAuthorFirst, String reimbAuthorLast,
                          String reimbResolverFirst, String reimbResolverLast, Integer reimbStatus, Integer reimbType){
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.submitDate = submitDate;
        this.resolveDate = resolveDate;
        this.reimbDescription = reimbDescription;
        this.reimbReciept = reimbReciept;
        this.reimbAuthorFirst = reimbAuthorFirst;
        this.reimbAuthorLast = reimbAuthorLast;
        this.reimbResolverFirst = reimbResolverFirst;
        this.reimbResolverLast = reimbResolverLast;
        this.reimbStatus = reimbStatus;
        this.reimbType = reimbType;
    }

    public Reimbursements(Integer reimbId, Double reimbAmount, Timestamp submitDate, Timestamp resolveDate,
                          String reimbDescription, byte[] reimbReciept, String reimbAuthorFirst, String reimbAuthorLast,
                          String reimbResolverFirst, String reimbResolverLast, Integer reimbStatus, Integer reimbType,
                          Integer authorId) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.submitDate = submitDate;
        this.resolveDate = resolveDate;
        this.reimbDescription = reimbDescription;
        this.reimbReciept = reimbReciept;
        this.reimbAuthorFirst = reimbAuthorFirst;
        this.reimbAuthorLast = reimbAuthorLast;
        this.reimbResolverFirst = reimbResolverFirst;
        this.reimbResolverLast = reimbResolverLast;
        this.reimbStatus = reimbStatus;
        this.reimbType = reimbType;
        this.authorId = authorId;
    }


    public Integer getReimbId() {
        return reimbId;
    }

    public void setReimbId(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public Double getReimbAmount() {
        return reimbAmount;
    }

    public void setReimbAmount(Double reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public Timestamp getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Timestamp submitDate) {
        this.submitDate = submitDate;
    }

    public Timestamp getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Timestamp resolveDate) {
        this.resolveDate = resolveDate;
    }

    public String getReimbDescription() {
        return reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public byte[] getReimbReciept() {
        return reimbReciept;
    }

    public void setReimbReciept(byte[] reimbReciept) {
        this.reimbReciept = reimbReciept;
    }

    public String getReimbAuthorFirst() {
        return reimbAuthorFirst;
    }

    public void setReimbAuthorFirst(String reimbAuthorFirst) {
        this.reimbAuthorFirst = reimbAuthorFirst;
    }

    public String getReimbAuthorLast() {
        return reimbAuthorLast;
    }

    public void setReimbAuthorLast(String reimbAuthorLast) {
        this.reimbAuthorLast = reimbAuthorLast;
    }

    public String getReimbResolverFirst() {
        return reimbResolverFirst;
    }

    public void setReimbResolverFirst(String reimbResolverFirst) {
        this.reimbResolverFirst = reimbResolverFirst;
    }

    public String getReimbResolverLast() {
        return reimbResolverLast;
    }

    public void setReimbResolverLast(String reimbResolverLast) {
        this.reimbResolverLast = reimbResolverLast;
    }

    public Integer getReimbStatus() {
        return reimbStatus;
    }

    public void setReimbStatus(Integer reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    public Integer getReimbType() {
        return reimbType;
    }

    public void setReimbType(Integer reimbType) {
        this.reimbType = reimbType;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getResolverId() {
        return resolverId;
    }

    public void setResolverId(Integer resolverId) {
        this.resolverId = resolverId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reimbursements that = (Reimbursements) o;
        return Objects.equals(reimbId, that.reimbId) &&
                Objects.equals(reimbAmount, that.reimbAmount) &&
                Objects.equals(submitDate, that.submitDate) &&
                Objects.equals(resolveDate, that.resolveDate) &&
                Objects.equals(reimbDescription, that.reimbDescription) &&
                Arrays.equals(reimbReciept, that.reimbReciept) &&
                Objects.equals(authorId, that.authorId) &&
                Objects.equals(reimbAuthorFirst, that.reimbAuthorFirst) &&
                Objects.equals(reimbAuthorLast, that.reimbAuthorLast) &&
                Objects.equals(resolverId, that.resolverId) &&
                Objects.equals(reimbResolverFirst, that.reimbResolverFirst) &&
                Objects.equals(reimbResolverLast, that.reimbResolverLast) &&
                Objects.equals(reimbStatus, that.reimbStatus) &&
                Objects.equals(reimbType, that.reimbType);
    }

    @Override
    public String toString() {
        return "Reimbursements{" +
                "reimbId=" + reimbId +
                ", reimbAmount=" + reimbAmount +
                ", submitDate=" + submitDate +
                ", resolveDate=" + resolveDate +
                ", reimbDescription='" + reimbDescription + '\'' +
                ", reimbReciept=" + Arrays.toString(reimbReciept) +
                ", authorId=" + authorId +
                ", reimbAuthorFirst='" + reimbAuthorFirst + '\'' +
                ", reimbAuthorLast='" + reimbAuthorLast + '\'' +
                ", resolverId=" + resolverId +
                ", reimbResolverFirst='" + reimbResolverFirst + '\'' +
                ", reimbResolverLast='" + reimbResolverLast + '\'' +
                ", reimbStatus=" + reimbStatus +
                ", reimbType=" + reimbType +
                '}';
    }
}

