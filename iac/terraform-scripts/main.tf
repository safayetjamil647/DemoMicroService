terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }

  required_version = ">= 0.14.9"
}

provider "aws" {
  profile = "default"
  region  = "us-west-2"
}

resource "aws_instance" "app_server" {
  ami           = "ami-0892d3c7ee96c0bf7"
  instance_type = "t2.micro"
  key_name= var.key_pair
  tags = {
    Name = var.instance_name
  }
  #  provisioner "remote-exec" {
  #   inline = [
  #     "touch hello.txt",
  #     "echo helloworld remote provisioner >> hello.txt",
  #   ]
  # }
  # connection {
  #     type        = "ssh"
  #     host        = self.public_ip
  #     user        = "ubuntu"
  #     private_key = file("~/.ssh/EC2New")
  #     timeout     = "4m"
  #  }
}

# keypair in key pairs
resource "aws_key_pair" "deployer" {
  key_name   = var.key_pair
  public_key = "ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQC2EbBNIMDBz7mGvx5BsHvqVxgX+CfR9Bq1pzskgGDRr/OTmlalxbMDLkp364VIphbdyOwfgF8obIzv1p2h5MczW/1MB1vtvM6/V2pLP2HDB1BL0rrIEV8/i/qQT8zF0zsuNb4SsMasKHN6uCJcMKN0Gpk26ZENSaLiQOP4OL1SFXny1XavXHp9g0oEL6GfpGrkUabYItOM+1JAM/YdPjpUfpw/HEh37h24nw14knpI//IpRIJHWn6PYec7hOD14Sis+t5k/NAYkrT0AyBFJkFTmMA0lpKjuSlmjtIjt1pDbD6uq3sRI2iw2StBgtVWAOJmA2x5biYIXZM+dU30LdRr safayet@safayet-MS-7D17"
}

