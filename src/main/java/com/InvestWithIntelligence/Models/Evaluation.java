package com.InvestWithIntelligence.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "model_id")
    private Long id;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "Revenue")
    private String revenue;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "Cost_of_Revenue")
    private String cost_of_Revenue;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "SG_A_Expense")
    private String sg_a_expense;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "Operating_Expenses")
    private String operating_expenses;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "Total_expenses")
    private String total_expenses;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "Total_shareholders_equity")
    private String total_shareholders_equity;

    // @NotEmpty(message = AppConstants.NOT_EMPTY)
    @Column(name = "Other_Assets")
    private String other_assets;

    @OneToOne
    private Startup startup;
}
