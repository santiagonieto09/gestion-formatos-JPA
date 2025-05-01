-- Docentes
INSERT INTO `Docentes` (`idDocente`, `nombre_docente`, `apellidos_docente`, `nombre_grupo`, `correo`) VALUES (1, 'Juan', 'Perez', 'GIDATI', 'juan.perez@unicauca.edu.co');

INSERT INTO `Docentes` (`idDocente`, `nombre_docente`, `apellidos_docente`, `nombre_grupo`, `correo`) VALUES (2, 'Maria', 'Lopez', 'GIDATI', 'maria.lopez@unicauca.edu.co');

INSERT INTO `Docentes` (`idDocente`, `nombre_docente`, `apellidos_docente`, `nombre_grupo`, `correo`) VALUES (3, 'Carlos', 'Rodriguez', 'GIDATI', 'carlos.rodriguez@unicauca.edu.co');

-- Roles
INSERT INTO `Roles` (`idRol`, `rol_asignado`)  VALUES (1, 'Director');

INSERT INTO `Roles` (`idRol`, `rol_asignado`) VALUES (2, 'Coordinador');

INSERT INTO `Roles` (`idRol`, `rol_asignado`) VALUES (3, 'Evaluador');

-- Historicos
INSERT INTO `Historicos` (`idHistoricos`, `idDocente`, `idRol`, `activo`, `fechaInicio`, `fechaFin`) VALUES (1, 1, 1, 1, '2023-01-01', NULL);

INSERT INTO `Historicos` (`idHistoricos`, `idDocente`, `idRol`, `activo`, `fechaInicio`, `fechaFin`) VALUES (2, 2, 2, 1, '2023-01-01', NULL);

INSERT INTO `Historicos` (`idHistoricos`, `idDocente`, `idRol`, `activo`, `fechaInicio`, `fechaFin`) VALUES (3, 3, 3, 2, '2023-01-01', '2024-01-01');

-- FormatosA
INSERT INTO `FormatosA` (`idFormatoA`, `objetivo_general`, `objetivos_especificos`, `titulo`, `idDocente`, `fecha_creacion`) VALUES (1, 'Desarrollar una aplicacion web para la gestion de formatos de propuestas de trabajo de grado', '1. Disenar la arquitectura de la aplicacion\n2. Implementar la interfaz de usuario\n3. Desarrollar la logica de negocio', 'Sistema de Gestion de Formatos de Propuestas de Trabajo de Grado', 1, '2022-04-01 10:00:00');

-- Estados
INSERT INTO `Estados` (`idFormatoA`, `estado_actual`, `fecha_registro_estado`) VALUES (1, 'En formulacion', '2023-04-01');

-- FormatosPPA
INSERT INTO `FormatosPPA` (`idFormatoA`, `nombre_asesor`, `nombre_estudiante1`, `ruta_carta_aceptacion`) VALUES (1, 'Maria Lopez', 'Carlos Rodriguez', '/documentos/carta_aceptacion.pdf');

-- Evaluaciones
INSERT INTO `Evaluaciones` (`idEvaluacion`, `concepto`, `fecha_registro_concepto`, `nombre_coordinador`, `idFormatoA`) VALUES (1, 'Por corregir', '2023-04-15', 'Coordinador de Posgrados', 1);

-- Observaciones
INSERT INTO `Observaciones` (`idObservacion`, `observacion`, `fecha_registro_observacion`, `idEvaluacion`) VALUES (1, 'Se requiere mejorar la redaccion del objetivo general', '2023-04-16', 1);

INSERT INTO `Observaciones` (`idObservacion`, `observacion`, `fecha_registro_observacion`, `idEvaluacion`) VALUES (2, 'Agregar mas detalles sobre la metodologia a utilizar', '2023-04-16', 1);

-- Observacion_Docentes
INSERT INTO `observacion_docentes` (`idObservacion`, `idDocente`) VALUES (1, 2);
INSERT INTO `observacion_docentes` (`idObservacion`, `idDocente`) VALUES (1, 3);
INSERT INTO `observacion_docentes` (`idObservacion`, `idDocente`) VALUES (2, 2);