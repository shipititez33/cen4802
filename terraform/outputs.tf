output "container_name" {
  description = "Name of the Docker container created by Terraform"
  value       = docker_container.cen4802.name
}