package dois.webapp.negocio;

import dois.webapp.entidades.Alumno;
import dois.webapp.entidades.Inscripciones;
import dois.webapp.entidades.Materia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.sql.Date;
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
    public Alumno findAlumnoById(Integer id) {
        return entityManager.find(Alumno.class, id);
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
    
    public List<Materia> getMaterias() {
        Query query = entityManager.createQuery("SELECT e FROM Materia e ORDER BY e.id DESC");
             
        List<Materia> materias = query.getResultList();
        return materias;   
    }
    
    public Materia findMateriaById(Integer id) {
        return entityManager.find(Materia.class, id);
    }
    
    @Transactional
    public void saveMateria(Materia materia) {
        entityManager.persist(materia);
    }
    
    @Transactional
    public void editMateria(Materia materia) {
        entityManager.merge(materia);
    }
    
    @Transactional
    public void deleteMateria(Materia materia) {
        Materia materiaAEliminar = entityManager.find(Materia.class, materia.getId());
        entityManager.remove(materiaAEliminar);
    }
    
    
    public List<Inscripciones> getInscripciones() {
        Query query = entityManager.createQuery("SELECT i FROM Inscripciones i ORDER BY i.id DESC");
             
        List<Inscripciones> inscripciones = query.getResultList();
        return inscripciones; 
    }
    
    @Transactional
    public void saveInscripcion(Inscripciones inscripcion) {
        if (inscripcion.getFechadeinscripcion() == null) {
            inscripcion.setFechadeinscripcion(new Date(System.currentTimeMillis()));
        }
        entityManager.persist(inscripcion);
    }
    
}