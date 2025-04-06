package co.edu.unicauca.asae.ejemplo_relaciones_jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Docente;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Estado;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Evaluacion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.FormatoA;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.FormatoPPA;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Historico;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Observacion;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.models.Rol;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.DocentesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.EstadosRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.EvaluacionesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.FormatosARepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.FormatosPPARepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.FormatosTIARepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.HistoricosRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.ObservacionesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.repositories.RolesRepository;

@SpringBootApplication
@Transactional
public class EjemploRelacionesJpaApplication implements CommandLineRunner {

	@Autowired
	private DocentesRepository servicioBDDocentes;

	@Autowired
	private EstadosRepository servicioBDEstados;

	@Autowired
	private EvaluacionesRepository servicioBDEvaluaciones;

	@Autowired
	private ObservacionesRepository servicioBDObservaciones;

	@Autowired
	private HistoricosRepository servicioBDHistoricos;

	@Autowired
	private RolesRepository servicioBDRoles;

	@Autowired
	private FormatosARepository servicioBDFormatosA;

	@Autowired
	private FormatosPPARepository servicioBDFormatosPPA;

	@Autowired
	private FormatosTIARepository servicioBDFormatosTIA;

	public static void main(String[] args) {
		SpringApplication.run(EjemploRelacionesJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Descomentar el metodo que desea ejecutar

		//crearFormatoA();
		//crearObservacion();
		//listarObservaciones();
		//listarMiembrosComite();
		consultarFormatosAPorDocente();
	}

	/**
	 * (v 1.0) Crear formato A. Este método debe crear un formatoA (ya sea formatoTI-A o formatoPP-A), 
	 * su estado y su relación con el docente director. Utilice la acción en cascada persist para que al 
	 * almacenar el formato A se almacenen en cascada docente y estado. Se debe registrar automáticamente 
	 * un estado inicial de "En formulación" y la fecha de registro de ese estado. Considere el siguiente 
	 * caso: Si un docente director ya está registrado, no se debe crear, solo se debe asociar.
	 */
	@Transactional
	public void crearFormatoA() {
		// Crear un docente si no existe
		Docente docente = new Docente();
		docente.setNombreDocente("Juan");
		docente.setApellidosDocente("Pérez");
		docente.setNombreGrupo("GIDATI");
		docente.setCorreo("juan.perez@unicauca.edu.co");
		
		// Verificar si el docente ya existe por correo
		List<Docente> docentesExistentes = servicioBDDocentes.findAll();
		boolean docenteExiste = false;
		
		for (Docente d : docentesExistentes) {
			if (d.getCorreo().equals(docente.getCorreo())) {
				docente = d;
				docenteExiste = true;
				break;
			}
		}
		
		// Si el docente no existe, guardarlo
		if (!docenteExiste) {
			servicioBDDocentes.save(docente);
		}
		
		// Crear un FormatoPPA
		FormatoPPA formatoPPA = new FormatoPPA();
		formatoPPA.setNombreDirector("Santiago Nieto");
		formatoPPA.setObjetivoGeneral("Desarrollar una aplicación web para la gestión de formatos de propuestas de trabajo de grado");
		formatoPPA.setObjetivosEspecificos("1. Diseñar la arquitectura de la aplicación\n2. Implementar la interfaz de usuario\n3. Desarrollar la lógica de negocio");
		formatoPPA.setTitulo("Sistema de Gestión de Formatos de Propuestas de Trabajo de Grado");
		formatoPPA.setDocente(docente);
		formatoPPA.setNombreAsesor("María López");
		formatoPPA.setNombreEstudiante1("Jeferson Castaño");
		formatoPPA.setRutaCartaAceptacion("/documentos/carta_aceptacion.pdf");
		
		// Crear el estado inicial
		Estado estado = new Estado();
		estado.setEstadoActual("En formulación");
		estado.setFechaRegistroEstado(new Date());
		
		// Establecer la relacion bidireccional
		formatoPPA.setEstado(estado);
		estado.setFormatoA(formatoPPA);
		
		// Guardar solo el formatoPPA, la cascada persist se encarga del resto
		servicioBDFormatosPPA.save(formatoPPA);
		
		System.out.println("Formato PP-A creado con éxito. ID: " + formatoPPA.getIdFormatoA());
	}

	/**
	 * (v 1.0) Crear observación. Este método permite crear una observación y asociarla a una evaluación 
	 * y un docente, y posteriormente debe almacenar la observación. Se parte de que los docentes ya están 
	 * creados. Al registrar una observación se debe establecer en una lista los ID de los docentes que la 
	 * establecen y el id del formato A al cual va a ir asociada. Internamente se debe registrar la observación 
	 * y obtener una referencia a los docentes mediante el método getReferenceById del repositorio de docentes 
	 * y obtener una referencia a la evaluación mediante el método getReferenceById del repositorio de evaluación.
	 * 
	 * Nota: Cuando se registra un formato A, el no tiene evaluaciones. Considere los siguientes dos casos: 
	 * si un formato A no tiene una evaluación se debe crear una sin concepto aun por establecer; si un formato A 
	 * tiene una evaluación, se debe obtener la última evaluación registrada, la cual debe estar en concepto "Por corregir".
	 */
	@Transactional
	public void crearObservacion() {
		// Obtener un formato A existente
		List<FormatoA> formatosA = servicioBDFormatosA.findAll();
		if (formatosA.isEmpty()) {
			System.out.println("No hay formatos A disponibles. Primero debe crear un formato A.");
			return;
		}
		
		FormatoA formatoA = formatosA.get(0);
		
		// Verificar si el formato A tiene evaluaciones
		List<Evaluacion> evaluaciones = servicioBDEvaluaciones.findAll();
		Evaluacion evaluacion = null;
		
		// Buscar la última evaluación asociada al formato A
		for (Evaluacion e : evaluaciones) {
			if (e.getFormatoA().getIdFormatoA().equals(formatoA.getIdFormatoA())) {
				if (e.getConcepto().equals("Por corregir")) {
					evaluacion = e;
					break;
				}
			}
		}
		
		// Si no hay evaluacion o no hay una en estado "Por corregir", crear una nueva
		if (evaluacion == null) {
			evaluacion = new Evaluacion();
			evaluacion.setConcepto(""); // Sin concepto por establecer
			evaluacion.setFechaRegistroConcepto(new Date());
			evaluacion.setNombreCoordinador("Coordinador de Posgrados");
			evaluacion.setFormatoA(formatoA);
			servicioBDEvaluaciones.save(evaluacion);
		}
		
		// Obtener docentes existentes
		List<Docente> docentes = servicioBDDocentes.findAll();
		if (docentes.isEmpty()) {
			System.out.println("No hay docentes disponibles. Primero debe crear un docente.");
			return;
		}
		
		// Crear lista de IDs de docentes
		List<Integer> idsDocentes = new ArrayList<>();
		for (Docente docente : docentes) {
			idsDocentes.add(docente.getIdDocente());
		}
		
		// Crear la observacion
		Observacion observacion = new Observacion();
		observacion.setObservacion("Se requiere mejorar la redacción del objetivo general");
		observacion.setFechaRegistro(new Date());
		observacion.setIdsDocentes(idsDocentes); // Asignar la lista de IDs de docentes
		
		// Obtener referencias usando getReferenceById
		Evaluacion evaluacionRef = servicioBDEvaluaciones.getReferenceById(evaluacion.getIdEvaluacion());
		
		// Asociar la observacion con la evaluacion
		observacion.setEvaluacion(evaluacionRef);
		
		// Guardar la observacion
		servicioBDObservaciones.save(observacion);
		
		System.out.println("Observacion creada con éxito. ID: " + observacion.getIdObservacion());
	}

	/**
	 * (v 1.0) Listar observaciones. Este método debe mostrar los datos de un formato A, su estado, 
	 * su evaluación, las observaciones asociadas a la evaluación y el docente que las ha planteado. 
	 * Utilice el ligado eager para traer la evaluación y el docente.
	 */
	@Transactional(readOnly = true)
	public void listarObservaciones() {
		// Obtener todos los formatos A con sus relaciones
		List<FormatoA> formatosA = servicioBDFormatosA.findAll();
		
		if (formatosA.isEmpty()) {
			System.out.println("No hay formatos A disponibles.");
			return;
		}
		
		// Mostrar información de cada formato A
		for (FormatoA formatoA : formatosA) {
			System.out.println("=== FORMATO A ===");
			System.out.println("ID: " + formatoA.getIdFormatoA());
			System.out.println("Título: " + formatoA.getTitulo());
			System.out.println("Director: " + formatoA.getNombreDirector());
			
			// Mostrar estado
			Estado estado = formatoA.getEstado();
			if (estado != null) {
				System.out.println("=== ESTADO ===");
				System.out.println("Estado actual: " + estado.getEstadoActual());
				System.out.println("Fecha registro: " + estado.getFechaRegistroEstado());
			} else {
				System.out.println("El formato no tiene estado registrado.");
			}
			
			// Obtener evaluaciones directamente del formato A
			List<Evaluacion> evaluaciones = formatoA.getListaEvaluaciones();
			if (evaluaciones != null && !evaluaciones.isEmpty()) {
				for (Evaluacion evaluacion : evaluaciones) {
					System.out.println("=== EVALUACIÓN ===");
					System.out.println("ID: " + evaluacion.getIdEvaluacion());
					System.out.println("Concepto: " + evaluacion.getConcepto());
					System.out.println("Fecha registro: " + evaluacion.getFechaRegistroConcepto());
					System.out.println("Coordinador: " + evaluacion.getNombreCoordinador());
					
					// Mostrar observaciones de la evaluacion
					List<Observacion> observaciones = evaluacion.getListaObservaciones();
					if (observaciones != null && !observaciones.isEmpty()) {
						System.out.println("=== OBSERVACIONES ===");
						for (Observacion observacion : observaciones) {
							System.out.println("ID: " + observacion.getIdObservacion());
							System.out.println("Observación: " + observacion.getObservacion());
							System.out.println("Fecha registro: " + observacion.getFechaRegistro());
							
							// Mostrar docentes que plantearon la observacion
							List<Integer> idsDocentes = observacion.getIdsDocentes();
							if (idsDocentes != null && !idsDocentes.isEmpty()) {
								System.out.println("Docentes que plantearon la observación:");
								for (Integer idDocente : idsDocentes) {
									Docente docente = servicioBDDocentes.getReferenceById(idDocente);
									System.out.println("- " + docente.getNombreDocente() + " " + docente.getApellidosDocente());
								}
							}
						}
					} else {
						System.out.println("La evaluación no tiene observaciones.");
					}
				}
			} else {
				System.out.println("El formato no tiene evaluaciones registradas.");
			}
			
			System.out.println("=====================");
		}
	}

	/**
	 * (v 1.0) Listar miembros del comité. Este método debe mostrar los docentes miembros del comité 
	 * su rol y la fecha de inicio y fecha final del registro del rol. Utilice el ligado lazy para traer los roles.
	 */
	@Transactional(readOnly = true)
	public void listarMiembrosComite() {
		// Obtener todos los historicos
		List<Historico> historicos = servicioBDHistoricos.findAll();
		
		if (historicos.isEmpty()) {
			System.out.println("No hay miembros del comité registrados.");
			return;
		}
		
		// Mostrar informacion de cada miembro del comite
		for (Historico historico : historicos) {
			Docente docente = historico.getDocente();
			Rol rol = historico.getRol();
			
			System.out.println("=== MIEMBRO DEL COMITÉ ===");
			System.out.println("Docente: " + docente.getNombreDocente() + " " + docente.getApellidosDocente());
			System.out.println("Rol: " + rol.getRolAsignado());
			System.out.println("Fecha inicio: " + historico.getFechaInicio());
			
			if (historico.getFechaFin() != null) {
				System.out.println("Fecha fin: " + historico.getFechaFin());
			} else {
				System.out.println("Fecha fin: Sin fecha de fin registrada");
			}
			System.out.println("=====================");
		}
	}

	/**
	 * (v 1.0) Consultar formatos A por docente. Este método debe mostrar los formatos A de un docente. 
	 * Por cada formato A se debe mostrar el docente, evaluación, y observaciones asociadas. 
	 * Utilice el ligado eager para traer los formatos A. Utilice el ligado lazy para traer la evaluación.
	 */
	@Transactional(readOnly = true)
	public void consultarFormatosAPorDocente() {
		// Obtener todos los docentes
		List<Docente> docentes = servicioBDDocentes.findAll();
		
		if (docentes.isEmpty()) {
			System.out.println("No hay docentes disponibles.");
			return;
		}
		
		// Mostrar formatos A de cada docente
		for (Docente docente : docentes) {
			System.out.println("=== DOCENTE ===");
			System.out.println("Nombre: " + docente.getNombreDocente() + " " + docente.getApellidosDocente());
			System.out.println("Correo: " + docente.getCorreo());
			
			// Obtener formatos A del docente
			List<FormatoA> formatosA = servicioBDFormatosA.findAll();
			boolean tieneFormatos = false;
			
			for (FormatoA formatoA : formatosA) {
				if (formatoA.getDocente().getIdDocente().equals(docente.getIdDocente())) {
					tieneFormatos = true;
					System.out.println("\n=== FORMATO A ===");
					System.out.println("ID: " + formatoA.getIdFormatoA());
					System.out.println("Título: " + formatoA.getTitulo());
					
					// Mostrar evaluacion (lazy loading)
					if (formatoA.getListaEvaluaciones() != null && !formatoA.getListaEvaluaciones().isEmpty()) {
						System.out.println("\n=== EVALUACION ===");
						for (Evaluacion evaluacion : formatoA.getListaEvaluaciones()) {
							System.out.println("Concepto: " + evaluacion.getConcepto());
							System.out.println("Fecha: " + evaluacion.getFechaRegistroConcepto());
							System.out.println("Coordinador: " + evaluacion.getNombreCoordinador());
							
							// Mostrar observaciones (lazy loading)
							if (evaluacion.getListaObservaciones() != null && !evaluacion.getListaObservaciones().isEmpty()) {
								System.out.println("\n=== OBSERVACIONES ===");
								for (Observacion observacion : evaluacion.getListaObservaciones()) {
									System.out.println("Observacion: " + observacion.getObservacion());
									System.out.println("Fecha: " + observacion.getFechaRegistro());
								}
							}
						}
					}
				}
			}
			
			if (!tieneFormatos) {
				System.out.println("Este docente no tiene formatos A registrados.");
			}
			System.out.println("=====================");
		}
	}
}
