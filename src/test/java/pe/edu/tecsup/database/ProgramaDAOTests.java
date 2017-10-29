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

    @Test
    public void verifyList() {

        List<Programa> programas = programaDAO.list();
        for (Programa programa : programas) {
            System.out.println(programa.getId());
            System.out.println(programa.getNombre());
        }
        Assert.assertTrue(programas.size() > 0);
    }

/*
    @Test
    public void verifyFind() {
        
        Programa programa = programaDAO.get(1);
        System.out.println(programa.getNombre());
        Assert.assertTrue(programa.getId() == 1);
        
    }
*/
/*    
    @Test
    public void verifySave() {

        Programa programa = new Programa();
        programa.setCodigo("1020");
        programa.setNombre("Nuevo Programa lidero");
        programa.setDescripcion("......");

        programaDAO.save(programa);
        Assert.assertTrue(programa.getId() != null);
    }
*/
    
    @Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Programa programa = new Programa();
        programa.setId(16l);
        programa.setCodigo("28");
        programa.setNombre("Programa Lidero.com....");

        programaDAO.update(programa);
        Assert.assertTrue(programaDAO.get(16l).getCodigo().equals("28"));
    }

  
    @Test
    public void verifyDelete() {

        Programa programa = new Programa();
        programa.setId(2l);
        programaDAO.delete(programa);

        Assert.assertTrue(programaDAO.get(2l) == null);
    }

}
