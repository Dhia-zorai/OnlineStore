package com.fsb.onlinestore3.web.models.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductForm {
    private long id;
    @NotBlank(message = "Code est obligatoire")
    @Size(min = 2, max = 10, message = "Taile invalide")
    private String code;

    @NotBlank(message = "Nom est obligatoire")
    @Size(min = 2, max = 50, message = "Taille invalide")
    private String name;

    @NotNull(message = "Prix est obligatoire")
    private double price;

    @NotNull(message = "Quantité est obligatoire")
    private int quantity;

    private String img;

}
