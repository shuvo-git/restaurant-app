@echo off

docker compose down customer-service
docker rmi restaurant-app-customer-service:latest