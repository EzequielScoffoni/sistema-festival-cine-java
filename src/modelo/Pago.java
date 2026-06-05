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

    public double calcularPago () {
        if (promocion.validarPromocion()) {
            descuentoAplicado = promocion.aplicarDescuento(montoTotal);
            double resultado = montoTotal - descuentoAplicado;
            return resultado;
        }
        return montoTotal;
    }

    public boolean registrarPago () {
        if (calcularPago() > 0) {
            return true;
        }
        return false;
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

}
