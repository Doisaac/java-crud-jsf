package dois.webapp.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name="inscripciones")
public class Inscripciones implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "inscripciones_id_seq")
    @SequenceGenerator(name = "inscripciones_id_seq", sequenceName = "inscripciones_id_seq", allocationSize = 1)
    @Column(name="id")
    private Integer id;
    
    @ManyToOne
    @JoinColumn(name = "idusuario",nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "idmateria",nullable = false)
    private Materia materia;

    @Column(name="ciclo")
    private String ciclo;

    @Column(name="anio")
    private short anio;

    @Column(name="fechadeinscripcion")
    private Date fechadeinscripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }


    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public short getAnio() {
        return anio;
    }

    public void setAnio(short anio) {
        this.anio = anio;
    }

    public Date getFechadeinscripcion() {
        return fechadeinscripcion;
    }

    public void setFechadeinscripcion(Date fechadeinscripcion) {
        this.fechadeinscripcion = fechadeinscripcion;
    }

    @Override
    public String toString() {
        return "Inscripciones{" + "id=" + id + ", alumno=" + alumno + ", materia=" + materia + ", ciclo=" + ciclo + ", anio=" + anio + ", fechadeinscripcion=" + fechadeinscripcion + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Inscripciones other = (Inscripciones) obj;
        return Objects.equals(this.id, other.id);
    }
    
    public Inscripciones() {
        this.alumno = new Alumno();
        this.materia = new Materia();
    }
    
    public Inscripciones(Integer id) {
        this.id = id;
    }


    public Inscripciones(Integer id, Alumno alumno, Materia materia, String ciclo, short anio, Date fechadeinscripcion) {
        this.id = id;
        this.alumno = alumno;
        this.materia = materia;
        this.ciclo = ciclo;
        this.anio = anio;
        this.fechadeinscripcion = fechadeinscripcion;
    }

  
    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

}
