terraform {
  required_providers {
    docker = {
      source  = "kreuzwerker/docker"
      version = "~> 3.0"
    }
  }
}

provider "docker" {}

resource "docker_image" "cen4802" {
  name         = "cen4802:latest"
  keep_locally = true
}

resource "docker_container" "cen4802" {
  image = docker_image.cen4802.image_id
  name  = var.container_name
}