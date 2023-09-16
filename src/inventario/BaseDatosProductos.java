package inventario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Abraham Galue
 */
public class BaseDatosProductos {
    
    private HashMap<Integer, Producto> listaProductos = new HashMap<>();

    public BaseDatosProductos() {
        this.listaProductos.put(1, new Producto(1, "Manzanas", 8000, 65));
        this.listaProductos.put(2, new Producto(2, "Limones", 2300, 15));
        this.listaProductos.put(3, new Producto(3, "Tomates", 2500, 33));
        this.listaProductos.put(4, new Producto(4, "Jamon", 9300, 55));
        this.listaProductos.put(5, new Producto(5, "Fresas", 2100, 42));
        this.listaProductos.put(6, new Producto(6, "Helado", 4100, 31));
        this.listaProductos.put(7, new Producto(7, "Peras", 4500, 41));
        this.listaProductos.put(8, new Producto(8, "Chocolates", 500, 55));
        this.listaProductos.put(9, new Producto(9, "Galletas", 3500, 806));
        this.listaProductos.put(10, new Producto(10, "Carnes", 15000, 10));
    }
    
    public List<Producto> getListaProductos() {
        return new ArrayList<>(this.listaProductos.values());
    }
    
    public void setListaProductos(HashMap<Integer, Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
    
    public void comprarProducto(Producto producto, int inventory) {
        producto.setInventario(inventory);
    }
    
    public boolean verificarExistencias(Producto producto) {
        return this.listaProductos.containsKey(producto.getCodigo());
    }
    
    public boolean verificarExistencias(String nombre) {
        for (Producto p : this.listaProductos.values()) {
            if (nombre.toLowerCase().equals(p.getNombre().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    
    public int ultimoCodigo() {
        int codigo = 0;
        for (Producto p : this.listaProductos.values()) {
            codigo = p.getCodigo();
        }
        return codigo;
    }
    
    public void agregar(Producto p) {
        this.listaProductos.put(p.getCodigo(), p);
    }
    
    public void actualizar(Producto p) {
        this.listaProductos.replace(p.getCodigo(), p);
    }
    
    public void borrar(Producto p) {
        this.listaProductos.remove(p.getCodigo());
    }
    
    public String generarInforme() {
        List<Producto> listaM = obtenerMayores();
        return listaM.get(0).getNombre() + ", " + listaM.get(1).getNombre() + ", " + listaM.get(2).getNombre() + ".";
    }
    
    private List<Producto> obtenerMayores() {
       List<Producto> lista = new ArrayList<>(this.listaProductos.values());
       List<Producto> listaMayores = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Producto p = new Producto();
            for (Producto pTemp : lista) {
                if (pTemp.getPrecio() > p.getPrecio()) {
                    p = pTemp;
                }
            }
            listaMayores.add(p);
            lista.remove(p);
        }
        return listaMayores;
    }
    
}
