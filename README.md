# Fitlife MS-gateway

API Gateway para FitLife. Este servicio actúa como punto de entrada único para todos los microservicios, manejando enrutamiento, balanceo de carga y fallbacks.

## Características

- **API Gateway**: Punto de entrada único para todos los microservicios
- **Enrutamiento**: Redirección inteligente a los microservicios correspondientes
- **Fallbacks**: Manejo de errores y respuestas de fallback
- **Balanceo de Carga**: Distribución de tráfico entre instancias
- **REST API**: Endpoints para health check y fallbacks

## Tecnologías

- Java 17
- Spring Boot 3.2.0
- Spring Cloud Gateway
- Maven
- Docker

## Endpoints

### Health Check
- `GET /gateway/health` - Verificar estado del gateway

### Fallbacks
- `GET /gateway/fallback` - Respuesta de fallback cuando un servicio no está disponible

## Configuración

### Variables de Entorno

```env
SPRING_CLOUD_GATEWAY_ROUTES_USUARIOS_URI=http://ms-usuarios:8085
SPRING_CLOUD_GATEWAY_ROUTES_RESERVAS_URI=http://ms-reservas:8083
SPRING_CLOUD_GATEWAY_ROUTES_PAGOS_URI=http://ms-gestion-pago:8086
SPRING_CLOUD_GATEWAY_ROUTES_NOTIFICACIONES_URI=http://ms-notificaciones:8084
SPRING_CLOUD_GATEWAY_ROUTES_LOCATIONS_URI=http://ms-location:8082
```

## Desarrollo

### Compilar el proyecto
```bash
mvn clean package
```

### Ejecutar localmente
```bash
mvn spring-boot:run
```

## Docker

### Construir imagen
```bash
docker build -t fitlife-gateway:latest .
```

### Ejecutar contenedor
```bash
docker run -p 8080:8080 \
  -e SPRING_CLOUD_GATEWAY_ROUTES_USUARIOS_URI=http://ms-usuarios:8085 \
  -e SPRING_CLOUD_GATEWAY_ROUTES_RESERVAS_URI=http://ms-reservas:8083 \
  fitlife-gateway:latest
```

## GitHub Actions

Este repositorio utiliza GitHub Actions para CI/CD:

- **Build**: Compila el proyecto con Maven
- **Docker Build**: Construye la imagen Docker
- **Docker Push**: Sube la imagen a Docker Hub

## Contribución

1. Fork el repositorio
2. Crea una rama para tu feature (`git checkout -b feature/nueva-funcionalidad`)
3. Commit tus cambios (`git commit -m 'Agrega nueva funcionalidad'`)
4. Push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

## Licencia

Este proyecto es parte de FitLife Gym Management System.
