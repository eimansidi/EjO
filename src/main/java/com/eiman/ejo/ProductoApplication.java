package com.eiman.ejo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Aplicacion JavaFX que demuestra un componente reutilizable de etiqueta de producto.
 * La etiqueta incluye una imagen, el nombre del producto y la informacion de stock.
 * El color de fondo cambia segun la cantidad de stock.
 */
public class ProductoApplication extends GridPane {

    private GridPane root;
    private Label nombreProductoLabel;
    private Label stockProductoLabel;
    private ImageView imagenProductoImageView;

    /**
     * Constructor de la clase
     */
    public ProductoApplication() {
        FXMLLoader fxmlLoader = new FXMLLoader(ProductoApplication.class.getResource("fxml/EjO.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Establece la cantidad de stock del producto.
     * Actualiza el color de fondo en funcion de los niveles de stock:
     * - Verde para mas de 100
     * - Azul para entre 20 y 100
     * - Rojo para menos de 20
     *
     * @param cantidad La cantidad de stock.
     */
    public void setStock(double cantidad) {
        // Determina el color de fondo segun los niveles de stock
        String style;
        if (cantidad > 100) {
            style = "verde"; // Verde para alto stock
        } else if (cantidad > 20) {
            style = "azul"; // Azul para stock medio
        } else {
            style = "rojo"; // Rojo para bajo stock
        }

        // Actualiza el texto del stock y el estilo de fondo del contenedor
        stockProductoLabel.setText(String.valueOf(cantidad));
        root.getStyleClass().clear();
        root.getStyleClass().add(style);
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nombre del producto.
     */
    public void setName(String nombre) {
        nombreProductoLabel.setText(nombre + ""); // Actualiza la etiqueta del nombre
    }

    /**
     * Establece la imagen del producto.
     *
     * @param imagen La imagen del producto.
     */
    public void setImage(Image imagen) {
        imagenProductoImageView.setImage(imagen); // Establece la imagen en el ImageView
    }

}
