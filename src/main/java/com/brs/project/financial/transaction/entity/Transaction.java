package com.brs.project.financial.transaction.entity;

import com.brs.project.category.entity.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "T_TRXN")
@Setter
@Getter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Transaction {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name="CATEGORY_ID")
    private String categoryId;

    @Column(name = "DT_CREATE")
    private Date dtCreate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "DT_UPDATE")
    private Date dtUpdate;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Column(name="USER_ID")
    private String usrId;

    @Column(name="ACCOUNT_ID")
    private String accountId;

    @Column(name = "ACTION")
    private String action;
}
