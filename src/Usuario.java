import java.util.*;

public class Usuario {
    //Atributos
    private String nombre;
    private String usuario;
    private String contraseña;
    private String cod_user;
    private int tipo_user;
    private String asignación;
    private Incidencia inc1;
    private Incidencia inc2;
    private Incidencia inc3;
    private boolean correcto = false;

    //Constructor Admin
    public Usuario(String nombre, String usuario, String contraseña, int tipo_user, String cod_user) {
        if (tipo_user == 0) {
            setAsignación("Administrador");
        }
        setNombre(nombre);
        setUsuario(usuario);
        setContraseña(contraseña);
        setTipo_user(tipo_user);
        setCod_user(cod_user);
        setInc1(new Incidencia());
        setInc2(new Incidencia());
        setInc3(new Incidencia());
    }

    //Constructor por defecto
    public Usuario() {
        this.nombre = "";
        this.usuario = "";
        this.contraseña = "";
        this.tipo_user = 0;
        this.cod_user = "";
    }

    //Crear usuarios y tecnicos
    public Usuario(int tipo_user, String cod_user) {
        if (tipo_user == 1) {
            setAsignación("Usuario");
        } else if (tipo_user == 0) {
            setAsignación("Administrador");
        } else {
            setAsignación("Técnico");
        }
        Scanner s = new Scanner(System.in);
        this.cod_user = cod_user;
        this.tipo_user = tipo_user;
        this.inc1 = new Incidencia();
        this.inc2 = new Incidencia();
        if (tipo_user ==1){ // Si es usuario puede almacenar 3 incidencias, si es técnico, 2, he ahí la condición
            this.inc3 = new Incidencia();
        }

        String nombre = "";
        String usuario = "";
        String contraseña = "";
        String conf_pass;
        do {
            System.out.println("¿Cuál es tu nombre? Usuario #" + cod_user);
            nombre = s.nextLine();
            if (nombre.equals("")) {
                System.out.println("El nombre no puede estar vacío\n");
            } else {
                this.nombre=nombre;
                System.out.println("Nombre registrado correctamente\n");
                correcto=true;
            }
        } while (!correcto);

        correcto=false;
        do {
            System.out.println("Escribe tu nombre de usuario, " + nombre);
            usuario = s.nextLine();
            if (usuario.equals("")) {
                System.out.println("El usuario no puede estar vacío\n");
            } else {
                this.usuario = usuario;
                System.out.println(usuario + " como nombre de Usuario registrado correctamente\n");
                correcto = true;
            }
        } while (!correcto);
        correcto = false;
        do {
            do {
                System.out.println("Escribe tu contraseña, " + nombre);
                contraseña = s.nextLine();
            } while (contraseña.equals(""));
            System.out.println("Repita su contraseña, por favor");
            conf_pass = s.nextLine();
            if (!contraseña.equals(conf_pass)) {
                System.out.println("Las contraseñas no coinciden\n");
            } else {
                this.contraseña = contraseña;
                System.out.println("Contraseña establecida\n");
                correcto=true;
            }
        } while (!correcto);
        System.out.println(toString());
    }

    //Getter && Setters
    public String getAsignación() {
        return asignación;
    }
    public void setAsignación(String asignación) {
        this.asignación = asignación;
    }
    public boolean isCorrecto() {
        return correcto;
    }
    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContraseña() {
        return contraseña;
    }
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public String getCod_user() {
        return cod_user;
    }
    public void setCod_user(String cod_user) {
        this.cod_user = cod_user;
    }
    public int getTipo_user() {
        return tipo_user;
    }
    public void setTipo_user(int tipo_user) {
        this.tipo_user = tipo_user;
    }
    public Incidencia getInc1() {
        return inc1;
    }
    public void setInc1(Incidencia inc1) {
        this.inc1 = inc1;
    }
    public Incidencia getInc2() {
        return inc2;
    }
    public void setInc2(Incidencia inc2) {
        this.inc2 = inc2;
    }
    public Incidencia getInc3() {
        return inc3;
    }
    public void setInc3(Incidencia inc3) {
        this.inc3 = inc3;
    }

    @Override
    public String toString() {
        if (nombre.equals("")) {
            return "";
        } else {
            return
                    "-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n" +
                    "Posición: " + getAsignación() + "\n" +
                    "ID: " + cod_user + "\n" +
                    "Nombre: " + nombre + "\n" +
                    "Usuario: " + usuario + "\n" +
                    "Contraseña: " + contraseña + "\n" +
                    "-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_\n";
        }
    }

    //Asignamos las incidencias a los tecnicos, tendremos 2 funciones ya que solo pueden ser asignadas 2 incidencias por técnico
    public void Asig1(Incidencia incidencia, Usuario técnico, Usuario user1, Usuario user2) {
        técnico.setInc1(incidencia);
        System.out.println("Incidencia asignada al técnico " + técnico.getNombre() + " con identificador " + técnico.getCod_user());
        incidencia.setTécnico(técnico);
        if (incidencia.getCreador() == user1) {
            if (user1.getInc1() == incidencia) {
                user1.setInc1(new Incidencia());
            } else {
                if (user1.getInc2() == incidencia) {
                    user1.setInc2(new Incidencia());
                } else {
                    user1.setInc3(new Incidencia());
                }
            }
        } else {
            if (user2.getInc1() == incidencia) {
                user2.setInc1(new Incidencia());
            } else {
                if (user2.getInc2() == incidencia) {
                    user2.setInc2(new Incidencia());
                } else {
                    user2.setInc3(new Incidencia());
                }
            }
        }
    }

    public void Asig2(Incidencia incidencia, Usuario técnico, Usuario user1, Usuario user2) {
        técnico.setInc2(incidencia);
        System.out.println("Incidencia asignada al técnico " + técnico.getNombre() + " con identificador " + técnico.getCod_user());
        incidencia.setTécnico(técnico);
        if (incidencia.getCreador() == user1) {
            if (user1.getInc1() == incidencia) {
                user1.setInc1(new Incidencia());
            } else {
                if (user1.getInc2() == incidencia) {
                    user1.setInc2(new Incidencia());
                } else {
                    user1.setInc3(new Incidencia());
                }
            }
        } else {
            if (user2.getInc1() == incidencia) {
                user2.setInc1(new Incidencia());
            } else {
                if (user2.getInc2() == incidencia) {
                    user2.setInc2(new Incidencia());
                } else {
                    user2.setInc3(new Incidencia());
                }
            }
        }
    }
}