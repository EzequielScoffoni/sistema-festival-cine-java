package modelo;

import java.util.Date;

public class Promocion {

    private String codigoPromocion;
    private double porcentajeDescuento;
    private Date fechaVencimiento;

    public Promocion(String codigoPromocion, double porcentajeDescuento, Date fechaVencimiento) {
        this.codigoPromocion = codigoPromocion;
        this.porcentajeDescuento = porcentajeDescuento;
        this.fechaVencimiento = fechaVencimiento;
    }

    public boolean validarPromocion () {
        Date fechaActual = new Date();
        if (fechaActual.compareTo(fechaVencimiento) <= 0) {
            return true;
        }
        return false;
    }

    public double aplicarDescuento (double monto) {
        if (validarPromocion()){
            double descuento = monto * porcentajeDescuento / 100;
            return descuento;
        }
        return 0;
    }

    public String getCodigoPromocion() {
        return codigoPromocion;
    }

    public double getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

}
