import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        Clinica salud = new Clinica();

        try{
            Veterinario vet1 =
                    new Veterinario("Pepe", "1X", LocalDate.of(1969, 2, 16), 30);
            Veterinario vet2 =
                    new Veterinario("Ana", "2Y", LocalDate.of(1985, 5, 23), 15);
            Veterinario vet3 =
                    new Veterinario("Luis", "3Z", LocalDate.of(1978, 11, 30), 22);
            Veterinario vet4 = new Veterinario("Marta", "4W", LocalDate.of(1990, 8, 14), 10);
            Veterinario vet5 = new Veterinario("Carlos", "5V", LocalDate.of(1982, 3, 7), 18);
            Veterinario vet6 = new Veterinario("Laura", "6U", LocalDate.of(1975, 9, 25), 25);

            salud.setVeterinarios(new ArrayList<>(List.of(vet1, vet2, vet3, vet4, vet5, vet6)));

            Cliente cliente1 =
                    new Cliente("Lluvia", "99P",
                            new TreeSet<>(
                                    Set.of(new Gato("missi", LocalDate.of(2020, 5, 5), 4.5),
                                            new Perro("yaki", LocalDate.of(2020, 5, 5), "callejero"))));
            Cliente cliente2 = new Cliente("Juan", "10Q",
                    new TreeSet<>(
                            Set.of(new Perro("Max", LocalDate.of(2018, 3, 12), "Labrador"),
                                    new Gato("Luna", LocalDate.of(2019, 7, 20), 3.8))));

            Cliente cliente3 = new Cliente("Maria", "11R",
                    new TreeSet<>(
                            Set.of(new Gato("Simba", LocalDate.of(2017, 11, 3), 5.2),
                                    new Gato("Bobby", LocalDate.of(2016, 9, 15), 4.0))));

            Cliente cliente4 = new Cliente("Carlos", "12S",
                    new TreeSet<>(
                            Set.of(new Perro("Rocky", LocalDate.of(2015, 6, 25), "Pastor Alemán"),
                                    new Perro("Mimi", LocalDate.of(2014, 2, 8), "4.0"))));

            Cliente cliente5 = new Cliente("Ana", "T",
                    new TreeSet<>(
                            Set.of(
                                    new Perro("Charlie", LocalDate.of(2021, 4, 18), "Beagle"))));
            salud.setClientes(Set.of(cliente1,cliente2,cliente3,cliente4,cliente5));



        for(Cliente cliente:salud.getClientes()){
            System.out.println(cliente);
        }

        for(Cliente cliente:salud.getClientes()){
            for (Mascota mascota:cliente.getMascotas())
               System.out.println(cliente+" "+mascota);
        }

        List<Mascota> mascotas4 = new ArrayList<>(cliente4.getMascotas());
//        for (Mascota mascota:mascotas4){
//            mascotas4.remove(mascota);
//        }
//        System.out.println(mascotas4);

        Iterator<Mascota> iterator = mascotas4.iterator();
        while(iterator.hasNext()){
            Mascota m = iterator.next();
            iterator.remove();
        }

        System.out.println(mascotas4);

        List<Mascota> mascotas3 = new ArrayList<>(cliente3.getMascotas());
        mascotas3.get(0).vacunas.put("Trifásica",true);
        mascotas3.get(0).vacunas.put("Trivalente",true);
        mascotas3.get(0).vacunas.put("Rabia",true);
        System.out.println(mascotas3.get(0).vacunas.keySet());
        System.out.println(mascotas3.get(0).vacunas.values());

        for(String tipo:mascotas3.get(0).vacunas.keySet()){
            System.out.println(tipo + " -> " + mascotas3.get(0).vacunas.get(tipo));
        }

        for (Map.Entry<String,Boolean> conjuntoClaveValor: mascotas3.get(0).vacunas.entrySet()){
            System.out.println(conjuntoClaveValor.getKey() + " -> " + conjuntoClaveValor.getValue());
        }

        //guardar en fichero la lista de veterinarios
        try(BufferedWriter escritor = new BufferedWriter(new FileWriter("vets.csv"))){

            for(Veterinario veterinario: salud.getVeterinarios()){
                escritor.write(veterinario.getNombre()+";"+veterinario.getDNI()+
                        ";"+veterinario.getFechaNac()+";"+veterinario.getAnyosExperiencia());
                escritor.newLine();
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        List<Mascota> mascotas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("pets.csv"))){
            String linea;
            while((linea = br.readLine())!=null){
                String[] datos = linea.split(",");
                String[] fecha = datos[1].split("-");
                mascotas.add(new Perro(datos[0],
                        LocalDate.of(Integer.valueOf(fecha[0]),Integer.valueOf(fecha[1]),Integer.valueOf(fecha[2])),
                        "desconocido"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(mascotas);

        try(ObjectOutputStream outputStream
                    = new ObjectOutputStream(new FileOutputStream("mascotas.dat"))){

            outputStream.writeObject(mascotas);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for(Cliente cliente:salud.getClientes()){
            System.out.println(cliente.etiqueta());
        }


        } catch (ExcepcionDNI e){
            System.out.println(e.getMessage());
        }
    }



}
