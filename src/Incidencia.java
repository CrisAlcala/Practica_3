import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Incidencia {
    Scanner s = new Scanner(System.in);
    private int id;
    private Usuario creador;
    private String comentario;
    private Usuario técnico;
    private String solución;
    private boolean resuelta;
    private int prioridad;
    private Date fecha_creac;
    private Date fecha_resolv;
    private static int numIncidencias = 1;

    //Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getCreador() {
        return creador;
    }

    public void setCreador(Usuario creador) {
        this.creador = creador;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Usuario getTécnico() {
        return técnico;
    }

    public void setTécnico(Usuario técnico) {
        this.técnico = técnico;
    }

    public String getSolución() {
        return solución;
    }

    public void setSolución(String solución) {
        this.solución = solución;
    }

    public boolean isResuelta() {
        return resuelta;
    }

    public void setResuelta(boolean resuelta) {
        this.resuelta = resuelta;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public Date getFecha_creac() {
        return fecha_creac;
    }

    public void setFecha_creac(Date fecha_creac) {
        this.fecha_creac = fecha_creac;
    }

    public Date getFecha_resolv() {
        return fecha_resolv;
    }

    public void setFecha_resolv(Date fecha_resolv) {
        this.fecha_resolv = fecha_resolv;
    }

    public static int getNumIncidencias() {
        return numIncidencias;
    }

    public static void setNumIncidencias(int numIncidencias) {
        Incidencia.numIncidencias = numIncidencias;
    }

    //To String


    @Override
    public String toString() {
        Date hoy = new Date();
        SimpleDateFormat fechaSimp = new SimpleDateFormat("dd/mm/yyyy");
        String tecnico = (this.técnico==null)?"":"Tomada por el técnico: " + this.técnico.getNombre(); //OPerador ternario
        String prioridad = (this.prioridad==1)?"Alta":(this.prioridad==2)?"Media":"Baja";
        if (isResuelta() == true) {
            return
                    "ID: " + getId() +
                    "Creada por " + getCreador().getNombre() +
                    "Resuelta por " + getTécnico().getNombre() +
                    "Comentarios: " + getComentario() +
                    "Resolución: " + getSolución() +
                    "Prioridad: " + prioridad +
                    "Fecha de creación: " + fechaSimp.format(getFecha_creac()) +
                    "Fecha de resolución: " + fechaSimp.format(getFecha_resolv()) +
                    "Incidencia resuelta";
        } else
            return
                    "ID: " + getId() +
                    "Creada por: " + getCreador().getNombre() +
                    "Resuelta por: " + getTécnico().getNombre() +
                    "Comentarios: " + comentario +
                    "Prioridad: " + prioridad +
                    "Fecha de creación: " + fechaSimp.format(getFecha_creac()) +
                    "Incidencia no resuelta";
    }

    //Constructor por defecto
    public Incidencia() {
        setId(0);
        setCreador(new Usuario());
        setComentario("");
        setTécnico(new Usuario());
        setSolución("");
        setResuelta(false);
        setPrioridad(0);
        setFecha_creac(new Date());
        setFecha_resolv(new Date());
    }


        //Constructor de incidencias
        public Incidencia(Usuario creador) {
            this.id = numIncidencias;
            this.creador = creador;
            this.comentario = "";
            System.out.println("* (Campos obligatorios)");
            do {
                System.out.println("¿Detalles a destacar sobre la incidencia?*");
                comentario = s.nextLine();
            } while (this.comentario.equals(""));
            resuelta = false;
            do {
                System.out.println("" +
                        "¿Cuál es la prioridad del problema?" +
                        "1 - Alta" +
                        "2 - Media" +
                        "3 - Baja");
                this.prioridad = s.nextInt();
            } while (this.prioridad < 1 && this.prioridad > 3);
            this.fecha_creac = new Date();
            this.solución = "";
            System.out.println("Incidencia registrada satisfactoriamente");
        }
}
