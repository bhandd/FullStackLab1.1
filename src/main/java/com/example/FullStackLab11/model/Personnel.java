package com.example.FullStackLab11.model;

public class Personnel extends User{

        private String role;

        public Personnel(int id, String name, String role) {
            super(id, name);
            this.role = role;
        }

        public Personnel(){

        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }
}
