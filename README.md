# Taller JPA - Gestión de Trabajos de Grado FIET

## Descripción del Proyecto
Este proyecto tiene como objetivo implementar una aplicación para gestionar los formatos de propuestas de trabajo de grado (FormatoPP-A y FormatoTI-A) de la Facultad de Ingeniería Electrónica y Telecomunicaciones (FIET) de la Universidad del Cauca. Utiliza JPA (Java Persistence API) para definir relaciones entre entidades, acciones en cascada, transacciones y herencia.

## Requisitos Previos
- Java 17
- Maven.
- Base de datos configurada (MySQL).
- IDE compatible con Spring Boot (IntelliJ, VScode, etc.).

---

## Estructura de Entidades y Relaciones
### Entidades Principales
1. **FormatoA** (Clase base abstracta con herencia):
   - Atributos: `id`, `titulo` (único), `fechaRegistro`.
   - Subclases: `FormatoPPA` y `FormatoTIA`.
   - Relaciones:
     - `@OneToOne` con `Estado` (cascada: persist).
     - `@ManyToOne` con `Docente` (director).
     - `@OneToMany` con `Evaluacion`.

2. **Estado**:
   - Atributos: `id`, `nombre` (ej: "En formulación"), `fechaRegistro`.
   - `@OneToOne` inversa a `FormatoA` (clave foránea única).

3. **Docente**:
   - Atributos: `id`, `nombre`, `correo` (único), `roles`.
   - Relaciones:
     - `@OneToMany` con `FormatoA`.
     - `@ManyToMany` con `Comite` (roles y fechas).

4. **Evaluacion**:
   - Atributos: `id`, `concepto` (ej: "Por corregir").
   - `@OneToMany` con `Observacion`.

5. **Observacion**:
   - Atributos: `id`, `descripcion`, `fecha`.
   - `@ManyToOne` con `Docente` y `Evaluacion`.

### Convenciones
- **Nombres de tablas**: En plural (ej: `formatos_a`, `docentes`).
- **Anotaciones**: Uso de `@Column` para detalles como unicidad (`unique = true`) y restricciones.

---

## Configuración
1. **Base de Datos**:
   - Configurar `application.properties` con URL, usuario y contraseña.
   - Ejemplo para H2 (desarrollo):
     ```properties
     spring.datasource.url=jdbc:h2:mem:testdb
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=root
     spring.datasource.password=
     spring.h2.console.enabled=true
     ```

2. **Herencia**:
   - Estrategia elegida: `JOINED` con discriminador para `FormatoA`.

---

## Métodos Implementados
### 1. Crear Formato A (`crearFormatoA`)
- **Funcionalidad**: Crea un formato (PP-A o TI-A) y asocia un estado inicial "En formulación".
- **Cascada**: Persistencia automática de `Estado` y `Docente` (si no existe).
- **Transacción**: `@Transactional(readOnly = false)`.

### 2. Crear Observación (`crearObservacion`)
- **Funcionalidad**: Asocia una observación a una evaluación existente o crea una nueva evaluación sin concepto.
- **Referencias**: Usa `getReferenceById` para obtener `Docente` y `Evaluacion`.

### 3. Listar Observaciones (`listarObservaciones`)
- **Fetch**: `EAGER` para `Evaluacion` y `Docente`.
- **Salida**: Muestra formato A, estado, evaluación y observaciones.

### 4. Listar Miembros del Comité (`listarMiembrosComite`)
- **Fetch**: `LAZY` para roles.
- **Salida**: Docentes, roles, fechas de inicio y fin.

### 5. Consultar Formatos por Docente (`consultarFormatosPorDocente`)
- **Fetch**: `EAGER` para formatos A y `LAZY` para evaluaciones.
- **Salida**: Lista de formatos asociados al docente.

---

## Scripts
1. **Importar Datos**:
   - Ejecutar scripts SQL almacenados en `import.sql` para registros iniciales (docentes, roles, etc.).

---

## Consideraciones Adicionales
- **Acciones en Cascada**: `persist` y `remove` configuradas en relaciones críticas.
- **Transacciones**: Todos los métodos públicos usan `@Transactional` con `readOnly` según corresponda.
- **Colaboración**: Proyecto desarrollado en parejas (indicar nombres en el código).

---

## Licencia
Este proyecto está bajo licencia MIT. Ver [LICENSE](LICENSE) para más detalles.
