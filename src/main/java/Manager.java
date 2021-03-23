import com.sun.istack.NotNull;

import javax.persistence.*;

    @Entity
    @Table(name = "manager")
    public class Manager {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;
        @NotNull
        @Column(name = "name", nullable = false)
        private String name;
        @NotNull
        @Column(name = "surname", nullable = false)
        private String surname;
        @NotNull
        @Column(name = "password", nullable = false)
        private String password;

        public Manager() {
        }

        public Manager( String name, String surname, String password) {
            this.name = name;
            this.surname = surname;
            this.password = password;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
