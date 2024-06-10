package dois.webapp.controladores;

import dois.webapp.entidades.Alumno;
import dois.webapp.entidades.Inscripciones;
import dois.webapp.entidades.Materia;
import dois.webapp.negocio.DataService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Doisaac
 */
@Named
@RequestScoped
public class IndexController {

    private List<Alumno> alumnosList = new ArrayList<>();
    private Alumno alumno = new Alumno();
    private List<Materia> materiasList = new ArrayList<>();
    private Materia materia = new Materia();
    private Inscripciones inscripciones = new Inscripciones();
    private List<Inscripciones> inscripcionesList = new ArrayList<>();

    @EJB
    private DataService servicio;

    @PostConstruct
    public void init() {
        cargarAlumnos();
        cargarMaterias();
        cargarInscripciones();
    }

    public void cargarAlumnos() {
        alumnosList = servicio.getAlumnos();
    }

    public void guardarAlumno() {
        if (alumno.getId() != null) {
            servicio.editAlumno(alumno);
        } else {
            servicio.saveAlumno(alumno);
        }
        alumno = new Alumno();
        cargarAlumnos();
    }

    public void llenarFormEditar(Alumno alumno) {
        this.alumno = alumno;
    }

    public void eliminarAlumno(Alumno alumno) {
        servicio.deleteAlumno(alumno);
        cargarAlumnos();
    }

    public void cargarMaterias() {
        materiasList = servicio.getMaterias();
    }

    public void guardarMateria() {
        if (materia.getId() != null) {
            servicio.editMateria(materia);
        } else {
            servicio.saveMateria(materia);
        }
        materia = new Materia();
        cargarMaterias();
    }

    public void llenarFormEditar(Materia materia) {
        this.materia = materia;
    }

    public void eliminarMateria(Materia materia) {
        servicio.deleteMateria(materia);
        cargarMaterias();
    }

    /* GETTERS AND SETTERS*/
    public List<Alumno> getAlumnosList() {
        return alumnosList;
    }

    public void setAlumnosList(List<Alumno> alumnosList) {
        this.alumnosList = alumnosList;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public List<Materia> getMateriasList() {
        return materiasList;
    }

    public void setMateriasList(List<Materia> materiasList) {
        this.materiasList = materiasList;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Materia getMateria() {
        return materia;
    }

    /* INSCRIPCIONES */
    public void cargarInscripciones() {
        inscripcionesList = servicio.getInscripciones();
    }

    public List<Inscripciones> getInscripcionesList() {
        return inscripcionesList;
    }

    public Inscripciones getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(Inscripciones inscripciones) {
        this.inscripciones = inscripciones;
    }

    public void guardarInscripcion() {
        servicio.saveInscripcion(inscripciones);
        
        inscripciones = new Inscripciones();
        
        cargarInscripciones();
    }
    
    

}
