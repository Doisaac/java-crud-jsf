package dois.webapp.negocio;

import dois.webapp.entidades.Alumno;
import dois.webapp.entidades.Inscripciones;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

@Stateless
public class DataService {
    
    @PersistenceContext( unitName = "pu")
    EntityManager entityManager;
    
    public List<Alumno> getAlumnos() {
        Query query = entityManager.createQuery("SELECT e FROM Alumno e ORDER BY e.id DESC");
             
        List<Alumno> alumnos = query.getResultList();
        return alumnos;   
    }
    
    @Transactional
    public void saveAlumno(Alumno alumno) {
        entityManager.persist(alumno);
    }
    
    @Transactional
    public void editAlumno(Alumno alumno) {
        entityManager.merge(alumno);
    }
    
    @Transactional
    public void deleteAlumno(Alumno alumno) {
        Alumno alumnoAEliminar = entityManager.find(Alumno.class, alumno.getId());
        entityManager.remove(alumnoAEliminar);
    }
    
    public List<Inscripciones> getInscripciones() {
        Query query = entityManager.createQuery("SELECT i FROM Inscripciones i ORDER BY i.id DESC");
             
        List<Inscripciones> inscripciones = query.getResultList();
        return inscripciones; 
    }
    
    @Transactional
    public void saveInscripcion(Inscripciones inscripcion) {
        entityManager.persist(inscripcion);
    }
    
}
