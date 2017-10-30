package pe.edu.tecsup.database;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.edu.tecsup.database.dao.ProgramaDAO;
import pe.edu.tecsup.database.model.Programa;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramaDAOTests {

    @Autowired
    ProgramaDAO programaDAO;

   //@Test
    public void verifyList() {

        List<Programa> programas = programaDAO.list();
        for (Programa programa : programas) {
            System.out.println(programa.getId());
            System.out.println(programa.getNombre());
        }
        Assert.assertTrue(programas.size() > 0);
    }


   // @Test
    public void verifyFind() {
        
        Programa programa = programaDAO.get(2l);
        System.out.println(programa.getNombre());
        Assert.assertTrue(programa.getId() == 2l);
        
    }


    //@Test
    public void verifySave() {

        Programa programa = new Programa();
        programa.setCodigo("002");
        programa.setNombre("Cocina con Gaston");
        programa.setDescripcion("Ratuil");

        programaDAO.save(programa);
        Assert.assertTrue(programa.getId() != null);
    }

    
    //@Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Programa programa = new Programa();
        programa.setId(1l);
        programa.setCodigo("003");
        programa.setNombre("Programa Spring Tecsup");
        programa.setDescripcion("Programa Spring Tecsup");

        programaDAO.update(programa);
        Assert.assertTrue(programaDAO.get(1l).getCodigo().equals("003"));
    }

  
    @Test
    public void verifyDelete() {

        Programa programa = new Programa();
        programa.setId(2l);
        programaDAO.delete(programa);

        Assert.assertTrue(programaDAO.get(2l) == null);
    }

}
