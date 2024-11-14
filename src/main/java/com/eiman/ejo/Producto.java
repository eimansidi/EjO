package com.eiman.ejo;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.IOException;

/**
 * Aplicacion JavaFX que demuestra un componente reutilizable de etiqueta de producto.
 * La etiqueta incluye una imagen, el nombre del producto y la informacion de stock.
 * El color de fondo cambia segun la cantidad de stock.
 */
public class Producto extends GridPane {

    @FXML
    private Label nombreProductoLabel;

    @FXML
    private Label stockProductoLabel;

    @FXML
    private ImageView imagenProductoImageView;

    /**
     * Constructor de la clase.
     */
    public Producto() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/EjO.fxml"));
        fxmlLoader.setRoot(this); // Define esta clase como raíz
        fxmlLoader.setController(this); // Establece este como el controlador
        try {
            fxmlLoader.load(); // Carga el archivo FXML
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar el archivo FXML de Producto", e);
        }
    }

    /**
     * Establece la cantidad de stock del producto.
     *
     * @param cantidad La cantidad de stock.
     */
    public void setStock(double cantidad) {
        String style;
        if (cantidad > 100) {
            style = "verde";
        } else if (cantidad > 20) {
            style = "azul";
        } else {
            style = "rojo";
        }
        stockProductoLabel.setText(String.valueOf(cantidad));
        this.getStyleClass().clear();
        this.getStyleClass().add(style);
    }

    /**
     * Establece el nombre del producto.
     *
     * @param nombre El nombre del producto.
     */
    public void setName(String nombre) {
        nombreProductoLabel.setText(nombre);
    }

    /**
     * Establece la imagen del producto.
     *
     * @param imagen La imagen del producto.
     */
    public void setImage(Image imagen) {
        imagenProductoImageView.setImage(imagen);
    }
}
