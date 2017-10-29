package pe.edu.tecsup.database;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.tecsup.database.model.Curso;
import pe.edu.tecsup.database.dao.CursoDAO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CursoDAOTests1 {

    @Autowired
    CursoDAO cursoDAO;

    @Test
    public void verifyList() {

        List<Curso> cursos = cursoDAO.list();
        for (Curso curso : cursos) {
            System.out.println(curso.getId());
            System.out.println(curso.getNombre());
        }
        Assert.assertTrue(cursos.size() > 0);
    }


    //@Test
    public void verifyFind() {
        
        Curso curso = cursoDAO.get(1l);
        System.out.println(curso.getNombre());
        Assert.assertTrue(curso.getId() == 1l);
        
    }

  
   // @Test
    public void verifySave() {

        Curso curso = new Curso();
        curso.setCodigo("1020");
        curso.setNombre("Nuevo Programa lidero TTttt");
        
        cursoDAO.save(curso);
        Assert.assertTrue(curso.getId() != null);
    }
  
    @Test
    public void verifyUpdate() {

        // cambiar el código para validar
        Curso curso = new Curso();
        curso.setId(16l);
        curso.setCodigo("28");
        curso.setNombre("Lidero.com....");

        cursoDAO.update(curso);
        Assert.assertTrue(cursoDAO.get(16l).getCodigo().equals("28"));
    }

  
 //   @Test
    /*
    public void verifyDelete() {

        Programa programa = new Programa();
        programa.setId(2l);
        programaDAO.delete(programa);

        Assert.assertTrue(programaDAO.get(2l) == null);
    }
*/
}
