variable "instance_name" {
  description = "This Instance will use for kubernetes deployment"
  type        = string
  default     = "KubernetesInstanceMaster"
}
variable "key_pair" {
  default = "ec2_key"
  type    = string
}