package co.edu.unicauca.asae.ejemplo_relaciones_jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.entidades.DocenteEntity;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.DocentesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.EstadosRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.EvaluacionesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.FormatosARepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.FormatosPPARepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.FormatosTIARepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.HistoricosRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.ObservacionesRepository;
import co.edu.unicauca.asae.ejemplo_relaciones_jpa.infraestructura.output.persistencia.repositorios.RolesRepository;

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
		DocenteEntity docenteEntity = new DocenteEntity();
		docenteEntity.setNombreDocente("Juan");
		docenteEntity.setApellidosDocente("Pérez");
		docenteEntity.setNombreGrupo("GIDATI");
		docenteEntity.setCorreo("juan.perez@unicauca.edu.co");
		
		// Verificar si el docente ya existe por correo
		List<DocenteEntity> docentesExistentes = servicioBDDocentes.findAll();
		boolean docenteExiste = false;
		
		for (DocenteEntity d : docentesExistentes) {
			if (d.getCorreo().equals(docenteEntity.getCorreo())) {
				docenteEntity = d;
				docenteExiste = true;
				break;
			}
		}
		
		// Si el docente no existe, guardarlo
		if (!docenteExiste) {
			servicioBDDocentes.save(docenteEntity);
		}
		
		// Crear un FormatoPPA
		FormatoPPAEntity formatoPPA = new FormatoPPAEntity();
		formatoPPA.setNombreDirector("Santiago Nieto");
		formatoPPA.setObjetivoGeneral("Desarrollar una aplicación web para la gestión de formatos de propuestas de trabajo de grado");
		formatoPPA.setObjetivosEspecificos("1. Diseñar la arquitectura de la aplicación\n2. Implementar la interfaz de usuario\n3. Desarrollar la lógica de negocio");
		formatoPPA.setTitulo("Sistema de Gestión de Formatos de Propuestas de Trabajo de Grado");
		formatoPPA.setDocenteEntity(docenteEntity);
		formatoPPA.setNombreAsesor("María López");
		formatoPPA.setNombreEstudiante1("Jeferson Castaño");
		formatoPPA.setRutaCartaAceptacion("/documentos/carta_aceptacion.pdf");
		
		// Crear el estado inicial
		EstadoEntity estadoEntity = new EstadoEntity();
		estadoEntity.setEstadoActual("En formulación");
		estadoEntity.setFechaRegistroEstado(new Date());
		
		// Establecer la relacion bidireccional
		formatoPPA.setEstadoEntity(estadoEntity);
		estadoEntity.setFormatoAEntity(formatoPPA);
		
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
		List<FormatoAEntity> formatosA = servicioBDFormatosA.findAll();
		if (formatosA.isEmpty()) {
			System.out.println("No hay formatos A disponibles. Primero debe crear un formato A.");
			return;
		}
		
		FormatoAEntity formatoAEntity = formatosA.get(0);
		
		// Verificar si el formato A tiene evaluaciones
		List<EvaluacionEntity> evaluaciones = servicioBDEvaluaciones.findAll();
		EvaluacionEntity evaluacionEntity = null;
		
		// Buscar la última evaluación asociada al formato A
		for (EvaluacionEntity e : evaluaciones) {
			if (e.getFormatoAEntity().getIdFormatoA().equals(formatoAEntity.getIdFormatoA())) {
				if (e.getConcepto().equals("Por corregir")) {
					evaluacionEntity = e;
					break;
				}
			}
		}
		
		// Si no hay evaluacion o no hay una en estado "Por corregir", crear una nueva
		if (evaluacionEntity == null) {
			evaluacionEntity = new EvaluacionEntity();
			evaluacionEntity.setConcepto(""); // Sin concepto por establecer
			evaluacionEntity.setFechaRegistroConcepto(new Date());
			evaluacionEntity.setNombreCoordinador("Coordinador de Posgrados");
			evaluacionEntity.setFormatoAEntity(formatoAEntity);
			servicioBDEvaluaciones.save(evaluacionEntity);
		}
		
		// Obtener docentes existentes
		List<DocenteEntity> docenteEntities = servicioBDDocentes.findAll();
		if (docenteEntities.isEmpty()) {
			System.out.println("No hay docentes disponibles. Primero debe crear un docente.");
			return;
		}
		
		// Crear lista de IDs de docentes
		List<Integer> idsDocentes = new ArrayList<>();
		for (DocenteEntity docenteEntity : docenteEntities) {
			idsDocentes.add(docenteEntity.getIdDocente());
		}
		
		// Crear la observacion
		ObservacionEntity observacionEntity = new ObservacionEntity();
		observacionEntity.setObservacion("Se requiere mejorar la redacción del objetivo general");
		observacionEntity.setFechaRegistro(new Date());
		observacionEntity.setIdsDocentes(idsDocentes); // Asignar la lista de IDs de docentes
		
		// Obtener referencias usando getReferenceById
		EvaluacionEntity evaluacionEntityRef = servicioBDEvaluaciones.getReferenceById(evaluacionEntity.getIdEvaluacion());
		
		// Asociar la observacion con la evaluacion
		observacionEntity.setEvaluacionEntity(evaluacionEntityRef);
		
		// Guardar la observacion
		servicioBDObservaciones.save(observacionEntity);
		
		System.out.println("Observacion creada con éxito. ID: " + observacionEntity.getIdObservacion());
	}

	/**
	 * (v 1.0) Listar observaciones. Este método debe mostrar los datos de un formato A, su estado, 
	 * su evaluación, las observaciones asociadas a la evaluación y el docente que las ha planteado. 
	 * Utilice el ligado eager para traer la evaluación y el docente.
	 */
	@Transactional(readOnly = true)
	public void listarObservaciones() {
		// Obtener todos los formatos A con sus relaciones
		List<FormatoAEntity> formatosA = servicioBDFormatosA.findAll();
		
		if (formatosA.isEmpty()) {
			System.out.println("No hay formatos A disponibles.");
			return;
		}
		
		// Mostrar información de cada formato A
		for (FormatoAEntity formatoAEntity : formatosA) {
			System.out.println("=== FORMATO A ===");
			System.out.println("ID: " + formatoAEntity.getIdFormatoA());
			System.out.println("Título: " + formatoAEntity.getTitulo());
			System.out.println("Director: " + formatoAEntity.getNombreDirector());
			
			// Mostrar estado
			EstadoEntity estadoEntity = formatoAEntity.getEstadoEntity();
			if (estadoEntity != null) {
				System.out.println("=== ESTADO ===");
				System.out.println("Estado actual: " + estadoEntity.getEstadoActual());
				System.out.println("Fecha registro: " + estadoEntity.getFechaRegistroEstado());
			} else {
				System.out.println("El formato no tiene estado registrado.");
			}
			
			// Obtener evaluaciones directamente del formato A
			List<EvaluacionEntity> evaluaciones = formatoAEntity.getListaEvaluaciones();
			if (evaluaciones != null && !evaluaciones.isEmpty()) {
				for (EvaluacionEntity evaluacionEntity : evaluaciones) {
					System.out.println("=== EVALUACIÓN ===");
					System.out.println("ID: " + evaluacionEntity.getIdEvaluacion());
					System.out.println("Concepto: " + evaluacionEntity.getConcepto());
					System.out.println("Fecha registro: " + evaluacionEntity.getFechaRegistroConcepto());
					System.out.println("Coordinador: " + evaluacionEntity.getNombreCoordinador());
					
					// Mostrar observaciones de la evaluacion
					List<ObservacionEntity> observaciones = evaluacionEntity.getListaObservaciones();
					if (observaciones != null && !observaciones.isEmpty()) {
						System.out.println("=== OBSERVACIONES ===");
						for (ObservacionEntity observacionEntity : observaciones) {
							System.out.println("ID: " + observacionEntity.getIdObservacion());
							System.out.println("Observación: " + observacionEntity.getObservacion());
							System.out.println("Fecha registro: " + observacionEntity.getFechaRegistro());
							
							// Mostrar docentes que plantearon la observacion
							List<Integer> idsDocentes = observacionEntity.getIdsDocentes();
							if (idsDocentes != null && !idsDocentes.isEmpty()) {
								System.out.println("Docentes que plantearon la observación:");
								for (Integer idDocente : idsDocentes) {
									DocenteEntity docenteEntity = servicioBDDocentes.getReferenceById(idDocente);
									System.out.println("- " + docenteEntity.getNombreDocente() + " " + docenteEntity.getApellidosDocente());
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
		List<HistoricoEntity> historicoEntities = servicioBDHistoricos.findAll();
		
		if (historicoEntities.isEmpty()) {
			System.out.println("No hay miembros del comité registrados.");
			return;
		}
		
		// Mostrar informacion de cada miembro del comite
		for (HistoricoEntity historicoEntity : historicoEntities) {
			DocenteEntity docenteEntity = historicoEntity.getDocenteEntity();
			RolEntity rolEntity = historicoEntity.getRolEntity();
			
			System.out.println("=== MIEMBRO DEL COMITÉ ===");
			System.out.println("Docente: " + docenteEntity.getNombreDocente() + " " + docenteEntity.getApellidosDocente());
			System.out.println("Rol: " + rolEntity.getRolAsignado());
			System.out.println("Fecha inicio: " + historicoEntity.getFechaInicio());
			
			if (historicoEntity.getFechaFin() != null) {
				System.out.println("Fecha fin: " + historicoEntity.getFechaFin());
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
		List<DocenteEntity> docenteEntities = servicioBDDocentes.findAll();
		
		if (docenteEntities.isEmpty()) {
			System.out.println("No hay docentes disponibles.");
			return;
		}
		
		// Mostrar formatos A de cada docente
		for (DocenteEntity docenteEntity : docenteEntities) {
			System.out.println("=== DOCENTE ===");
			System.out.println("Nombre: " + docenteEntity.getNombreDocente() + " " + docenteEntity.getApellidosDocente());
			System.out.println("Correo: " + docenteEntity.getCorreo());
			
			// Obtener formatos A del docente
			List<FormatoAEntity> formatosA = servicioBDFormatosA.findAll();
			boolean tieneFormatos = false;
			
			for (FormatoAEntity formatoAEntity : formatosA) {
				if (formatoAEntity.getDocenteEntity().getIdDocente().equals(docenteEntity.getIdDocente())) {
					tieneFormatos = true;
					System.out.println("\n=== FORMATO A ===");
					System.out.println("ID: " + formatoAEntity.getIdFormatoA());
					System.out.println("Título: " + formatoAEntity.getTitulo());
					
					// Mostrar evaluacion (lazy loading)
					if (formatoAEntity.getListaEvaluaciones() != null && !formatoAEntity.getListaEvaluaciones().isEmpty()) {
						System.out.println("\n=== EVALUACION ===");
						for (EvaluacionEntity evaluacionEntity : formatoAEntity.getListaEvaluaciones()) {
							System.out.println("Concepto: " + evaluacionEntity.getConcepto());
							System.out.println("Fecha: " + evaluacionEntity.getFechaRegistroConcepto());
							System.out.println("Coordinador: " + evaluacionEntity.getNombreCoordinador());
							
							// Mostrar observaciones (lazy loading)
							if (evaluacionEntity.getListaObservaciones() != null && !evaluacionEntity.getListaObservaciones().isEmpty()) {
								System.out.println("\n=== OBSERVACIONES ===");
								for (ObservacionEntity observacionEntity : evaluacionEntity.getListaObservaciones()) {
									System.out.println("Observacion: " + observacionEntity.getObservacion());
									System.out.println("Fecha: " + observacionEntity.getFechaRegistro());
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
