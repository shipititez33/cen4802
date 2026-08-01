variable "image_name" {
  description = "Docker image used by Terraform"
  type        = string
  default     = "cen4802-final:v1"
}

variable "container_name" {
  description = "Name of the Docker container created by Terraform"
  type        = string
  default     = "cen4802-terraform-container"
}
