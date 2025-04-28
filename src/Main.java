import com.lPassword012.app.screenMatch.modelos.Pelicula;

public class Principal {
    public static void main(String[] args) {
        Pelicula primeraPelicula = new Pelicula("Harry Potter y la piedra filosofal","29/11/2001",152,"si",1800);

        primeraPelicula.mostrarDetallesPelicula();
        primeraPelicula.modificarDetallesPelicula("Harry Potter y la piedra filosofal 2", "30/12/2001",250,"no",2600);
    }
}