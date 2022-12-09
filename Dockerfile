FROM openjdk:11

ADD /target/anime_shop-0.0.1-SNAPSHOT.jar anime-backend.jar

ENTRYPOINT ["java", "-jar", "anime-backend.jar"]
