@echo off

docker compose down food-service
docker rmi restaurant-app-food-service:latest