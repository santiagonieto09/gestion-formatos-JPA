
-- Docentes
INSERT INTO `Docentes` (`idDocente`, `nombre_docente`, `apellidos_docente`, `nombre_grupo`, `correo`) 
VALUES (10, 'Juan', 'Robles', 'GIDATI', 'juan.robles@unicauca.edu.co');

INSERT INTO `Docentes` (`idDocente`, `nombre_docente`, `apellidos_docente`, `nombre_grupo`, `correo`) 
VALUES (20, 'María', 'López', 'GIDATI', 'maria.lopez@unicauca.edu.co');

INSERT INTO `Docentes` (`idDocente`, `nombre_docente`, `apellidos_docente`, `nombre_grupo`, `correo`) 
VALUES (30, 'Carlos', 'Rodríguez', 'GIDATI', 'carlos.rodriguez@unicauca.edu.co');

-- Roles
INSERT INTO `Roles` (`idRol`, `rol_asignado`) 
VALUES (1, 'Director');

INSERT INTO `Roles` (`idRol`, `rol_asignado`) 
VALUES (2, 'Coordinador');

INSERT INTO `Roles` (`idRol`, `rol_asignado`) 
VALUES (3, 'Evaluador');

-- Historicos
INSERT INTO `Historicos` (`idHistoricos`, `idDocente`, `idRol`, `activo`, `fechaInicio`, `fechaFin`) 
VALUES (1, 10, 1, 1, '2023-01-01', NULL);

INSERT INTO `Historicos` (`idHistoricos`, `idDocente`, `idRol`, `activo`, `fechaInicio`, `fechaFin`) 
VALUES (2, 20, 2, 1, '2023-01-01', NULL);

INSERT INTO `Historicos` (`idHistoricos`, `idDocente`, `idRol`, `activo`, `fechaInicio`, `fechaFin`) 
VALUES (3, 30, 3, 1, '2023-01-01', NULL);

-- FormatosA
INSERT INTO `FormatosA` (`idFormatoA`, `nombre_director`, `objetivo_general`, `objetivos_especificos`, `titulo`, `idDocente`) 
VALUES (1, 'Juan Robles', 'Desarrollar una aplicación web para la gestión de formatos de propuestas de trabajo de grado', 
'1. Diseñar la arquitectura de la aplicación\n2. Implementar la interfaz de usuario\n3. Desarrollar la lógica de negocio', 
'Sistema de Gestión de Formatos de Propuestas de Trabajo de Grado', 10);

-- Estados
INSERT INTO `Estados` (`idEstado`, `estado_actual`, `fecha_registro_estado`, `idFormatoA`) 
VALUES (1, 'En formulación', '2023-04-01', 1);

-- FormatosPPA
INSERT INTO `FormatosPPA` (`idFormatoA`, `nombre_asesor`, `nombre_estudiante1`, `ruta_carta_aceptacion`) 
VALUES (1, 'María López', 'Carlos Rodríguez', '/documentos/carta_aceptacion.pdf');

-- Evaluaciones
INSERT INTO `Evaluaciones` (`idEvaluacion`, `concepto`, `fecha_registro_concepto`, `nombre_coordinador`, `idFormatoA`) 
VALUES (1, 'Por corregir', '2023-04-15', 'Coordinador de Posgrados', 1);

-- Observaciones
INSERT INTO `Observaciones` (`idObservacion`, `observacion`, `fecha_registro_observacion`, `idEvaluacion`) 
VALUES (1, 'Se requiere mejorar la redacción del objetivo general', '2023-04-16', 1);

INSERT INTO `Observaciones` (`idObservacion`, `observacion`, `fecha_registro_observacion`, `idEvaluacion`) 
VALUES (2, 'Agregar más detalles sobre la metodología a utilizar', '2023-04-16', 1);