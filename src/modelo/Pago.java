package modelo;

import java.util.HashSet;
import java.util.Set;

public class Pago {

    private double montoTotal;
    private double descuentoAplicado;
    private String metodoPago;
    private Promocion promocion;

    public Pago(double montoTotal, double descuentoAplicado, String metodoPago, Promocion promocion) {
        this.montoTotal = montoTotal;
        this.descuentoAplicado = descuentoAplicado;
        this.metodoPago = metodoPago;
        this.promocion = promocion;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public double getDescuentoAplicado() {
        return descuentoAplicado;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setDescuentoAplicado(double descuentoAplicado) {
        this.descuentoAplicado = descuentoAplicado;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }
}
