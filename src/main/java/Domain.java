import bl.Utile;
import entity.Address;
import service.AddressService;

import java.sql.SQLException;

public class Domain {

    public static void main (String [] args) throws SQLException {
        Utile utile = new Utile();
        utile.getConnection();

        Address address = new Address();
        address.setId(1L);
        address.setCountry("Belarus");
        address.setCity("Minsk");
        address.setStreet("Avrorovskay");
        address.setPostCode("123456");

        AddressService addressService = new AddressService();
        addressService.create(address);
        addressService.getAll();

    }
}
