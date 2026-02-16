package pio.daw;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ClienteManager implements CRUD {
    private Path filePath;


    public ClienteManager(Path filePath){
        this.filePath = filePath;
    }

    public void create(Cliente c) throws Exception{
        List<String> lines = Files.readAllLines(this.filePath);
        for(String line : lines){
            Cliente a = new Cliente(line);
            if(a.compareTo(c)){
                return;
            }
        }
        lines.add(c.toString());
        Files.write(filePath, lines);
    }

    public Cliente read(String dni) throws Exception{
        List<String> lines = Files.readAllLines(this.filePath);
        for(String line : lines){
            Cliente a = new Cliente(line);
            if(a.getDNI().equals(dni)){
                return a;
            }
        }
        return null;
    }

    public List<Cliente> readAll() throws Exception{
        List<String> lines = Files.readAllLines(this.filePath);
        List<Cliente> clientes = new ArrayList<>();
        for(String line : lines){
            clientes.add(new Cliente(line));
        }
        return clientes;
    }

    public void update(Cliente c) throws Exception{
        List<String> lines = Files.readAllLines(this.filePath);
        Integer idxCliente = -1;
        for(String line : lines){
            Cliente a = new Cliente(line);
            if(a.getDNI().equals(c.getDNI())){
                idxCliente = lines.indexOf(line);
                break;
            }
        }
        if(idxCliente == -1){
            return;
        }
        lines.set(idxCliente, c.toString());
        Files.write(filePath, lines);
    }

    public void delete(Cliente c) throws Exception{
        List<String> lines = Files.readAllLines(this.filePath);
        Integer idxCliente = -1;
        for(String line : lines){
            Cliente a = new Cliente(line);
            if(a.compareTo(c)){
                idxCliente = lines.indexOf(line);
                break;
            }
        }
        if(idxCliente == -1){
            return;
        }
        lines.remove(idxCliente);
        Files.write(filePath, lines);
    }
}
