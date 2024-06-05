# Usa a imagem oficial do OpenJDK 11
FROM openjdk:17-jdk

# Define o diretório de trabalho como /app
WORKDIR /app

# Copia o arquivo JAR do aplicativo Spring Boot para o contêiner
COPY ./target/*.jar app.jar

# Expõe a porta definida para o Spring Boot
EXPOSE 8080

# Comando a ser executado quando o contêiner for iniciado
CMD ["java", "-jar", "app.jar"]
