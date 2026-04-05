public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String sintoma;
    private String code;

    public Paciente (String nombre, String sintoma, String code){
        this.nombre = nombre;
        this.sintoma = sintoma;
        this.code = code;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSintoma() {
        return sintoma;
    }

    public String getCode() {
        return code;
    }

    @Override
    public int compareTo(Paciente otro){
        return this.code.compareTo(otro.code);
    }

    @Override
    public String toString(){
        return nombre + "," + sintoma + "," + code;
    }
}