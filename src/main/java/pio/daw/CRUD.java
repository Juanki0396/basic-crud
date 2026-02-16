package pio.daw;

public interface CRUD {
    void create(Cliente c) throws Exception;
    Cliente read(String dni) throws Exception;
    void update(Cliente c) throws Exception;
    void delete(Cliente c) throws Exception;
}
