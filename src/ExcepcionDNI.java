public class ExcepcionDNI extends Exception{
    private String persona;
    public ExcepcionDNI(String persona){
        super();
        System.out.println(persona);
    }

}
